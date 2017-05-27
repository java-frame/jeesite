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
 * 需要掌握代码生成工具的使用: 配置类
 * resources/spring-context.xml spring 容器定义
 * resources/mybatis-config.xml
 * resources/templates/modules/gen/config.xml
 * resources/templates/modules/gen/curd/ 生成某个模块的curd
 * resources/templates/modules/gen/treetable/ 生成某个树结构
 * resources/templates/modules/gen/dao/ 生成摸个模块持久层文件 对应的模板定义 (dao接口继承CrudDao,实体类继承DataEntity,sql xml 生成比较复杂)
 *
 *
 *
 */
package com.thinkgem.jeesite.modules.sys;
