启动两个一样的服务实例：
- mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=5501'
- mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=5502'

直接通过http测试：
- 服务实例1：
  - http://localhost:5501/hello/param/v1
  - http://localhost:5501/hello/body
- 服务实例2：
  - http://localhost:5502/hello/param/v1
  - http://localhost:5502/hello/body