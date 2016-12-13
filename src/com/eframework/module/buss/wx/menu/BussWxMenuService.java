package com.eframework.module.buss.wx.menu;

import java.util.List;

import com.eframework.core.service.EService;
import com.eframework.ext.searchinfo.SearchInfo;
import com.eframework.model.BussWxMenu;
import com.google.common.collect.Lists;
import com.jfinal.aop.Duang;
import com.jfinal.plugin.activerecord.Record;

/**
 * 微信菜单业务层
 */
public class BussWxMenuService extends EService<BussWxMenu> {

	public static BussWxMenuService service = Duang.duang(BussWxMenuService.class);
	@Override
	public BussWxMenu getModel() {
		return BussWxMenu.dao;
	}
	
	public List<Record> pubData(SearchInfo searchInfo){
			List<BussWxMenu> list=getModel().findBy(" pid is null "+searchInfo.getWhereStr()+" order by sort asc,id desc ");
			return transitionTree(list);
	}
	
	private List<Record> transitionTree(List<BussWxMenu> list){
		List<Record> buttons=Lists.newArrayList();
		Record button;
		for(BussWxMenu l:list){
			button=new Record().set("name", l.getName()).set("type", l.getType()).set("key", l.getEventNo()).set("url", l.getUrl());
			List<BussWxMenu> temp=getModel().findBy(" pid=? order by sort asc,id desc ",l.getId());
			if(temp!=null &&temp.size()>0){
				button.set("sub_button", transitionTree(temp));
			}
			buttons.add(button);
		}
 		return buttons;
	}
	

}