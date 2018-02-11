启动：
- 节点1：mvn spring-boot:run -Dspring.profiles.active=peer1
- 节点2：mvn spring-boot:run -Dspring.profiles.active=peer2
- 单点：mvn spring-boot:run

后台查看eureka-server是否启动成功，以及相关注册服务：
- 节点1：http://eureka-server-peer1:7001/
- 节点2：http://eureka-server-peer2:7002/
- 单点：http://eureka-server:7000/