package zrj.study.test.acm.calculator;

import java.util.List;

/**
 * 算式解析
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/28
 */
public class Calculator {

    public static void main(String[] args) {
        System.out.println(cal("31 + 5 * 29 - 81"));
    }

    public static int cal(String str) {

        List<String> tokens = Tokenizer2.tokenize(str);
        System.out.println("after tokenize: " + tokens);

        Parser.parse(tokens);

        return 0;
    }

}
