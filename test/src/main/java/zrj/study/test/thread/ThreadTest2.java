package zrj.study.test.thread;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/8
 */
public class ThreadTest2 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        final Object lock = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        System.out.println("线程1 ing");
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (lock) {
                    while (true) {
                        System.out.println("线程2 ing");
                        try {
                            Thread.sleep(800);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t2.start();

        Thread.sleep(5000);
        t1.wait();
    }

}
