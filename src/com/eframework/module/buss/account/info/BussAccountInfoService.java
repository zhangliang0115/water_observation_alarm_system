package com.eframework.module.buss.account.info;

import java.util.List;

import com.eframework.core.service.EService;
import com.eframework.model.BussAccountInfo;
import com.eframework.module.buss.wx.tag.BussWxTagService;
import com.eframework.module.weixin.WeiApiConfig;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.jfinal.aop.Duang;
import com.jfinal.kit.JsonKit;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.weixin.sdk.api.ApiConfigKit;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.TagApi;

/**
 * 注册用户业务层
 */
public class BussAccountInfoService extends EService<BussAccountInfo> {

	public static BussAccountInfoService service = Duang.duang(BussAccountInfoService.class);
	@Override
	public BussAccountInfo getModel() {
		return BussAccountInfo.dao;
	}
	
	public BussAccountInfo findByAccountThirdPartyIdAndRole(int id){
		return getModel().findFirstBy(" account_thirdparty_id =?", id);
	}
	
	
	
	public void batchPass(Integer[] ids){
		ApiConfigKit.setThreadLocalApiConfig(WeiApiConfig.init());
		int status = 1;
		List<BussAccountInfo> modelList = Lists.newArrayList();
		for (Integer id : ids) {
			BussAccountInfo model = new BussAccountInfo();
			model.setId(id);
			model.setStatus(status);
			modelList.add(model);
		}
		BussAccountInfoService.batchUpdate(modelList, 10);
		List<Record> lists=find("SELECT info.role_id,p.thirdparty_no from buss_account_info info LEFT JOIN buss_account_thirdparty  p on info.account_thirdparty_id=p.id where info.id in ("+Joiner.on(",").join(ids)+")");
		System.out.println(lists);
		List<String> role1=Lists.newArrayList();
		List<String> role2=Lists.newArrayList();
		//更新微信用户tag
		for(Record l:lists){
			if(l.getInt("role_id")==1){
				role1.add(l.getStr("thirdparty_no"));
			}else if(l.getInt("role_id")==2){
				role2.add(l.getStr("thirdparty_no"));
			}
		}
		
		if(role1.size()>0){
			int tag_id=BussWxTagService.service.getTagId(1000);
			ApiResult ar=TagApi.batchAddTag(tag_id, role1);
			System.out.println("tag_id:"+tag_id);
			System.out.println("role1:"+role1);
			System.out.println("ApiResult:"+JsonKit.toJson(ar));
		}
		if(role2.size()>0){
			int tag_id=BussWxTagService.service.getTagId(1001);
			ApiResult ar=TagApi.batchAddTag(tag_id, role2);
			System.out.println("tag_id:"+tag_id);
			System.out.println("role2:"+role2);
			System.out.println("ApiResult:"+JsonKit.toJson(ar));
		}
		//更新微信用户tag
	}
	
	public void batchUnPass(Integer[] ids){
		ApiConfigKit.setThreadLocalApiConfig(WeiApiConfig.init());
		int status = 2;
		List<BussAccountInfo> modelList = Lists.newArrayList();
		for (Integer id : ids) {
			BussAccountInfo model = new BussAccountInfo();
			model.setId(id);
			model.setStatus(status);
			modelList.add(model);
		}
		BussAccountInfoService.batchUpdate(modelList, 10);
		List<Record> lists=find("SELECT info.role_id,p.thirdparty_no from buss_account_info info LEFT JOIN buss_account_thirdparty  p on info.account_thirdparty_id=p.id where info.id in ("+Joiner.on(",").join(ids)+")");
		List<String> role1=Lists.newArrayList();
		List<String> role2=Lists.newArrayList();
		//更新微信用户tag
		for(Record l:lists){
			if(l.getInt("role_id")==1){
				role1.add(l.getStr("thirdparty_no"));
			}else if(l.getInt("role_id")==2){
				role2.add(l.getStr("thirdparty_no"));
			}
		}
		if(role1.size()>0){
			TagApi.batchDelTag(BussWxTagService.service.getTagId(1000), role1);
		}
		if(role2.size()>0){
			TagApi.batchDelTag(BussWxTagService.service.getTagId(1001), role2);
		}
		//更新微信用户tag
	}

}