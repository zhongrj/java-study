package zrj.study.test.thread;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/9
 */
public class ThreadTest4 {

    public static void main(String[] args) {
        Inner inner = new Inner();
        new Thread(){
            @Override
            public void run() {
                inner.product();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                inner.comsume();
            }
        }.start();
    }

    private static class Inner {
        private Object lock = new Object();
        private int item = 0;

        public void product() {
            synchronized (lock) {
                // synchronized (lock) 不行 wait notifyAll 是对应this的方法, 必须拥有this锁的线程才可以执行
                // 但是 synchronized (lock) lock.wait()可以
                // 反正wait notifyAll是对应synchronized锁的对象的
                // 否则会抛IllegalMonitorStateException异常
                while (true) {
                    if (item >= 10) {
                        System.out.println("产品已满");
                        try {
                            lock.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("wait结束");
                    }
                    System.out.println("生产产品 剩余 " + ++item);
//                    lock.notifyAll();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public /*synchronized*/ void comsume() {
            synchronized (lock) {
                while (true) {
                    if (item <= 0) {
                        System.out.println("产品已空");
                        try {
                            lock.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("wait结束");
                    }
                    System.out.println("消费产品 剩余 " + --item);
//                    lock.notifyAll();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
