CHANGEME
====
# CHANGEME-CLIENT
RPC调用依赖的服务接口声明和DTO定义.

# CHANGEME-SERVER
RPC服务的实现, 基于spring-boot.


## FEATURES
* Simplified and faster Spring development. Absolutely no code generation and no requirement for XML configuration
* Provide a range of non-functional features that are common to large classes of projects (e.g. embedded servers, security, metrics, health checks, externalized configuration)


## FOR DEVELOPERS
- 如何暴露服务
    - class定义上加注解@KarmaService(value=“serviceName”)

- 如何简单测试服务
    - KARMA默认以TCP和HTTP两种形式暴露服务,可调用HTTP进行简单的测试,如:
   `curl --data q='[]' 'http://localhost:11100/com.duitang.changeme.client.service.ILikeService/findOne'`

- 如何读写mysql
    - 按Mybatis要求,编写mapper.xml文件,和DO做映射
    - 在DAO中使用SqlSessionTemplate(读写各有一个, 不使用ORM)调用mapper内定义的sql, 具体方法见https://mybatis.github.io/spring/sqlsession.html
    - 需要transaction时使用TransactionTemplate
    - 详见like包内的LikeDAO

- 如何读写mongo
    - 定义DO
    - DAO中使用MongoTemplate(同样不用ORM), 进行具体读写以及DO的映射
    - 见word包内的WordDAO

- 如何发kafka消息
    - 使用stdMessageManager, 见MisTest

- 如何读写redis
    - 见sample内的MisTest

- 如何使用memcache
    - 见MisTest

- 如何的日志
    - resources里logback.xml配置以包全称(或其部分前缀)为名的logger
    - 代码里LoggerFactory.getLogger, 见LikeService

- 如何检查单测的代码覆盖情况
    - mvn test/package
    - mvn jacoco:report
    - open target/site/jacoco/index.html

- 如何运行
    - sh runnow.sh 或:
    - mvn spring-boot:run, 若需要更详细的debug信息则再加--debug

- 如何debug
    - sh runnow.sh -d

- 如何修改karma服务端口
    - 修改application.properties内的'server.servicePort',重新编译后运行, 或:
    - 将properties复制到路径PATH_TO_PROPERTY,修改好. 无需重新编译,直接执行java -jar path_to_the_project.jar --spring.config.location=PATH_TO_PROPERTY

- 关于强制测试覆盖率
    - 形如*Service.java和*DAO.java的代码以行计的测试覆盖率要高于X(当前为0.8), 否则无法打包

- 关于包结构
    - 先业务再领域,如com.duitang.changeme.server.like.dao, 而不是com.duitang.changeme.server.dao.like



## FOR OPERATORS
- 如何进行配置管理
    - 使用外部property进行管理, 与代码分离管理dev/preview/release的配置, 在程序启动时指定配置文件

- 如何分发应用
    - package后的包copy and run, 不需要额外的容器, 如:java $JVMARGS -jar path_to_the_project.jar --spring.config.location=file:/tmp/release.properties



## TODO
- 把mysql, redis和memcache封装成二方库
- 引入beanutils规范DO,DTO间的转换
- maven format check plugin
- health indicator
- metrics
- CCT support
- 整理成可复用的模板
- remote shell?
- 移除对spring boot的依赖?
