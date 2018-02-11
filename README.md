Spring cloud 应用启动后，需要等待一段时间，环境才能访问

修改host：（为了避免在项目中写ip）
```
127.0.0.1 eureka-server-peer1
127.0.0.1 eureka-server-peer2
127.0.0.1 eureka-server
```