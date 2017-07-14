package zrj.study.test.thread;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/3
 */
public class ThreadTest5 {


    public static void main(String[] args) {
        int i = 1;

        Thread t = new Thread(() -> {
            while (true) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        i++;
    }


}
