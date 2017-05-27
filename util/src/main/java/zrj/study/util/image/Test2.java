package zrj.study.util.image;

import zrj.study.util.algorithm.Kmeans1;
import zrj.study.util.validate.ValidateCodeUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/26
 */
public class Test2 {

    public static void main(String[] args) {
        List<BufferedImage> imgList = new ArrayList<>();
        BufferedImage img;


        int len = 4;
        // 创建随机验证码
        imgList.add(img = ValidateCodeUtils.createImage(ValidateCodeUtils.createRandomCode(len), 50*len, 70));

        Kmeans1 k = new Kmeans1(len+1);
        ArrayList<float[]> dataSet = new ArrayList<float[]>();
        int width = img.getWidth();
        int height = img.getHeight();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color color = new Color(img.getRGB(x, y));
                int z = color.getRed() + color.getGreen() + color.getBlue();
                float[] point = new float[]{x, y, z*0.5f};
                dataSet.add(point);
            }
        }

        k.setDataSet(dataSet);
        //执行算法
        k.execute();
        //得到聚类结果
        ArrayList<ArrayList<float[]>> cluster = k.getCluster();
        for (ArrayList<float[]> points : cluster) {
            imgList.add(cutout(points, img));
        }

        Test.showImg(imgList);

    }

    private static BufferedImage cutout(ArrayList<float[]> points, BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (float[] point : points) {
            result.setRGB((int) point[0], (int) point[1], Color.WHITE.getRGB());
        }
        return result;
    }


}
