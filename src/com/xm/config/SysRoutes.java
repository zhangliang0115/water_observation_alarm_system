package com.xm.config;

import com.eframework.config.route.ConfigRoute;
import com.eframework.ext.upload.UploadController;
import com.eframework.module.weixin.WeixinApiController;
import com.eframework.module.weixin.WeixinMsgController;
import com.eframework.module.weixin.qy.QyWeixinMsgController;
import com.jfinal.config.Routes;
import com.jfinal.ext.route.AutoBindRoutes;

public class SysRoutes extends ConfigRoute {

	public static Routes routes;

	@Override
	public void config(Routes me) {
		routes = me;
		AutoBindRoutes routes = new AutoBindRoutes();
		routes.addJars("eframework-sys.jar");
		routes.autoScan(false);
		me.add(routes);
		
        me.add("/upload", UploadController.class);
        me.add("/msg", WeixinMsgController.class);
        me.add("/qymsg",QyWeixinMsgController.class);
	    me.add("/api", WeixinApiController.class, "/api");
	}

}
