# 说明:
项目来源 http://www.jeesite.com/
用于学习使用,但是由于自身功力不够,还需要分析逐步理解解剖 

# 查看doc目录 有相关帮助文档

# 使用帮助描述
## 项目启动说明
* 首先需要配置数据库 resources/jeesite.properties
* 然后生成数据库,表结构
会自动生成数据库,数据表,以及基本数据
如果init-db.bat 执行时出现问题(需要maven支持),可以手动copy jeesite_mysql.sql 文件到数据库中执行


## 项目配置理解
* pom.xml
* 项目配置描述符 
src/main/WEB-INF/webapp/WEB-INF/web.xml
* 添加jar依赖包 
将jar文件拷贝项目WEB-INF下的lib目录，并配置pom
<dependency>
        <groupId>com.test</groupId>
        <artifactId>test-core</artifactId>
        <version>1.0</version>
        <scope>system</scope>
        <systemPath>
            ${project.basedir}/src/main/webapp/WEB-INF/lib/test-core-1.0.jar
        </systemPath>
 </dependency>\
 
 
##　二次开发参考文档
查看 doc/内置组件的应用.docx

## 代码生成器的应用
查看 doc/代码生成器的应用.docx

## 工作流的应用实例
查看 doc/工作流的应用实例.docx

## 内容管理说明
查看 doc/内容管理模块功能说明.docx


## 系统执行过程分析
项目配置描述符 
src/main/WEB-INF/webapp/WEB-INF/web.xml
扫描bean配置    classpath*:/spring-context*.xml 
spring mvc配置  classpath*:/spring-mvc*.xml
shiro 配置      shiroFilter  /*
Activiti       JSONPFilter  (Activiti diagram-view callback filter)
CKFinder 
DruidStatView
ValidateCodeServlet  <url-pattern>/servlet/validateCodeServlet</url-pattern>

需要掌握代码生成工具的使用: 配置类
 * resources/spring-context.xml spring 容器定义
 * resources/mybatis-config.xml
 * resources/templates/modules/gen/config.xml
 * resources/templates/modules/gen/curd/ 生成某个模块的curd
 * resources/templates/modules/gen/treetable/ 生成某个树结构
 * resources/templates/modules/gen/dao/ 生成摸个模块持久层文件 对应的模板定义 (dao接口继承CrudDao,实体类继承DataEntity,sql xml 生成比较复杂)
 * com.thinkgem.jeesite.modules.gen.util.GenUtils 有个main方法输出信息
 ... 待完善 
 

/**
 * Created by ouzhx on 2017/5/27. 系统核心模块
 *
 * 基本上掌握摸个模块的流程就掌握了其他模块:建议入门的模块sys
 *
 * 由持久层倒推到web 层,比如User模块 resources/mappings/modules/sys/UserDao.xml (在xml中找到对应的接口
 * <mapper namespace="com.thinkgem.jeesite.modules.sys.dao.UserDao">)
 *
 * eclipse 快捷键ctrl+shift+R跳转到UserDao接口 (ctrl+鼠标左键 找到对应的service引用)
 *
 * 分析service 代码,继承了抽象类 BaseService, 有方法dataScopeFilter (所有实体类 继承DataEntity,BaseEntity;包含了id
 * 和page分页对象 sqlMap--待理解 )
 *
 * (ctrl+鼠标左键 找到对应的Controller引用) 没有rpc调用,直接service类,没有额外service接口
 * 
 * 继续分析 service 其他依赖
 * @Autowired private UserDao userDao;
 * @Autowired private RoleDao roleDao;
 * @Autowired private MenuDao menuDao;
 * @Autowired private SessionDAO sessionDao;
 * @Autowired private SystemAuthorizingRealm systemRealm;
 *
 *
 */
package com.thinkgem.jeesite.modules.sys;
