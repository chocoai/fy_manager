package com.chen.fy.controller.business.waitInhouse;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.chen.fy.controller.BaseController;
import com.chen.fy.directive.OrderColorDirective;
import com.chen.fy.directive.TaxRateDirective;
import com.jfinal.club.common.kit.Constant;
import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.template.Engine;

public class WaitInhouseController extends BaseController {
	WaitInhouseService service = WaitInhouseService.me;
	private static final Logger logger = LogManager.getLogger(WaitInhouseController.class);
	Engine engine;

	public WaitInhouseController() {
		engine = new Engine();
		engine.setToClassPathSourceFactory();
		engine.addDirective("orderColor", OrderColorDirective.class);
		engine.addDirective("taxRate", TaxRateDirective.class);

	}

	public void findJsonPage() {
		String key = getPara("keyWord");
		if (key != null) {
			key = key.trim();
		}
		String condition = getPara("condition");

		Page<Record> modelPage = null;
		try {
			modelPage = service.findPage(getParaToInt("p", 1) + 1, getPageSize(), condition, key, getLoginAccount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Ret ret = Ret.ok("msg", "加载数据");
		HashedMap<String, Object> data = new HashedMap<String, Object>();
		data.put("modelPage", modelPage);
		data.put("pageSize", getPageSize());
		engine.addSharedObject("account", getLoginAccount());
		String str = engine.getTemplate("stringTemplet/warehouse/waitIn/list.jf").renderToString(data);
		ret.set("data", str);
		ret.set(Constant.pageIndex, modelPage.getPageNumber());
		ret.set(Constant.pagePageSize, modelPage.getPageSize());
		ret.set(Constant.pageTotalRow, modelPage.getTotalRow());
		ret.set(Constant.pageListSize, modelPage.getList().size());
		renderJson(ret);
	}

	public void index() {
		String key = getPara("keyWord");
		if (key != null) {
			key = key.trim();
		}
		setAttr("keyWord", key);
		keepPara("condition", "weiwai_cate");
		String condition = getPara("condition");

		Page<Record> modelPage = null;
		try {
			modelPage = service.findPage(getParaToInt("p", 1), getPageSize(), condition, key, getLoginAccount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setAttr("modelPage", modelPage);
		StringBuilder append = new StringBuilder();
		if (StringUtils.isNotEmpty(key)) {
			append.append("&keyWord=").append(key);
		}
		append.append("&condition=").append(condition);

		setAttr("append", append.toString());
		render("waitList.html");

	}

	/**
	 * 入库
	 */
	public void inhouse() {

		Integer id = getParaToInt("id");
		String inquantity = getPara("inQuantity");
		try {
			Ret ret = service.inhouse(id, inquantity);
			renderJson(ret);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		renderJson(Ret.fail("msg", "入库失败，请查看日志"));
	}

	/**
	 * 撤回
	 */
	public void rollback() {

		Integer id = getParaToInt("id");

		try {
			Ret ret = service.rollback(id);
			renderJson(ret);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		renderJson(Ret.fail("msg", "运行请查看日志"));
	}

}
