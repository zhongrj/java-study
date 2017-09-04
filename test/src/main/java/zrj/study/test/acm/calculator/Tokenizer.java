package zrj.study.test.acm.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 词法解析
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/28
 */
public class Tokenizer {

    public static void main(String[] args) {
        System.out.println(tokenize("312 * (11 + 12 / (3 + 3))"));
    }

    private final static int STATUS_NUM = 1;
    private final static int STATUS_OPERATOR = 2;
    private final static int STATUS_PAREN = 3;

    public static List<String> tokenize(String string) {
        List<String> list = new ArrayList<>();
        StringBuffer sb = null;
        int status = 0;
        for (char c : string.toCharArray()) {
            if (!isTargetChar(c)) {
                throw new RuntimeException(String.format("无法识别该字符: %s", c));
            } else if (isNumber(c)) {
                if (status != STATUS_NUM && sb != null) {
                    list.add(sb.toString());
                }
                if (status != STATUS_NUM || sb == null) {
                    sb = new StringBuffer();
                }
                sb.append(c);
                status = STATUS_NUM;
            } else if (isOperator(c)) {
                if (/*status != STATUS_OPERATOR && */sb != null) {
                    list.add(sb.toString());
                }
                sb = new StringBuffer();
                sb.append(c);
                status = STATUS_OPERATOR;
            } else if (isParen(c)) {
                if (/*status != STATUS_PAREN && */sb != null) {
                    list.add(sb.toString());
                }
                sb = new StringBuffer();
                sb.append(c);
                status = STATUS_PAREN;
            }
        }
        if (sb != null) {
            list.add(sb.toString());
        }

        return list;
    }

    private static boolean isParen(char c) {
        return "()".indexOf(c) > -1;
    }

    private static boolean isOperator(char c) {
        return "+-*/".indexOf(c) > -1;
    }

    private static boolean isNumber(char c) {
        return Character.isDigit(c);
    }

    private static boolean isTargetChar(char c) {
        return isNumber(c) || isOperator(c) || isParen(c) || c == ' ';
    }

}
