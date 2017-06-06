package zrj.study.test.junit;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/6/6
 */
public class MyRunner extends BlockJUnit4ClassRunner {

    /**
     * Creates a BlockJUnit4ClassRunner to run {@code klass}
     *
     * @param klass
     * @throws InitializationError if the test class is malformed.
     */
    public MyRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Object createTest() throws Exception {
        Object testInstance = super.createTest();
        if (testInstance instanceof Test) {
            ((Test) testInstance).a = "123123";                                         // 这个地方注入...嘿嘿
        }
        return testInstance;
    }

}
