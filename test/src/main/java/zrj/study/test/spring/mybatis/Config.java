package zrj.study.test.spring.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;


/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/5/12
 */
@Configuration //  这个东西很关键，不写此类不由cglib代理，那么dataSource()多次返回不同.. 日了狗
@EnableTransactionManagement
@MapperScan(basePackages = "zrj.study.test.spring.mybatis.dao")
public class Config implements TransactionManagementConfigurer {

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
//        sessionFactory.setTypeAliasesPackage("zrj.study.test");
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/zrj/study/zzone/*/dao/*.xml"));
        return sessionFactory;
    }

    @Bean
    public Service service() {
        return new Service();
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }



}
