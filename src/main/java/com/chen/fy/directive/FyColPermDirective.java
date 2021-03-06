package com.chen.fy.directive;

import javax.servlet.http.HttpSession;

import com.chen.fy.model.Account;
import com.jfinal.template.Directive;
import com.jfinal.template.Env;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;

public class FyColPermDirective extends Directive {

	@Override
	public void exec(Env env, Scope scope, Writer writer) {
		// scope.get("session");获取session
		Object[] param = exprList.evalExprList(scope);
		String ctable = param[0].toString();
		String ckey = param[1].toString();
		Account account = (Account) ((HttpSession) scope.get("session")).getAttribute("account");
		// FyLoginSessionInterceptor.getThreadLocalAccount();

		if (account.hasColPermission(ctable, ckey)) {
			stat.exec(env, scope, writer);
		}
		// if (account.getId() == 1) {// 管理员
		// stat.exec(env, scope, writer);
		// } else {
		// if (account != null) {
		// List<String> list = FyAuthService.me.getPermession(account.getId());
		// if (list.contains(key)) {
		// stat.exec(env, scope, writer);
		// }
		// }
		// }

	}

	@Override
	public boolean hasEnd() {
		// TODO Auto-generated method stub
		return true;
	}

}
