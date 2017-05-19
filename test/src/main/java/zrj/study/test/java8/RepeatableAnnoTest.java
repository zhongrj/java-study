package zrj.study.test.java8;

import java.lang.annotation.*;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/19
 */
public class RepeatableAnnoTest {

    @Target( ElementType.FIELD )
    @Retention( RetentionPolicy.RUNTIME )
    public @interface Clothes {
        Cloth[] value();
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(value = Clothes.class)
    public @interface Cloth{
        String value();
    }




}
