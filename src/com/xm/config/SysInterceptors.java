package com.xm.config;

import com.eframework.config.interceptor.ConfigInterceptor;
import com.eframework.interceptor.ActionLogInterceptor;
import com.eframework.interceptor.DefaultAddFieldByMethodRegex;
import com.eframework.interceptor.RequestInterceptor;
import com.eframework.shiro.ShiroInterceptor;
import com.jfinal.config.Interceptors;

public class SysInterceptors extends ConfigInterceptor {

	@Override
	public void config(Interceptors me) {
		me.add(new RequestInterceptor());
		me.add(new ShiroInterceptor());
		me.addGlobalServiceInterceptor(new DefaultAddFieldByMethodRegex(".*save.*"));
		//操作日志
		me.addGlobalActionInterceptor(new ActionLogInterceptor());
	}

}
