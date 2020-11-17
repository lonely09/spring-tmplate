 SpringBoot 项目模板
===============

当前最新版本： 1.01（发布日期：2020-11-17）

项目介绍
-----------------------------------
<h3 align="center">Java Template for enterprise web applications</h3>

SpringBootTemplate 是一款基于Spring的`项目`开发平台 并实现了基本的CRUD，新项目无需再搭建！项目架构：SpringBoot2.x，SpringDataJPA，SpringSecurity，JWT。


`SpringBootTemplate:` 新项目无需新构建、即拉即用、使用`ApolloConfig`实现热配置 权限方面由权限中台进行管理。

适用场景
----------------------------------
适用于新人学习、新项目的建立、基础的项目架构

技术文档
----------------------------------
 - 开发文档：[微服务开发文档](http://10.1.111.32:31150/)
 - Apollo相关文档：[confluence](https://confluence.smec-cn.com/pages/viewpage.action?pageId=2659310)
 - 权限中台技术官网：[github](https://github.smec-cn.com/pri/pri-auth-client)
 
技术架构：
---------------------------------
开发环境

- 语言：Java
- IDE(JAVA)：IntelliJ IDEA
- IDE(数据库)：DataGrip
- 依赖管理：Maven
- 数据库：Oracle 11G or Oracle 19C

后端

 - 基础框架：SpringBoot 2.3.4.RELEASE
 - 持久层框架：SpringDataJpa
 - 安全框架：SpringSecurity、JWT
 - 微服务技术：SpringCloud、Gateway、Skywarking、Apollo
 - 数据库连接池：Alibaba Druid 1.1.22
 - 日志打印：slf4j
 - 接口文档：OpenApi 3.1
 
项目下载与运行
-----
 - 拉取项目代码
 ```
git clone git@github.smec-cn.com:itpublic/java-temp-prj.git
cd java-temp-prj
```
 - 配置项目所需环境变量
 
 ```
-Dapp.id=qixowjuscz.java-temp-prj
-Dapollo.bootstrap.namespaces=application
-DAPOLLO_CONFIGSERVICE=http://10.1.113.62:32548/
```
其他说明
---------
application.properties 的文件存放于DMP-dev环境 SIMP组织 

DMP地址：[dmp-dev](https://dmp-dev.smec-cn.com)