package com.eframework.module.buss.wx.tag;

import com.eframework.core.control.EController;

import com.eframework.core.control.IController;

import com.eframework.model.BussWxTag;

import com.eframework.kit.StrKit;

import com.jfinal.ext.route.ControllerBind;

import com.jfinal.plugin.activerecord.Record;

/**
 * 微信Tag控制层
 */
@ControllerBind(controllerKey = "/buss/wx/tag")
public class BussWxTagController extends EController implements IController{

	BussWxTagService service = BussWxTagService.service;

	@Override
	public void index() {}

	@Override
	public void add() {edit();render("edit.jsp");}

	@Override
	public void edit() {
		BussWxTag obj;
		if(StrKit.isBlank(getPara("uuid"))){
			obj=getModel(BussWxTag.class, "obj");
		}else{
			obj=service.findByUUID(getPara("uuid"));
		}
		setAttr("obj", obj);
		render("edit.jsp");
	}

	@Override
	public void save() {
		BussWxTag model = getModel(BussWxTag.class, "obj");
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