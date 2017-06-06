package zrj.study.zzone.web.controller.console;

import org.junit.Test;
import zrj.study.zzone.web.controller.BaseControllerTest;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/6
 */
public class OptionConsoleTest extends BaseControllerTest {

    @Test
    public void add() throws Exception {
        suAdmin();
        postJsonLogin("/console/option/add", null);
    }


}
