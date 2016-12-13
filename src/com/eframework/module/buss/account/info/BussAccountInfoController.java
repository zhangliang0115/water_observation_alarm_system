package com.eframework.module.buss.account.info;

import com.eframework.core.control.EController;
import com.eframework.core.control.IController;
import com.eframework.kit.StrKit;
import com.eframework.model.BussAccountInfo;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.plugin.activerecord.Record;

/**
 * 注册用户控制层
 */
@ControllerBind(controllerKey = "/buss/account/info")
public class BussAccountInfoController extends EController implements
		IController {

	BussAccountInfoService service = BussAccountInfoService.service;

	@Override
	public void index() {
	}

	public void check() {
		setAttr("status", 0);
		render("index.jsp");
	}

	public void pass() {
		setAttr("status", 1);
		render("index.jsp");
	}

	public void unpass() {
		setAttr("status", 2);
		render("index.jsp");
	}

	@Override
	public void add() {
		edit();
		render("edit.jsp");
	}

	@Override
	public void edit() {
		BussAccountInfo obj;
		if (StrKit.isBlank(getPara("uuid"))) {
			obj = getModel(BussAccountInfo.class, "obj");
		} else {
			obj = service.findByUUID(getPara("uuid"));
		}
		setAttr("obj", obj);
		render("edit.jsp");
	}

	@Override
	public void save() {
		BussAccountInfo model = getModel(BussAccountInfo.class, "obj");
		service.save(model);
		renderJson(new Record().set("rs", "ok"));
	}

	@Override
	public void del() {
		Integer[] ids = getParaValuesToInt("ids");
		service.delByIds(ids);
		renderJson(new Record().set("rs", "ok"));
	}

	public void batchPass() {
		Integer[] ids = getParaValuesToInt("ids");
		service.batchPass(ids);
		renderJson(new Record().set("rs", "ok"));
	}
	
	public void batchUnPass() {
		Integer[] ids = getParaValuesToInt("ids");
		service.batchUnPass(ids);
		renderJson(new Record().set("rs", "ok"));
	}

	@Override
	public void list() {
		renderJson(service.list(getSearchInfo()));
	}

	@Override
	public void page() {
		renderJson(service.page(getSearchInfo()));
	}

}