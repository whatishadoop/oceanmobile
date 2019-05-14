日志数据采用分库分表读写方案
1.MySQL + Atlas --- 部署读写分离，引入中间件
2.采用sharding-jdbc方案，轻量
  a.引入
 <!--引入sharding-jdbc进行分库分表-->
        <!--<dependency>
            <groupId>io.shardingsphere</groupId>
            <artifactId>sharding-jdbc-spring-boot-starter</artifactId>
            <version>3.0.0</version>
        </dependency>-->
   b.启动时引入application-sharding-databases.yml
其它资料
MySQL + Atlas --- 部署读写分离
安装sysstat使用iostat、sar，指标含义