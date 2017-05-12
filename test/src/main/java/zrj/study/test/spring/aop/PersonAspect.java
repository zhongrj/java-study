package zrj.study.test.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/11
 */
@Aspect
public class PersonAspect {

    @Before("execution(public * sa*(..))")
    public void say() {
        System.out.println("some one say something");
    }

    // 关于括号内的写法，查看相关文档 spring-aop
    @Around("execution(public * walk(..))")
    public Object walk(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("some one want to walk~ ");
        Object[] args = pjp.getArgs();
        System.out.print("params: ");
        for (Object arg : args) {
            System.out.print(arg);
        }
        System.out.println();
        Object result = pjp.proceed();
        System.out.println("some one walk over~ ");
        return result;
    }

}
