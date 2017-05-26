package zrj.study.util.image;

import zrj.study.util.validate.ValidateCodeUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 * http://www.2cto.com/article/201306/220563.html
 */
public class Test {

    private static final Map<BufferedImage, String> IMAGES_DATA = new HashMap<>();
    private static final double ISOLATED_COEFFICIENT = 0.02;


    public static void main(String[] args) {

        prepareData();
//        showImg(IMAGES_DATA.keySet());


        List<BufferedImage> imgList = new ArrayList<>();
        BufferedImage img, twoColorImg, onlyStringImg, onlyOriginString;
        List<BufferedImage> imgsSplited, imgsSplitedTrimed, imgsMatchMost;

        int len = 4;
        // 创建随机验证码
        imgList.add(img = ValidateCodeUtils.createImage(ValidateCodeUtils.createRandomCode(len), 50*len, 70));
        // 图片二值化
        imgList.add(twoColorImg = getBlackOrWhiteImg(img));
        // 去除孤立点
        imgList.add(onlyStringImg = rmIsolated(twoColorImg));
        imgList.add(onlyStringImg = rmIsolated(onlyStringImg));
        imgList.add(onlyStringImg = rmIsolated(onlyStringImg));
        // 原图只留下有效部分
        imgList.add(onlyOriginString = keepStringOnly(img, onlyStringImg));
        // 分隔有效部分
        imgList.addAll(imgsSplited = splitImgByColor(onlyOriginString));
        // 去除无用边界
        imgList.addAll(imgsSplitedTrimed = trim(imgsSplited));

        // 比对
        imgList.addAll(imgsMatchMost = findImg(imgsSplitedTrimed));


        System.out.println("识别为：");
        for (BufferedImage image : imgsMatchMost) {
            System.out.print(IMAGES_DATA.get(image));
        }

        showImg(imgList);

    }

    private static List<BufferedImage> findImg(List<BufferedImage> imgsSplitedTrimed) {
        List<BufferedImage> list = new ArrayList<>();
        for (BufferedImage img : imgsSplitedTrimed) {
            double maxRate = 0.0;
            BufferedImage target = null;
            for (BufferedImage source : IMAGES_DATA.keySet()) {
                double thisRate = getLikelyRate(img, source);
                if (thisRate > maxRate) {
                    maxRate = thisRate;
                    target = source;
                }
            }
            list.add(target);
        }
        return list;
    }

    private static double getLikelyRate(BufferedImage img, BufferedImage source) {
        double width = source.getWidth();
        double height = source.getHeight();
        double xr = (img.getWidth() - 1) / (width - 1);
        double yr = (img.getHeight() - 1) / (height - 1);
        double same = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (source.getRGB(x, y) == img.getRGB((int) (x * xr), (int) (y * yr))) {
                    same++;
                }
            }
        }
        return same / width / height;
    }

    private static List<BufferedImage> splitImgByColor(BufferedImage onlyOriginString) {
        // 以同一颜色分割
        List<BufferedImage> list = new ArrayList();
        Map<Integer, BufferedImage> map = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        int width = onlyOriginString.getWidth();
        int height = onlyOriginString.getHeight();
        int all = width * height;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = onlyOriginString.getRGB(x, y);
                if (Color.BLACK.getRGB() == rgb) {
                    continue;
                }
                BufferedImage img = map.get(rgb);
                if (null == img) {
                    img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                    list.add(img);
                    map.put(rgb, img);
                    colorCount.put(rgb, 0);
                }
                colorCount.put(rgb, colorCount.get(rgb) + 1);
                img.setRGB(x, y, Color.WHITE.getRGB());
            }
        }
        for (int i : colorCount.keySet()) {
            if (colorCount.get(i) < all * 0.02) {
                list.remove(map.get(i));
            }
        }
        map = null;
        colorCount = null;
        return list;
    }


    private static BufferedImage keepStringOnly(BufferedImage img, BufferedImage onlyStringImg) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (Color.WHITE.getRGB() == onlyStringImg.getRGB(x, y)){
                    result.setRGB(x, y, img.getRGB(x, y));
                }
            }
        }
        return result;
    }


    public static BufferedImage getBlackOrWhiteImg(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (isWhite(img.getRGB(x, y))) {
                    result.setRGB(x, y, Color.WHITE.getRGB());
                }
            }
        }
        return result;
    }

    private static boolean isWhite(int rgb) {
        Color color = new Color(rgb);
        return (color.getRed() + color.getGreen() + color.getBlue() < 500);
    }


    public static void showImg(Collection<BufferedImage> imgs) {
        JFrame frame = new JFrame("展示图片");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        for (BufferedImage img : imgs) {
            panel.add(new JLabel(new ImageIcon(img)));
        }
        frame.setVisible(true);
    }


    /**
     * 准备数据
     */
    public static void prepareData() {
        int w = 100, h = 100;
        char[] code_array = ValidateCodeUtils.CODE_ARRAY;
        for (int i = 0; i < code_array.length; i++) {
            String str = String.valueOf(code_array[i]);
            IMAGES_DATA.put(getImg(w, h, str, "Arial"), str);
            IMAGES_DATA.put(getImg(w, h, str, "Calibri"), str);
            IMAGES_DATA.put(getImg(w, h, str, "Arial Black"), str);
        }
    }

    private static BufferedImage getImg(int w, int h, String str, String font) {
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();
        g.setColor(Color.WHITE);
        g.setFont(new Font(font, Font.BOLD, w));
        g.drawString(str, 0, h);
        img = trim(img);
        return img;
    }


    private static List<BufferedImage> trim(Collection<BufferedImage> c) {
        List<BufferedImage> list = new ArrayList<>();
        for (BufferedImage img : c) {
            list.add(trim(img));
        }
        return list;
    }

    /**
     * 去除空白无用边界
     */
    private static BufferedImage trim(BufferedImage img) {

        int width = img.getWidth(), height = img.getHeight();
        int minY = 0, maxY = 0,
                minX = 0, maxX = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (!isWhite(img.getRGB(x, y))) {
                    if (y > maxY) {
                        maxY = y;
                    }
                    if (minY ==0 || y < minY) {
                        minY = y;
                    }
                }
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (!isWhite(img.getRGB(x, y))) {
                    if (x > maxX) {
                        maxX = x;
                    }
                    if (minX == 0 || x < minX) {
                        minX = x;
                    }
                }
            }
        }

        BufferedImage result = img.getSubimage(minX, minY, maxX - minX, maxY - minY);
        return result;
    }


    /**
     * 去除孤立点
     */
    public static BufferedImage rmIsolated(BufferedImage img) {

        int width = img.getWidth(), height = img.getHeight();
        int dx = (int) (width * ISOLATED_COEFFICIENT), dy = (int) (height * ISOLATED_COEFFICIENT);

        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (!isIsolated(img, x, y, dx, dy)) {
                    result.setRGB(x, y, img.getRGB(x, y));
                }
            }
        }
        return result;
    }



    /**
     * 判断是否为孤立点
     */
    private static boolean isIsolated(BufferedImage img, int x, int y, int dx, int dy) {
//        if (true) {
//            return true;
//        }
        int w = img.getWidth(), h = img.getHeight();
        int x1 = x - dx, x2 = x + dx,
                y1 = y - dy, y2 = y + dy;
        x1 = (x1 < 0) ? x : x1;
        y1 = (y1 < 0) ? y : y1;
        x2 = (x2 >= w) ? x : x2;
        y2 = (y2 >= h) ? y : y2;

        int i = 0;
        if (Color.WHITE.getRGB() == img.getRGB(x1, y1)) i++;
        if (Color.WHITE.getRGB() == img.getRGB(x1, y)) i++;
        if (Color.WHITE.getRGB() == img.getRGB(x1, y2)) i++;
        if (Color.WHITE.getRGB() == img.getRGB(x, y1)) i++;
        if (Color.WHITE.getRGB() == img.getRGB(x, y)) i++;
        if (Color.WHITE.getRGB() == img.getRGB(x, y2)) i++;
        if (Color.WHITE.getRGB() == img.getRGB(x2, y1)) i++;
        if (Color.WHITE.getRGB() == img.getRGB(x2, y)) i++;
        if (Color.WHITE.getRGB() == img.getRGB(x2, y2)) i++;

        return i < 5;
    }


}
