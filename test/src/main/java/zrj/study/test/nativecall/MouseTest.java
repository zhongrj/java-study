package zrj.study.test.nativecall;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/22
 */
public class MouseTest {
    public static void main(String[] args)
    {
        try
        {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Robot robot = new Robot();
            robot.mouseMove(screenSize.width - 30, 5);
            robot.delay(1000);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.delay(300);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
        catch (AWTException e)
        {
            e.printStackTrace();
        }
    }
}
