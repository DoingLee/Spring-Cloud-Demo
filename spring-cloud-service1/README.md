
## 单环境集群

启动两个一样的服务实例：
- mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=5001'
- mvn spring-boot:run -Drun.jvmArguments='-Dserver.port=5002'

直接通过http测试：
- 服务实例1：http://localhost:5001/hello
- 服务实例2：http://localhost:5002/hello

## 多环境集群

dev环境：

启动两个一样的服务实例：
- mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=dev -Dserver.port=5001"
- mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=dev -Dserver.port=5002"

直接通过http测试：
- 服务实例1：http://localhost:5001/hello
- 服务实例2：http://localhost:5002/hello