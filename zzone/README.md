# zzone

个人空间项目，本项目依赖于parent和util，希望做成一个web后台的模板项目，实现web项目后台所需要的通用功能。

### 使用技术
- spring-boot
- mybatis
- ...

### 主要功能
- 注册登录
- ...

### 项目模块介绍
- zzone-core
> 该模块负责项目的核心业务逻辑，如：登录注册，...

- zzone-web
> 该模块负责项目的对外接口，目前均为HTTP请求接口，具体看接口文档（暂时还没有...）

### 项目配置
- 数据库配置：
```
/** 类zrj.study.zzone.core.common.config.MybatisConfig中 **/
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
```

### 项目启动
> 找到zzone-web模块下的类zrj.study.zzone.web.ZzoneApplication，run main...
