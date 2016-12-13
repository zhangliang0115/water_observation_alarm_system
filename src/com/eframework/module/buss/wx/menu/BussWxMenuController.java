package com.eframework.module.buss.wx.menu;

import java.util.List;

import com.eframework.core.control.EController;
import com.eframework.core.control.IController;
import com.eframework.ext.searchinfo.SearchInfo;
import com.eframework.kit.StrKit;
import com.eframework.model.BussWxEventMsg;
import com.eframework.model.BussWxMenu;
import com.eframework.module.buss.wx.event.msg.BussWxEventMsgService;
import com.eframework.module.buss.wx.tag.BussWxTagService;
import com.eframework.module.weixin.WeiApiConfig;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.MenuApi;

/**
 * 微信菜单控制层
 */
@ControllerBind(controllerKey = "/buss/wx/menu")
public class BussWxMenuController extends EController implements IController{

	BussWxMenuService service = BussWxMenuService.service;

	@Override
	public void index() {}

	@Override
	public void add() {edit();render("edit.jsp");}

	@Override
	public void edit() {
		BussWxMenu obj;
		if(StrKit.isBlank(getPara("uuid"))){
			obj=getModel(BussWxMenu.class, "obj");
		}else{
			obj=service.findByUUID(getPara("uuid"));
		}
		if(!StrKit.isBlank(obj.getEventNo())){
			BussWxEventMsg event=BussWxEventMsgService.service.findByEventNo(obj.getEventNo());
			setAttr("event", event);
		}
		setAttr("obj", obj);
		render("edit.jsp");
	}

	@Override
	public void save() {
		BussWxMenu model = getModel(BussWxMenu.class, "obj");
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
	
	public void pub() {
		ApiConfigKit.setThreadLocalApiConfig(WeiApiConfig.init());
		SearchInfo info=getSearchInfo();
		Integer menu_type=getParaToInt("menu_type");
		info.addSqlWhereStr(" menu_type="+menu_type);
		List<Record> list=service.pubData(info);
		Record record=new Record();
		record.set("button", list);
		ApiResult rs=null;
		if(menu_type==0){
			rs=MenuApi.createMenu(JsonKit.toJson(record));
			if(rs.getErrorCode()==0){
				renderJson(new Record().set("msg", "发布成功"));
			}else{
				renderJson(new Record().set("msg", rs.getErrorMsg()));
			}
		}else if(menu_type==1){
			record.set("matchrule", new Record().set("tag_id", BussWxTagService.service.getTagId(1000)));
			rs=MenuApi.addConditional(JsonKit.toJson(record));
			if(rs.get("menuid")!=null){
				renderJson(new Record().set("msg", "发布成功"));
			}else{
				renderJson(new Record().set("msg", rs.get("errorMsg")));
			}
		}else if(menu_type==2){
			record.set("matchrule", new Record().set("tag_id", BussWxTagService.service.getTagId(1001)));
			rs=MenuApi.addConditional(JsonKit.toJson(record));
			if(rs.get("menuid")!=null){
				renderJson(new Record().set("msg", "发布成功"));
			}else{
				renderJson(new Record().set("msg", rs.get("errorMsg")));
			}
		}
	}
	
	

}