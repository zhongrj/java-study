package zrj.study.test.jvm;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/8
 */
public class PrintGCTest1 {
    public static void main(String[] args) throws InterruptedException {

        int i = 0;
        byte[] bytes;
        while (i++ < 10000000) {
//            new PrintGCTest1();
            bytes = new byte[1024];
//            if (i % 1000000 == 0) {
//                Thread.sleep(100);
//            }
        }


        byte[] bytes1, bytes2, bytes3, bytes4;
        bytes1 = new byte[1024];
//        bytes2 = new byte[1024];
//        bytes3 = new byte[1024];
//        bytes4 = new byte[1024];


        Thread.sleep(1000);

        System.out.println(bytes1[1023]);
//        System.out.println(bytes2);
//        System.out.println(bytes3);
//        System.out.println(bytes4);

    }
}
