## config-server多环境配置

#### 多环境配置文件：
- 1、不同环境（dev、test1、test2、pre1、pre2、online）使用不同profile区分，通过spring boot的spring.profiles.active=dev实现
- 2、不同profile下读取不同的配置文件
  - 应用内配置：
    - application-{profile}.properties
  - 使用spring cloud config配置：
    - 根目录的application-{profile}.properties
    - 路径/文件名的{application}-{profile}.properties

#### 多环境服务应用调用：（服务实例区分环境）
- 服务提供者：每个应用通过实例名注册到eureka（即应用在不同环境的实例通过eureka.instance.appname区分）：eureka.instance.appname=${spring.application.name}.${spring.profiles.active}
  - 相关issue：https://github.com/spring-cloud/spring-cloud-netflix/issues/1516
    - When eureka.instance.appname is defined, default
      eureka.instance.virtualHostname and
      eureka.instance.secureVirtualHostname to that value.
    - If eureka.instance.appname is not defined but spring.application.name is
      defined, default the 3
      eureka.instance.appname | virtualHostname | secureVirtualHostname values to
      the hostname-sanitized version of spring.application.name.
    - 注册到eureka-server的是eureka.instance.appname
    - 如果eureka.instance.appname没有定义，会默认eureka.instance.appname = spring.application.name
- 服务消费者：feign/ribbon客户端依赖的服务与上面的eureka.instance.appname一致：
    - @FeignClient(name = "某个服务的${spring.application.name}.某个环境的${spring.profiles.active}", fallback = XXX.class)

#### spring cloud config 配置方法

配置读取优先级：
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config

为了使得spring cloud config server中的配置文件比应用本地的配置文件的优先级要高，在本地应用中对config-server的配置应写在：（应用启动时加载bootstrap配置）
- bootstrap.properties
- bootstrap.yml

其他一般配置写在config-repo中，优先级：
- 应用在某个环境下的配置：/{application}/{application}-{profile}.properties
- 应用各个环境通用配置：/{application}/{application}.properties
- 所有应用通用配置：application-{profile}.properties

##### 本地启动应用时，最高优先级配置方法：
- 在 ~/.spring-boot-devtools.properties下的配置具有**全局最高优先级**（所有应用通用）
- 要想使用.spring-boot-devtools.properties里的配置，必须在spring应用接入dev-tools配置： 
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```
- 然后就可以在~/.spring-boot-devtools.properties中写本地配置：
```
management.security.enabled=false
```

#### 应用启动：
- mvn spring-boot:run

#### 测试应用读取的配置
对config-server测试：
- 获取的配置目录：http://localhost:9000/{application}/{profile}
- 读取的配置信息：http://localhost:9000/{application}-{profile}.properties 

对config client测试：
- 在本地 ~/.spring-boot-devtools.properties（全局最高优先级配置）加入：
    - management.security.enabled=false
- 对config client获取应用的所有配置信息（如：监听6001端口的app1实例）：http://localhost:6001/env
    - 返回的配置按spring boot配置优先级显示。并且显示的配置就是spring应用中读取的最终配置

#### 手动动态刷新config client的配置
(貌似不大管用。。)
- 对config client（如：监听6001端口的app1实例）：http POST http://localhost:6001/refresh


#### config-repo 地址：
- https://github.com/DoingLee/config-repo.git
