启动：
- mvn spring-boot:run

使用http测试：
- 成功请求：
  - http://localhost:7500/app1/hello?accessToken=token
  - http://localhost:7500/app2/hello/param?accessToken=token
- 失败请求：
  - http://localhost:7500/app1/hello
  - http://localhost:7500/app2/hello/param