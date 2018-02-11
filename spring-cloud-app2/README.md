
## 单环境使用

启动：
- mvn spring-boot:run

使用http测试：
- http://localhost:6500/hello
  - http://localhost:6500/hello/param
  - http://localhost:6500/hello/body （失败）
  
## 多环境使用

dev环境启动：
- mvn spring-boot:run -Dspring.profiles.active=dev

（根据application-dev.properties，依赖的服务环境也是dev环境）

使用http测试：
- http://localhost:6500/hello
  - http://localhost:6500/hello/param
  - http://localhost:6500/hello/body （失败）