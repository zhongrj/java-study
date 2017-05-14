package zrj.study.zzone.core.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.hsqldb.jdbc.JDBCDriver;
import org.hsqldb.server.Server;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

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
public class CoreConfig implements TransactionManagementConfigurer {

    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;

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
        stmt.executeQuery(getStringFromPath("sql/hsql/zzone-core-tab-hsql.sql"));
        stmt.executeQuery(getStringFromPath("sql/hsql/zzone-core-data-hsql.sql"));
        return dataSource;

//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.HSQL)
//                .addScripts("/sql/zzone-core-tab-hsql.sql", "/sql/zzone-core-data-hsql.sql")
//                .build();
    }

    private String getStringFromPath(String path) throws IOException {
        StringBuffer sb = new StringBuffer();
        InputStream is = new ClassPathResource(path).getInputStream();
        byte[] bytes = new byte[1024];
        int i = 0;
        while ((i = is.read(bytes)) > 0) {
            sb.append(new String(bytes, 0, i));
        }
        return sb.toString();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("zrj.study.zzone");
//        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/zrj/study/zzone/*/dao/*.xml"));
        return sessionFactory;
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
