package zrj.study.test.java8;

import org.junit.Test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/22
 */
public class JsEngineTest {


    static ScriptEngine engine;
    static {
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName( "JavaScript" );
    }

    @Test
    public void test() throws ScriptException {
        System.out.println( engine.getClass().getName() );
        System.out.println( "Result:" + engine.eval( "function f() { return 1; }; print(f()); f() + 1;" ) );    //console.log不行
    }
}
