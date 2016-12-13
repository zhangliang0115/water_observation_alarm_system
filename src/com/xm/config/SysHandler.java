package com.xm.config;

import javax.servlet.http.HttpServletRequest;

import com.eframework.config.handler.ConfigHandler;
import com.eframework.core.handler.AttackHandler;
import com.eframework.model.SysAccount;
import com.jfinal.config.Handlers;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.plugin.druid.IDruidStatViewAuth;

public class SysHandler extends ConfigHandler {

	@Override
	public void config(Handlers me) {
		// 防xss攻击
        me.add(new AttackHandler());
        /**数据源监控**/
        DruidStatViewHandler dvh =  new DruidStatViewHandler("/druid",new IDruidStatViewAuth() {
			@Override
			public boolean isPermitted(HttpServletRequest request) {
				Controller c= new Controller() {};
				c.setHttpServletRequest(request);
				SysAccount account=c.getSessionAttr(SysDict.ACCOUNT);
				if(account!=null){
					String usern=account.getUsern();
					if(!StrKit.isBlank(usern) && com.eframework.kit.StrKit.equals("dev", usern)){
						return true;
					}
				}
				return false;
			}
		});
        me.add(dvh);

	}

}
