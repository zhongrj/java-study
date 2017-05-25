package zrj.study.util.validate;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码工具
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/26
 */
public class ValidateCodeUtils {

    private static final char[] CODE_ARRAY = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
            'K', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final int CODE_ARRAY_LENGTH = CODE_ARRAY.length;
    private static final Random RANDOM_GENERATOR = new Random();


    /**
     * 生成随机验证码
     *
     * @param length 验证码长度
     * @return
     */
    public static String createRandomCode(int length) {
        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            chars[i] = CODE_ARRAY[nextInt(CODE_ARRAY_LENGTH)];
        }
        return new String(chars);
    }

    /**
     * 根据验证码生成随机图像
     *
     * @param code   验证码
     * @param width  图像宽度
     * @param height 图像高度
     * @return 图像对象
     */
    public static BufferedImage createImage(String code, int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        drawBackground(graphics, width, height);
        dramCharacter(graphics, code, width, height);
        graphics.dispose();
        return image;
    }


    /**
     * 填充背景
     *
     * @param g 图像对象
     * @param w 宽
     * @param h 高
     */
    private static void drawBackground(Graphics g, int w, int h) {
        // 填充背景
//        g.setColor(getRandColor(220, 250));
        g.fillRect(0, 0, w, h);
        // 加入干扰线条
        for (int i = 0; i < 8; i++) {
            g.setColor(getRandColor(40, 150));
            int x = nextInt(w);
            int y = nextInt(h);
            int x1 = nextInt(w);
            int y1 = nextInt(h);
            g.drawLine(x, y, x1, y1);
        }
    }

    /**
     * 随机颜色
     *
     * @param fc 不懂
     * @param bc 不懂
     * @return 随机颜色
     */
    private static Color getRandColor(int fc, int bc) {
        int f = fc;
        int b = bc;
        Random random = new Random();
        if (f > 255) {
            f = 255;
        }
        if (b > 255) {
            b = 255;
        }
        return new Color(f + random.nextInt(b - f), f + random.nextInt(b - f), f + random.nextInt(b - f));
    }

    /**
     * 填充字符
     *
     * @param g 图像对象
     * @return 验证码
     */
    private static void dramCharacter(Graphics g, String s, int w, int h) {
        String[] fontTypes = {"Arial", "Arial Black", "AvantGarde Bk BT", "Calibri"};

        double baseX = 0.9 * w / s.length(); // * i
        double randomX = 0.1 * w; // 变动极限值
        double baseY = 0.7 * h;
        double randomY = 0.4 * h; // 变动极限值
        double baseSize = 0.8 * h;
        double randomSize = 0.2 * h; // 变动极限值


        for (int i = 0; i < s.length(); i++) {
            g.setColor(new Color(50 + nextInt(100), 50 + nextInt(100), 50 + nextInt(100)));
            g.setFont(new Font(fontTypes[nextInt(fontTypes.length)], Font.BOLD, (int) (baseSize + nextInt((int) (randomSize)))));
            g.drawString(s.substring(i, i + 1), (int) (baseX * i + nextInt((int) (randomX))), (int) (baseY + nextInt((int) (randomY))));
        }
    }

    /**
     * 获得随机数
     *
     * @param bound 极限值
     * @return 随机数
     */
    private static int nextInt(int bound) {
        return RANDOM_GENERATOR.nextInt(bound);
    }

}
