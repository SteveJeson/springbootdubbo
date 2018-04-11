# SpringBoot项目(集成dubbo、zookeeper)
## 说明
本项目是集成dubbo和zookeeper的一个HelloWorld项目，基于注解的配置形式，没有xml文件
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
 
