# springboot脚手架

#### 介绍
基于springboot开发的脚手架，旨在迅速搭建开发平台。

#### 软件架构

软件架构说明
1.lombok插件
2.swagger文档生成
3.jpa
4.数据库使用mysql

#### 安装教程

1.  安装lombok插件，使用intellij idea作为ide工具，在设置中找plugins，搜索lombok安装
2.  创建数据库，导入初始测试数据db.txt，数据库名，端口，用户名，密码更新到application.yml
3.  启动应用SpringbootScaffoldApplication
4.  访问接口文档地址http://localhost:8080/swagger-ui.html

#### 使用说明

1.  优雅的参数判断，UserVo中使用注解对参数进行判空，校验，全局异常捕获，对参数异常情况做统一返回，在创建用户接口中可以尝试不填写某一项字段，或者填写错误的email地址
2.  UserDao使用jpa和数据库数据进行交互，查询单独用户使用方法名，更新用户状态使用sql，翻页、保存用户使用默认自带方法
3.  UserDo为数据库字段映射，就是所有数据库中有的字段都会在这个类中，而UserVo为展示用户信息，只展示需要的字段，尽量不混用，单独定义
