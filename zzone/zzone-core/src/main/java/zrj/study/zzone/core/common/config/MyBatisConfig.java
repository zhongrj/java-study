package zrj.study.zzone.core.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/20
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "zrj.study.zzone.*.dao")
public class MyBatisConfig implements TransactionManagementConfigurer {

    @Bean
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/zzone?useUnicode=true&characterEncoding=utf-8");
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
        sessionFactory.setTypeAliasesPackage("zrj.study.zzone");
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/zrj/study/zzone/*/dao/*.xml"));
        return sessionFactory;
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

}
