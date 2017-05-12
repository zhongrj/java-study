package zrj.study.test.thread;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/8
 */
public class ThreadTest1 extends Thread {

    private int a = 1;

    @Override
    public void run() {
        while (true) {
            System.out.println(a++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest1 threadTest1 = new ThreadTest1();
        threadTest1.start();

        Thread.sleep(2000);
        threadTest1.suspend();

        Thread.sleep(2000);
        threadTest1.resume();

        Thread.sleep(2000);
        threadTest1.stop();
    }
}
