# SpringBoot项目(集成dubbo、zookeeper)
## 说明
本项目是集成dubbo和zookeeper的一个练习项目，基于注解的配置形式，没有xml文件

## 环境
#### 操作系统：ubuntu 16.04 LTS
#### 开发工具：Idea
## 搭建过程
### 一、安装zookeeper
#### 1、下载zookeeper源码包
> 官方下载地址： http://apache.fayea.com/zookeeper/

> 本项目使用的版本： zookeeper-3.5.1-alpha.tar.gz 
#### 2、安装zookeeper
> 1、解压安装包到指定目录

>  `sudo tar -zxvf zookeeper-3.5.1-alpha.tar.gz -C /opt/`

> 2、拷贝一份zoo_sample.cfg，重新命名为zoo.cfg

> `cd /opt/zookeeper-3.5.1-alpha/conf/`

> `cp zoo_sample.cfg  zoo.cfg`

> 3、编辑zoo.cfg，主要配置dataDir和dataLogDir、server,如下

> `# The number of milliseconds of each tick`<br>
> `tickTime=2000`<br>
> `# The number of ticks that the initial`<br>
> `# synchronization phase can take`<br>
> `initLimit=10`<br>
> `# The number of ticks that can pass between`<br>
> `# sending a request and getting an acknowledgement`<br>
> `syncLimit=5`<br>
> `# the directory where the snapshot is stored.`<br>
> `# do not use /tmp for storage, /tmp here is just`<br>
> `# example sakes.`<br>
> **`dataDir=/usr/local/zookeeper-3.5.1-alpha/data`**<br>
> **`dataLogDir=/usr/local/zookeeper-3.5.1-alpha/logs`**<br>
> `# the port at which the clients will connect`<br>
> `clientPort=2181`<br>
> **`server.1=192.168.1.161:2888:3888`**<br>
> `# the maximum number of client connections.`<br>
> `# increase this if you need to handle more clients`<br>
> `#maxClientCnxns=60`<br>
> `# Be sure to read the maintenance section of the`<br>
> `# administrator guide before turning on autopurge.`

> 4、新建myid文件，将上一步配置的服务器编号server.1的1写入

> `cd /usr/local/zookeeper-3.5.1-alpha/data/`

> `sudo touch myid`

> `sudo vi myid`

> 5、设置PATH

> `sudo vi /etc/profile`

> 添加 `export ZOOKEEPER_HOME=/opt/zookeeper-3.5.1-alpha`

> `export PATH=$ZOOKEEPER_HOME/bin:$PATH`

> 6、启动、停止、重启zookeeper服务，以及查看状态

> `sudo /opt/zookeeper-3.5.1-alpha/bin/zkServer.sh start`

> `sudo /opt/zookeeper-3.5.1-alpha/bin/zkServer.sh stop`

> `sudo /opt/zookeeper-3.5.1-alpha/bin/zkServer.sh restart`

> `sudo /opt/zookeeper-3.5.1-alpha/bin/zkServer.sh status`

> 7、安装完毕，有具体问题再具体解决

### 二、安装dubbo管理平台
#### 说明：需要Tomcat部署项目，比较简单，在此忽略Tomcat的安装
#### 1、下载dubbo-admin项目
> 官方下载地址：https://github.com/apache/incubator-dubbo-ops <br>
> `git clone https://github.com/apache/incubator-dubbo-ops`
#### 2、编译打包
> `mvn package`
#### 3、将打好的war包放入Tomcat的webapps的ROOT目录下，并解压
#### 4、访问Tomcat配置的端口地址:http://localhost:8082/ ,进入管理主页，安装完毕
![images](https://github.com/SteveJeson/springbootdubbo/blob/master/images/dubbo_admin.png)

### 三、搭建SpringBoot项目，集成dubbo
#### 说明：使用开发工具 Idea
#### 新建SpringBoot项目
> 1、使用Spring Initializr创建SpringBoot项目 <br>
![images](https://github.com/SteveJeson/springbootdubbo/blob/master/images/spring.png)

> 2、分别新建三个module，springboot-dubbo-server(服务端),springboot-dubbo-client(客户端),springboot-dubbo-api(共享接口) <br>
![images](https://github.com/SteveJeson/springbootdubbo/blob/master/images/projectree.png)

> 3、pom.xml添加dubbo依赖包，参考具体文件

> 4、在api项目定义接口

> 5、在server项目里实现接口，给实现类添加注解Component和Service：

> `@Component @Service(version = "1.0.0") `

> 6、在client项目里消费接口，建立controller，将要调用的服务注入进来，添加Refrence注解：

> `@Reference(version="1.0.0") private DemoService demoService;`

> 7、server服务端application.properties配置

> `#dubbo提供者的别名，只是个标识`<br>
> `spring.dubbo.application.name=springboot-dubbo-server`

> `#zk地址`<br>
> `spring.dubbo.registry.address=zookeeper://127.0.0.1:2181`

> `#dubbo协议`<br>
> `spring.dubbo.protocol.name=dubbo`

> `#duboo端口号`<br>
> `spring.dubbo.protocol.port=20880`

> `#这是你要发布到dubbo的接口所在包位置`<br>
> `spring.dubbo.scan=com.zdzc.base.service.impl`

> `服务端口号`<br>
> `server.port=8088`

> 8、client客户端application.properties配置,同服务端

> 9、分别启动服务端和客户端项目，启动完毕后，在dubbo管理平台会看到有相关统计<br>
![images](https://github.com/SteveJeson/springbootdubbo/blob/master/images/service.png)





 
