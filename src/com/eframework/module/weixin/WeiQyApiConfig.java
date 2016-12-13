package com.eframework.module.weixin;

import com.jfinal.kit.PropKit;
import com.jfinal.qy.weixin.sdk.api.ApiConfig;

public class WeiQyApiConfig{
    
    public static ApiConfig config=null;

    
    public static ApiConfig init() {
        if(config==null){
            ApiConfig ac = new ApiConfig();
            ac.setToken(PropKit.getProp("wx_config.properties").get("token"));
    		ac.setCorpId(PropKit.getProp("wx_config.properties").get("corpId"));
    		ac.setCorpSecret(PropKit.getProp("wx_config.properties").get("secret"));
            config=ac;
        }
        return config;
    }

   

}
