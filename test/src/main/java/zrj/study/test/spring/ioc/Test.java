package zrj.study.test.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import zrj.study.test.spring.event.SomeOne;
import zrj.study.test.spring.ioc.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/10
 */
public class Test {

    public static void main(String[] args) {

        ApplicationContext act = new AnnotationConfigApplicationContext(zrj.study.test.spring.ioc.Config.class);
        Person ben = act.getBean("ben", Person.class);
        System.out.println(ben.getDog().getName());
        Person SBben = act.getBean("SBben", Person.class);
        System.out.println(ben == SBben);
        System.out.println(act.getMessage("hello", null, "default", null)); // ?

        List<Integer> primes = new ArrayList<Integer>();
        primes.addAll(Arrays.asList(2,3,5,7,11,13,17));
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("primes",primes);
        List<Integer> primesGreaterThanTen = (List<Integer>) parser.parseExpression("#primes.?[#this>10]").getValue(context);
        Integer a = (Integer) parser.parseExpression("#primes[1]").getValue(context);// 表达式适用于@Value
        System.out.println(a);

    }

}
