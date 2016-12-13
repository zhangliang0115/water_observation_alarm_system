package com.xm.config;

import com.eframework.config.callback.AfterJFinalStart;
import com.eframework.module.sys.module.SysModuleService;

public class SysAfterJFinalStart extends AfterJFinalStart {

	@Override
	public void run() {
		 SysModuleService.initShiro();
	}

}
