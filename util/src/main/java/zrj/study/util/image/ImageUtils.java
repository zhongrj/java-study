package zrj.study.util.image;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/8
 */
public class ImageUtils {

    public static void showImage(BufferedImage... images) {
        showImage(Arrays.asList(images));
    }

    public static void showImage(Collection<BufferedImage> images) {
        JFrame frame = new JFrame("Show Image");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        for (BufferedImage image : images) {
            panel.add(new JLabel(new ImageIcon(image)));
        }
        frame.setVisible(true);
    }

}
