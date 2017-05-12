package zrj.study.test.spring.ioc;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/10
 */
public abstract class Animal {
    private boolean canRun;

    public boolean isCanRun() {
        return canRun;
    }

    public void setCanRun(boolean canRun) {
        this.canRun = canRun;
    }

    public void run() {
        if (canRun) {
            System.out.println("I can run");
        }
    }
}
