package zrj.study.test.acm.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则词法解析
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/28
 */
public class Tokenizer2 {
    
    public static void main(String[] args) {
        System.out.println(tokenize("312 * (11 + 12 / (3 + 3))"));
    }

    public static List<String> tokenize(String s) {
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\s*(\\d+|\\(|\\)|\\+|\\-|\\*|\\/)\\s*");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
        return list;
    }

}
