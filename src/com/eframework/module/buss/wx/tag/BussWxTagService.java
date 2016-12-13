package com.eframework.module.buss.wx.tag;

import com.jfinal.aop.Duang;
import com.eframework.model.BussWxTag;
import com.eframework.core.service.EService;

/**
 * 微信Tag业务层
 */
public class BussWxTagService extends EService<BussWxTag> {

	public static BussWxTagService service = Duang.duang(BussWxTagService.class);
	@Override
	public BussWxTag getModel() {
		return BussWxTag.dao;
	}
	
	public int getTagId(int tag_no){
		int tag_id=queryInt("select tag_id from "+getModel().getTableName()+" where tag_no=? ",tag_no);
		return tag_id;
	}

}