package zrj.study.test.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/11
 */
public class Test {

    public static void main(String[] args) {

        // 对spring容器管理的实例aop
        ApplicationContext act = new AnnotationConfigApplicationContext(Config.class);
        Person person = act.getBean(Person.class);
        person.say("hello");
        person.walk(100);


        class MethodInterceptorImpl implements MethodInterceptor{
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                System.out.print("params: ");
                for (Object arg : args) {
                    System.out.print(arg);
                }
                System.out.println();
                Object result = invocation.getMethod().invoke(invocation.getThis(), invocation.getArguments());
                System.out.println("bye");
                return result;
            }
        }

        // 对spring容器以外的实例aop
        System.out.println("\n\n");
        ProxyFactory factory = new ProxyFactory(new Person("jane"));
        factory.addAdvice(new MethodInterceptorImpl());
        Person pojo = (Person) factory.getProxy();
        pojo.walk(1000);


        // 使用factoryBean
        System.out.println("\n\n");
        ProxyFactoryBean proxyFactoryBean = new ProxyFactoryBean();
        proxyFactoryBean.addAdvice(new MethodInterceptorImpl());
        proxyFactoryBean.setTarget(new Person("jason"));
        Person jason = (Person) proxyFactoryBean.getObject();
        jason.walk(500);
//        proxyFactoryBean.setSingleton(false);
        System.out.println(proxyFactoryBean.getObject() == proxyFactoryBean.getObject()); // 默认true proxyFactoryBean.setSingleton(true);


        // spring容器以外的实例利用spring的aspect对其进行aop
        // aspect理解为多个advice组成的模块
        System.out.println("\n\n");
        AspectJProxyFactory factory1 = new AspectJProxyFactory(new Person("peter"));
        factory1.addAspect(PersonAspect.class);
        Person peter = factory1.getProxy();
        peter.walk(200);


        // 关于jdk代理和cglib代理
        // 如果添加了接口proxyFactoryBean2.addInterface(Animal.class);则默认用jdk代理
        // 这种情况下 只能代理接口中存在的方法
        // 如果添加了接口仍想用cglib来代理类中的所有方法
        // 则需要 proxyFactoryBean2.setProxyTargetClass(true); // 设置代理为class 而不是interface
        // 关于其优缺点，估计效率有区别吧 毕竟jdk是官方提供的方法 用的是native方法实现的
        System.out.println("\n\n");
        ProxyFactoryBean proxyFactoryBean2 = new ProxyFactoryBean();
        proxyFactoryBean2.addAdvice(new MethodInterceptorImpl());
        proxyFactoryBean2.setTarget(new Dog());
        proxyFactoryBean2.addInterface(Animal.class);
//        proxyFactoryBean2.setProxyTargetClass(true);  // 设置为使用cglib
        Animal dog = (Animal) proxyFactoryBean2.getObject(); // 如果是jdk代理只能用cast成接口
        dog.walk();


        // 容器使用proxyFactoryBean的方式
        System.out.println("\n\n");
        Animal dog1 = (Animal) act.getBean("dog");
        dog1.walk();
    }
}
