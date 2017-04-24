# java学习开发项目
### 项目：

 - parent
 用于管理所有项目所依赖的类库及其版本
 - util
 用于存放各项目公共工具类库
 - zzone
 个人空间项目，打算作为web后台的模板

### 技术介绍：

 - 各项目均用maven作为构建工具
 - 主要用到一下框架
     - spring-boot
     - mybatis
     - ...

### zzone运行步骤：

 - 使用ide启动：
    1. 导入zzone项目；
    2. 导入parent和util项目，或mvn install parent和util项目；
    3. 进入zzone项目的zzone-web模块，找到类zrj.study.zzone.web.ZzoneApplication，run main方法，项目启动完成。
    
 - 使用mvn启动：
    待更新...

备注：本项目需要用到mysql数据库，sql建表语句在zzone-core模块下的sql文件夹中，数据库相关配置在zzone-core模块中的类zrj.study.zzone.core.commmon.config.MybatisConfig中，请根据自己需要修改。
