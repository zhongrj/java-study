package zrj.study.zzone.core.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hsqldb.jdbc.JDBCDriver;
import org.hsqldb.server.Server;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import zrj.study.util.io.IOUtils;

import javax.sql.DataSource;
import java.sql.*;

/**
 * 核心模块配置
 *
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/4/20
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:/zzone-core.properties")
@MapperScan(basePackages = "zrj.study.zzone.core.dao")
@ComponentScan(basePackages = {"zrj.study.zzone.core.service", "zrj.study.zzone.core.common.aware"})
public class CoreConfig {

    @Autowired
    private Environment env;

    @Bean
    @Profile("dev-back")
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("${jdbc.driver}"); // 这样也可以
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);
        return dataSource;
    }

    @Bean
    @Profile("dev-front")
    public DataSource embeddedDatabase() throws Exception {
        Server.main(new String[]{"-database.0", "db/zzone", "-dbname.0", "zzone"});
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(JDBCDriver.class);
        dataSource.setUrl("jdbc:hsqldb:hsql://localhost/zzone");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeQuery(IOUtils.getContent(new ClassPathResource("sql/hsql/zzone-core-tab-hsql.sql").getInputStream(), "utf-8"));
        stmt.executeQuery(IOUtils.getContent(new ClassPathResource("sql/hsql/zzone-core-data-hsql.sql").getInputStream(), "utf-8"));
        return dataSource;

//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.HSQL)
//                .addScripts("sql/hsql/zzone-core-tab-hsql.sql", "sql/hsql/zzone-core-data-hsql.sql")
//                .build();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(@Autowired DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setConfigLocation(new ClassPathResource("xml/mybatis-config.xml"));
        sessionFactory.setTypeAliasesPackage("zrj.study.zzone");
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setVfs(SpringBootVFS.class);                 // 解决对jar包扫描alias类时的尴尬
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager(@Autowired DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
