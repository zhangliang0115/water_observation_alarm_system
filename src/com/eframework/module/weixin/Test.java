package com.eframework.module.weixin;

import com.jfinal.kit.JsonKit;
import com.jfinal.kit.PropKit;
import com.jfinal.qy.weixin.sdk.api.ApiConfig;
import com.jfinal.qy.weixin.sdk.api.ApiConfigKit;
import com.jfinal.qy.weixin.sdk.api.ApiResult;
import com.jfinal.qy.weixin.sdk.api.OAuthApi;

public class Test {
	
	public static ApiConfig getApiConfig() {
		ApiConfig ac = new ApiConfig();
		
		// 配置微信 API 相关常量
		ac.setToken("123456");
		ac.setCorpId("wx89ef4cceacf98c0e");
		ac.setCorpSecret("vk0C_p7UBhUJYZv6FTblXX8FJqo-2Gv4IB4B-ZY2xK5mvd7jqbD22PgXipqd6yBw");
		return ac;
	}

	public static void main(String[] args) {
		ApiConfigKit.setThreadLocalApiConfig(getApiConfig());
//		String code="5e1820dfe064901eb01c13ef24feb8a7";
//		ApiResult userInfoApiResult = OAuthApi.getUserInfoByCode(code);
//		System.out.println(JsonKit.toJson(userInfoApiResult));
		String userId="13685353010";
		ApiResult toOpenIdApiResult = OAuthApi.ToOpenId("{\"userid\":\""+userId+"\",\"agentid\":1}");
		System.out.println(toOpenIdApiResult);
	}
}
