package com.xm.config;

import com.eframework.config.constant.ConfigConstant;
import com.jfinal.config.Constants;
import com.jfinal.core.Const;
import com.jfinal.kit.PropKit;
import com.jfinal.render.ViewType;

public class SysConstants extends ConfigConstant {

	@Override
	public void config(Constants me) {
		// 加载少量必要配置，随后可用PropKit.get(...)获取值
		PropKit.use("config.properties");
		PropKit.use("wx_config.properties");
        me.setBaseViewPath("/WEB-INF/page");
        me.setViewType(ViewType.JSP);
        me.setDevMode(true);
        me.setEncoding("utf-8");
        // 设置上传大小限制
        me.setMaxPostSize(1000000 * Const.DEFAULT_MAX_POST_SIZE);
	}

}
