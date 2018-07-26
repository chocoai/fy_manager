package com.chen.fy.Interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class MenuActiveInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		String key = inv.getActionKey();

		if (key.startsWith("/fy/admin/syaccount") || key.startsWith("/fy/admin/syaccount")) {
			inv.getController().setAttr("sys", "active  menu-open");
		} else if (key.startsWith("/fy/admin/base")) {
			inv.getController().setAttr("base", "active  menu-open");
		} else if (key.startsWith("/fy/admin/biz/fyorder")) {
			inv.getController().setAttr("fyorder", "active  menu-open");
		} else if (key.startsWith("/fy/admin/biz/produce")) {
			inv.getController().setAttr("produce", "active  menu-open");
		} else if (key.startsWith("/fy/admin/biz/whouse")) {
			inv.getController().setAttr("whouse", "active  menu-open");
		} else if (key.startsWith("/fy/admin/biz/finance")) {
			inv.getController().setAttr("finance", "active  menu-open");
		} else if (key.startsWith("/fy/admin/biz/aftersale")) {
			inv.getController().setAttr("aftersale", "active  menu-open");
		} else if (key.startsWith("/fy/admin/biz/commission")) {
			inv.getController().setAttr("commission", "active  menu-open");
		}
		inv.invoke();
	}

}
