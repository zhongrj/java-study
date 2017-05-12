package zrj.study.test.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/11
 */
@Configuration
@EnableAspectJAutoProxy
public class Config {

    @Bean
    public PersonAspect personAspect() {
        return new PersonAspect();
    }

    @Bean
    public Person person() {
        return new Person("Ben");
    }

    @Bean
    public ProxyFactoryBean dog() {
        class MyProxyFactoryBean extends ProxyFactoryBean implements MethodInterceptor {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                System.out.print("params: ");
                for (Object arg : args) {
                    System.out.print(arg);
                }
                System.out.println();
                Object result = invocation.getMethod().invoke(invocation.getThis(), invocation.getArguments());
                System.out.println("bye~");
                return result;
            }
        }
        MyProxyFactoryBean myProxyFactoryBean = new MyProxyFactoryBean();
        myProxyFactoryBean.addAdvice(myProxyFactoryBean);
        myProxyFactoryBean.setTarget(new Dog());
        myProxyFactoryBean.setProxyTargetClass(true); // 设为cglib // 不起作用？
        return myProxyFactoryBean;
    }

}
