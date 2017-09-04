package zrj.study.test.acm.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/29
 */
public class Parser {

    public static void main(String[] args) {
//        parse(Arrays.asList("31", "+", "5", "+", "29", "*", "123"));
        parse(Tokenizer2.tokenize("21*22-2*13+12"));
    }

    /**
     * Expr1        ->      Expr2 Expr1Tail
     * Expr1Tail    ->      Op1 Expr2
     * |                    null
     * Op1          ->      +
     * |                    -
     * Expr2        ->      Expr3 Expr2Tail
     * Expr2Tail    ->      Op2 Expr3
     * |                    null
     * Op2          ->      *
     * |                    /
     * Expr3        ->      (Expr1)
     * |                    num
     *
     * @param tokens
     */
    public static void parse(List<String> tokens) {
        index = 0;
        Parser.tokens = tokens;
        result = new Stack<>();
        if (expr1() && index == tokens.size()) {
            System.out.println("符合格式");
        }
    }

    // 仅支持单线程
    private static int index = 0;
    private static List<String> tokens;
    private static Stack<String> result;
    private static String quene = "";

    private static boolean expr1() {
        if (expr2() && expr1tail()) {
            return true;
        }
        return false;
    }

    private static boolean expr1tail() {
        if (op1()) {
            if (expr2()) {
                return expr1tail();
            }
            return false;
        }
        return true;
    }


    private static boolean expr2() {
        if (expr3() && expr2tail()) {
            return true;
        }
        return false;
    }

    private static boolean expr2tail() {
        if (op2()) {
            if (expr3()) {
                return true;
            }
            return false;
        }
        return true;
    }


    private static boolean expr3() {
        return num();
    }


    private static boolean op1() {
        if ("+".equals(getCurrToken()) || "-".equals(getCurrToken())) {
            index++;
            return true;
        }
        return false;
    }

    private static boolean op2() {
        if ("*".equals(getCurrToken()) || "/".equals(getCurrToken())) {
            index++;
            return true;
        }
        return false;
    }

    private static boolean num() {
        if (Pattern.compile("\\d+").matcher(getCurrToken()).matches()) {
            index++;
            return true;
        }
        return false;
    }

    private static String getCurrToken() {
        if (index == tokens.size()) {
            return "";
        }
        return tokens.get(index);
    }

}

