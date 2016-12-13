package com.eframework.module.buss.account.thirdparty;

import com.eframework.core.control.EController;

import com.eframework.core.control.IController;

import com.eframework.model.BussAccountThirdparty;

import com.eframework.kit.StrKit;

import com.jfinal.ext.route.ControllerBind;

import com.jfinal.plugin.activerecord.Record;

/**
 * 第三方用户信息控制层
 */
@ControllerBind(controllerKey = "/buss/account/thirdparty")
public class BussAccountThirdpartyController extends EController implements IController{

	BussAccountThirdpartyService service = BussAccountThirdpartyService.service;

	@Override
	public void index() {}

	@Override
	public void add() {edit();render("edit.jsp");}

	@Override
	public void edit() {
		BussAccountThirdparty obj;
		if(StrKit.isBlank(getPara("uuid"))){
			obj=getModel(BussAccountThirdparty.class, "obj");
		}else{
			obj=service.findByUUID(getPara("uuid"));
		}
		setAttr("obj", obj);
		render("edit.jsp");
	}

	@Override
	public void save() {
		BussAccountThirdparty model = getModel(BussAccountThirdparty.class, "obj");
		service.save(model);
		renderJson(new Record().set("rs", "ok"));
	}

	@Override
	public void del() {
		Long[] ids = getParaValuesToLong("ids");
		service.delByIds(ids);
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