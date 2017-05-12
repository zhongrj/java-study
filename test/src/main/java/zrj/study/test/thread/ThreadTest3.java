package zrj.study.test.thread;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/9
 */
public class ThreadTest3 {

    public static void main(String[] args) {
        final Inner inner = new Inner();
        new Thread() {
            @Override
            public void run() {
                try {
                    inner.a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    inner.b();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    inner.c();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    inner.d();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    inner.e();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    private static class Inner{

        public synchronized void a() throws InterruptedException {
            int i = 0;
            while (i++ < 5) {
                System.out.println("a " + i);
                Thread.sleep(1000);
            }
        }

        private synchronized void b() throws InterruptedException {
            int i = 0;
            while (i++ < 5) {
                System.out.println("b " + i);
                Thread.sleep(1000);
            }
        }

        private void c() throws InterruptedException {
            synchronized (this) {
                int i = 0;
                while (i++ < 5) {
                    System.out.println("c " + i);
                    Thread.sleep(1000);
                }
            }
        }

        private synchronized static void d() throws InterruptedException {
            int i = 0;
            while (i++ < 5) {
                System.out.println("d " + i);
                Thread.sleep(1000);
            }
        }

        private synchronized static void e() throws InterruptedException {
            int i = 0;
            while (i++ < 5) {
                System.out.println("e " + i);
                Thread.sleep(1000);
            }
        }
    }

}
