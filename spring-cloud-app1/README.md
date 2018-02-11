
## 单环境使用

启动：
- mvn spring-boot:run

使用http测试：
- http://localhost:6000/hello

## 多环境使用

dev环境启动：

两个相同的服务实例：
- mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=dev -Dserver.port=6001"
- mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=dev -Dserver.port=6002"

（根据application-dev.properties，默认依赖的服务环境也是dev环境）

使用http测试：
- http://localhost:6001/hello
- http://localhost:6002/hello