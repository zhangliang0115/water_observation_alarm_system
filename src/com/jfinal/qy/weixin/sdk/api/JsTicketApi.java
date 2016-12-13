
package com.jfinal.qy.weixin.sdk.api;

import java.util.concurrent.Callable;

import com.jfinal.qy.weixin.sdk.cache.IAccessTokenCache;
import com.jfinal.qy.weixin.sdk.kit.ParaMap;
import com.jfinal.qy.weixin.sdk.utils.RetryUtils;
import com.jfinal.weixin.sdk.utils.HttpUtils;

/**
 * 
 * 生成签名之前必须先了解一下jsapi_ticket，jsapi_ticket是公众号用于调用微信JS接口的临时票据
 * https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=ACCESS_TOKEN
 * 
 */
public class JsTicketApi {

	private static String apiUrl = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket";

	static IAccessTokenCache accessTokenCache = ApiConfigKit.getAccessTokenCache();

	/**
	 * JSApi的类型
	 * 
	 * jsapi: 用于分享等js-api
	 * 
	 * 
	 */
	public enum JsApiType {
		jsapi
	}
	/**
	 * 
	 * http GET请求获得jsapi_ticket（有效期7200秒，开发者必须在自己的服务全局缓存jsapi_ticket）
	 * 
	 * @return JsTicket
	 */
	public static JsTicket getTicket(JsApiType jsApiType) {
		String access_token = AccessTokenApi.getAccessTokenStr();
		String appId = ApiConfigKit.getApiConfig().getCorpId();
		String key = appId + ':' + jsApiType.name();
		final ParaMap pm = ParaMap.create("access_token", access_token);
		
		JsTicket jsTicket = accessTokenCache.get(key);
		if (null == jsTicket || !jsTicket.isAvailable()) {
			// 最多三次请求
			jsTicket = RetryUtils.retryOnException(3, new Callable<JsTicket>() {
				
				public JsTicket call() throws Exception {
					return new JsTicket(HttpUtils.get(apiUrl, pm.getData()));
				}
				
			});
			
			accessTokenCache.set(key, jsTicket);
		}
		return jsTicket;
	}

}