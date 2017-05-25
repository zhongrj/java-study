package zrj.study.util.image;

import org.bouncycastle.LICENSE;
import zrj.study.util.validate.ValidateCodeUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/20 0020.
 * http://www.2cto.com/article/201306/220563.html
 */
public class Test {

    private static final BufferedImage[] IMAGES_DATA = new BufferedImage[10];
    private static final double ISOLATED_COEFFICIENT = 0.01;


    public static void main(String[] args) {
        List imgList = new ArrayList<BufferedImage>();
        BufferedImage img, twoColorImg, onlyStringImg, trimedImg;

        // 创建随机验证码
        imgList.add(img = ValidateCodeUtils.createImage("123", 120, 70));
        // 图片二值化
        imgList.add(twoColorImg = getBlackOrWhiteImg(img));
        // 去除孤立点
        imgList.add(onlyStringImg = rmIsolated(twoColorImg));
        // 去除无用边界
        imgList.add(trimedImg = trim(onlyStringImg));
        // 分割为单字符图

//        // 去除无用边界
//        BufferedImage trimedImg = trim(onlyStringImg);

        showImg(imgList);


//        prepareData();
//        showImg(IMAGES_DATA);
    }


    public static BufferedImage getBlackOrWhiteImg(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (isWhite(img.getRGB(x, y))) {
                    result.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    result.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }
        return result;
    }

    private static boolean isWhite(int rgb) {
        Color color = new Color(rgb);
        return (color.getRed() + color.getGreen() + color.getBlue() > 500);
    }


    public static void showImg(List<BufferedImage> imgs) {
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

        for (int i = 0; i < IMAGES_DATA.length; i++) {
            BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            Graphics g = img.getGraphics();
            g.fillRect(0, 0, w, h);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, w));
            g.drawString(String.valueOf(i), 0, 100);
            img = trim(img);
            IMAGES_DATA[i] = img;
        }
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
                if (isIsolated(img, x, y, dx, dy)) {
                    result.setRGB(x, y, Color.WHITE.getRGB());
                } else {
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
        Color BLACK = Color.BLACK;
        int x1 = x - dx, x2 = x + dx,
                y1 = y - dy, y2 = y + dy;
        x1 = (x1 < 0) ? x : x1;
        y1 = (y1 < 0) ? y : y1;
        x2 = (x2 >= w) ? x : x2;
        y2 = (y2 >= h) ? y : y2;

        return !(BLACK.equals(new Color(img.getRGB(x1, y1)))
                && BLACK.equals(new Color(img.getRGB(x1, y)))
                && BLACK.equals(new Color(img.getRGB(x1, y2)))
                && BLACK.equals(new Color(img.getRGB(x, y1)))
                && BLACK.equals(new Color(img.getRGB(x, y)))
                && BLACK.equals(new Color(img.getRGB(x, y2)))
                && BLACK.equals(new Color(img.getRGB(x2, y1)))
                && BLACK.equals(new Color(img.getRGB(x2, y)))
                && BLACK.equals(new Color(img.getRGB(x2, y2))));
    }


}
