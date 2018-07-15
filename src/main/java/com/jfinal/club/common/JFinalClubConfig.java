/**
 * 请勿将俱乐部专享资源复制给其他人，保护知识产权即是保护我们所在的行业，进而保护我们自己的利益
 * 即便是公司的同事，也请尊重 JFinal 作者的努力与付出，不要复制给同事
 * 
 * 如果你尚未加入俱乐部，请立即删除该项目，或者现在加入俱乐部：http://jfinal.com/club
 * 
 * 俱乐部将提供 jfinal-club 项目文档与设计资源、专用 QQ 群，以及作者在俱乐部定期的分享与答疑，
 * 价值远比仅仅拥有 jfinal club 项目源代码要大得多
 * 
 * JFinal 俱乐部是五年以来首次寻求外部资源的尝试，以便于有资源创建更加
 * 高品质的产品与服务，为大家带来更大的价值，所以请大家多多支持，不要将
 * 首次的尝试扼杀在了摇篮之中
 */

package com.jfinal.club.common;

import java.sql.Connection;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.chen.fy.IndexController;
import com.chen.fy.controller.AccountController;
import com.chen.fy.controller.base.CustomerController;
import com.chen.fy.controller.base.DepartmentController;
import com.chen.fy.controller.base.PersonController;
import com.chen.fy.controller.base.SupplierController;
import com.chen.fy.controller.base.TaxRateController;
import com.chen.fy.controller.base.UnitController;
import com.chen.fy.controller.role.RoleAdminController;
import com.jfinal.club._admin.common.AdminRoutes;
import com.jfinal.club._admin.permission.PermissionDirective;
import com.jfinal.club._admin.role.RoleDirective;
import com.jfinal.club.common.handler.UrlSeoHandler;
import com.jfinal.club.common.interceptor.LoginSessionInterceptor;
import com.jfinal.club.common.kit.DruidKit;
import com.jfinal.club.common.model._MappingKit;
import com.jfinal.club.login.LoginService;
import com.jfinal.club.my.friend.FriendInterceptor;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.json.FastJsonFactory;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.cron4j.Cron4jPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.JsonRender;
import com.jfinal.template.Engine;
import com.jfinal.template.source.ClassPathSourceFactory;

/**
 * JFinalClubConfig
 */
public class JFinalClubConfig extends JFinalConfig {

	// 先加载开发环境配置，再追加生产环境的少量配置覆盖掉开发环境配置
	private static Prop p = PropKit.use("jfinal_club_config_dev.txt").appendIfExists("jfinal_club_config_pro.txt");

	private WallFilter wallFilter;

	/**
	 * 启动入口，运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 * 
	 * 使用本方法启动过第一次以后，会在开发工具的 debug、run configuration 中自动生成
	 * 一条启动配置项，可对该自动生成的配置再继续添加更多的配置项，例如 VM argument 可配置为： -XX:PermSize=64M
	 * -XX:MaxPermSize=256M 上述 VM 配置可以缓解热加载功能出现的异常
	 */
	public static void main(String[] args) {
		/**
		 * 特别注意：Eclipse 之下建议的启动方式
		 */
		// JFinal.start("src/main/webapp", 80, "/", 5);

		/**
		 * 特别注意：IDEA 之下建议的启动方式，仅比 eclipse 之下少了最后一个参数
		 */
		JFinal.start("src/main/webapp", 80, "/");
	}

	public void configConstant(Constants me) {
		me.setDevMode(p.getBoolean("devMode", false));
		// me.setJsonFactory(MixedJsonFactory.me());
		me.setJsonFactory(new FastJsonFactory());
	}

	/**
	 * 路由拆分到 FrontRutes 与 AdminRoutes 之中配置的好处： 1：可分别配置不同的 baseViewPath 与 Interceptor
	 * 2：避免多人协同开发时，频繁修改此文件带来的版本冲突 3：避免本文件中内容过多，拆分后可读性增强 4：便于分模块管理路由
	 */
	public void configRoute(Routes me) {
		me.add(new FrontRoutes());
		me.add(new AdminRoutes());
		me.add("fy", IndexController.class, "/_view");
		me.add("fy/admin/account", AccountController.class, "/_view/atladmin/account");
		me.add("fy/admin/role", RoleAdminController.class, "/_view/atladmin/role");
		me.add("fy/admin/base/person", PersonController.class, "/_view/atladmin/person");
		me.add("fy/admin/base/department", DepartmentController.class, "/_view/atladmin/department");
		me.add("fy/admin/base/customer", CustomerController.class, "/_view/atladmin/customer");
		me.add("fy/admin/base/supplier", SupplierController.class, "/_view/atladmin/supplier");
		me.add("fy/admin/base/taxRate", TaxRateController.class, "/_view/atladmin/taxrate");
		me.add("fy/admin/base/unit", UnitController.class, "/_view/atladmin/unit");
	}

	/**
	 * 配置模板引擎，通常情况只需配置共享的模板函数
	 */
	public void configEngine(Engine me) {
		me.setDevMode(p.getBoolean("engineDevMode", false));

		me.addDirective("role", RoleDirective.class);
		me.addDirective("permission", PermissionDirective.class);
		me.addDirective("perm", PermissionDirective.class); // 配置一个别名指令

		me.addSharedFunction("/_view/common/__layout.html");
		me.addSharedFunction("/_view/common/_paginate.html");

		me.addSharedFunction("/_view/_admin/common/__admin_layout.html");
		me.addSharedFunction("/_view/_admin/common/_admin_paginate.html");

		me.addSharedFunction("/_view/atladmin/common/layout.html");
		me.addSharedFunction("/_view/atladmin/common/admin_paginate.html");
	}

	/**
	 * 抽取成独立的方法，便于 _Generator 中重用该方法，减少代码冗余
	 */
	public static DruidPlugin getDruidPlugin() {
		return new DruidPlugin(p.get("jdbcUrl"), p.get("user"), p.get("password").trim());
	}

	public void configPlugin(Plugins me) {
		DruidPlugin druidPlugin = getDruidPlugin();
		wallFilter = new WallFilter(); // 加强数据库安全
		wallFilter.setDbType("mysql");
		druidPlugin.addFilter(wallFilter);
		druidPlugin.addFilter(new StatFilter()); // 添加 StatFilter 才会有统计数据
		me.add(druidPlugin);

		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		arp.setTransactionLevel(Connection.TRANSACTION_READ_COMMITTED);
		_MappingKit.mapping(arp);

		com.chen.fy.model._MappingKit.mapping(arp);
		// 强制指定复合主键的次序，避免不同的开发环境生成在 _MappingKit 中的复合主键次序不相同
		arp.setPrimaryKey("document", "mainMenu,subMenu");
		me.add(arp);
		arp.setShowSql(p.getBoolean("devMode", false));
		arp.getEngine().setSourceFactory(new ClassPathSourceFactory());
		arp.addSqlTemplate("/sql/all_sqls.sql");

		me.add(new EhCachePlugin());
		me.add(new Cron4jPlugin(p));
	}

	public void configInterceptor(Interceptors me) {
		me.add(new LoginSessionInterceptor());
	}

	public void configHandler(Handlers me) {
		me.add(DruidKit.getDruidStatViewHandler()); // druid 统计页面功能
		me.add(new UrlSeoHandler()); // index、detail 两类 action 的 url seo
	}

	/**
	 * 本方法会在 jfinal 启动过程完成之后被回调，详见 jfinal 手册
	 */
	public void afterJFinalStart() {
		// 调用不带参的 renderJson() 时，排除对 loginAccount、remind 的 json 转换
		JsonRender.addExcludedAttrs(LoginService.loginAccountCacheName, LoginSessionInterceptor.remindKey,
				FriendInterceptor.followNum, FriendInterceptor.fansNum, FriendInterceptor.friendRelation);

		// 让 druid 允许在 sql 中使用 union
		// https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE-wallfilter
		wallFilter.getConfig().setSelectUnionCheck(false);
	}
}
