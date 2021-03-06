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

package com.chen.fy.Interceptor;

import com.chen.fy.login.LoginService;
import com.chen.fy.model.Account;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.club.common.kit.IpKit;
import com.jfinal.core.Controller;

/**
 * 从 cookie 中获取 sessionId，如果获取到则根据该值使用 LoginService 得到登录的 Account 对象 --->
 * loginAccount，供后续的流程使用
 * 
 * 注意：将此拦截器设置为全局拦截器，所有 action 都需要
 */
public class FyLoginSessionInterceptor implements Interceptor {
	/**
		 * 用于在模板指令中使用
		 */
	// private static final ThreadLocal<Account> threadLocal = new
	// ThreadLocal<Account>();
	//
	// public static Account getThreadLocalAccount() {
	// return threadLocal.get();
	// }

	public static final String remindKey = "_remind";

	public void intercept(Invocation inv) {
		// String controllerKey = inv.getControllerKey();

		// System.out.println(inv.getController().getRequest().getRequestURL());
		// System.out.println();
		//
		// System.out.println(controllerKey);
		// System.out.println(inv.getMethodName());
		String uri = inv.getController().getRequest().getRequestURI();
		if (uri.startsWith("/fy/admin")) {
			Account account = inv.getController().getSessionAttr("account");
			if (account != null) {
				inv.invoke();

			} else {

				Controller c = inv.getController();
				String sessionId = c.getCookie(LoginService.sessionIdName);
				if (sessionId != null) {
					Account loginAccount = LoginService.me.getLoginAccountWithSessionId(sessionId);
					if (loginAccount == null) {
						String loginIp = IpKit.getRealIp(c.getRequest());
						loginAccount = LoginService.me.loginWithSessionId(sessionId, loginIp);
					}
					if (loginAccount != null) {
						// 用户登录账号
						c.setAttr(LoginService.loginAccountCacheName, loginAccount);
						c.setSessionAttr(Account.sessionKey, loginAccount);
						inv.invoke();
					} else {
						c.removeCookie(LoginService.sessionIdName); // cookie 登录未成功，证明该 cookie 已经没有用处，删之
						inv.getController().redirect("/fy");
					}
				} else {
					inv.getController().redirect("/fy");
				}

			}
		} else {
			inv.invoke();
		}
	}

	public void dointer(Invocation inv) {
		Account loginAccount = null;
		Controller c = inv.getController();
		String sessionId = c.getCookie(LoginService.sessionIdName);
		if (sessionId != null) {
			loginAccount = LoginService.me.getLoginAccountWithSessionId(sessionId);
			if (loginAccount == null) {
				String loginIp = IpKit.getRealIp(c.getRequest());
				loginAccount = LoginService.me.loginWithSessionId(sessionId, loginIp);
			}
			if (loginAccount != null) {
				// 用户登录账号
				c.setAttr(LoginService.loginAccountCacheName, loginAccount);
			} else {
				c.removeCookie(LoginService.sessionIdName); // cookie 登录未成功，证明该 cookie 已经没有用处，删之
			}
		}

		inv.invoke();

		// if (loginAccount != null) {
		// // remind 对象用于生成提醒 tips
		// Remind remind = RemindService.me.getRemind(loginAccount.getId());
		// if (remind != null) {
		// if (remind.getReferMe() > 0 || remind.getMessage() > 0 || remind.getFans() >
		// 0) {
		// c.setAttr(remindKey, remind);
		// }
		// }
		// }
	}
}
