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


