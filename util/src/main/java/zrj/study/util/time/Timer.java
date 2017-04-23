package zrj.study.util.time;

import zrj.study.util.math.MathUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 定时器
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/21
 */
public class Timer {

    private List<Action> actions;
    private int status; // 0未启动 1已启动

    public Timer() {
        this(new ArrayList<Action>());
    }

    public Timer(List<Action> actions) {
        this.actions = actions;
    }

    public void addAction(Action action) {
        if (status == 1) {
            throw new RuntimeException("定时器已启动");
        }
        actions.add(action);
    }

    public void start() {

        status = 1;

        if (actions.isEmpty()) {
            return;
        }

        long maxCommonDivisor = actions.get(0).getInterval();
        long minCommonMultiple = actions.get(0).getInterval();
        for (Action action : actions) {
            long temp = maxCommonDivisor;
            maxCommonDivisor = MathUtils.maxCommonDivisor(maxCommonDivisor, action.getInterval());
            minCommonMultiple = temp * action.getInterval() / maxCommonDivisor;
            if (maxCommonDivisor == 1L) break;
        }
        final long minInterval = maxCommonDivisor;
        final long maxInterval = minCommonMultiple;

        new Thread(){
            @Override
            public void run() {
                long interval = 0L;

                while (true) {
                    interval %= maxInterval;

                    for (Action action : actions) {
                        if (interval % action.getInterval() == 0) {
                            action.action();
                        }
                    }

                    try {
                        Thread.sleep(minInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    interval += minInterval;
                }
            }
        }.start();
    }


    public static abstract class Action {

        private long interval;

        public long getInterval() {
            return interval;
        }

        public void setInterval(long interval) {
            this.interval = interval;
        }

        public abstract void action();
    }


    /**
     * 测试方法
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        Action action1 = new Action(){
            @Override
            public void action() {
                System.out.println("action1");
            }
        };
        action1.setInterval(400L);
        Action action2 = new Action(){
            @Override
            public void action() {
                System.out.println("action2");
            }
        };
        action2.setInterval(600L);
        timer.addAction(action1);
        timer.addAction(action2);

        timer.start();
    }

}
