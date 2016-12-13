package com.eframework.module.weixin;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiResult;
import com.jfinal.weixin.sdk.api.TagApi;
import com.jfinal.weixin.sdk.jfinal.ApiController;

public class WeixinApiController extends ApiController {

	@Override
	public ApiConfig getApiConfig() {
		return WeiApiConfig.init();
	}

	public void index() {
		render("/api/index.html");
	}


	/**
	 * 获取公众号关注用户
	 */
	public void getFollowers() {
//		TagApi.create("物料厂家");
//		TagApi.create("稽查人员");
		ApiResult ar=TagApi.getUser(101);
//		ApiResult ar=TagApi.batchAddTag(100, Lists.newArrayList("oaZJ9v5k5Kz1Eu-OYutlxnJ9lSXw"));
//		ApiResult ar=MenuApi.tryMatch("oaZJ9v5k5Kz1Eu-OYutlxnJ9lSXw");
		renderJson(ar);
	}

}
