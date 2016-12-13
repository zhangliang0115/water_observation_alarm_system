package com.eframework.module.buss.wx.event.msg;

import com.eframework.annotation.ActionMethod;
import com.eframework.core.control.EController;

import com.eframework.core.control.IController;

import com.eframework.core.model.PageInfo;
import com.eframework.model.BussWxEventMsg;

import com.eframework.kit.StrKit;

import com.jfinal.ext.route.ControllerBind;

import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * 微信事件回复消息控制层
 */
@ControllerBind(controllerKey = "/buss/wx/event/msg")
public class BussWxEventMsgController extends EController implements IController{

	BussWxEventMsgService service = BussWxEventMsgService.service;

	@Override
	public void index() {}

	@Override
	public void add() {edit();render("editcsddddd.jsp");}

	@Override
	public void edit() {
		BussWxEventMsg obj;
		if(StrKit.isBlank(getPara("uuid"))){
			obj=getModel(BussWxEventMsg.class, "obj");
		}else{
			obj=service.findByUUID(getPara("uuid"));
		}
		setAttr("obj", obj);
		render("edit.jsp");
	}

	@Override
	public void save() {
		BussWxEventMsg model = getModel(BussWxEventMsg.class, "obj");
		service.save(model);
		renderJson(new Record().set("rs", "ok"));
	}

	@Override
	public void del() {
		Long[] ids = getParaValuesToLong("ids");
		service.delByIds(ids);
		PageInfo page = service.page(getSearchInfo());
		List<?> rows = page.getRows();
		for (int i = 0; i < rows.size(); i++) {


		}
		System.out.println(rows);
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
	
	
	@ActionMethod("选择事件模板")
	public void select() {}

}