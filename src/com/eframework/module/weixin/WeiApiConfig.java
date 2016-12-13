package com.eframework.module.weixin;

import com.jfinal.kit.PropKit;
import com.jfinal.weixin.sdk.api.ApiConfig;

public class WeiApiConfig{
    
    public static ApiConfig config=null;

    
    public static ApiConfig init() {
        if(config==null){
            ApiConfig ac = new ApiConfig();
            ac.setToken(PropKit.getProp("wx_config.properties").get("token"));
            ac.setAppId(PropKit.getProp("wx_config.properties").get("appId"));
    		ac.setAppSecret(PropKit.getProp("wx_config.properties").get("appSecret"));
         //   ApiConfigKit.setAccessTokenCache(new DbAccessTokenCache()); 
            config=ac;
        }
        return config;
    }

   

}
