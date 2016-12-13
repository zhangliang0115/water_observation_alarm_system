package com.eframework.module.buss.account.thirdparty;

import com.jfinal.aop.Duang;
import com.eframework.model.BussAccountThirdparty;
import com.eframework.core.service.EService;

/**
 * 第三方用户信息业务层
 */
public class BussAccountThirdpartyService extends EService<BussAccountThirdparty> {

	public static BussAccountThirdpartyService service = Duang.duang(BussAccountThirdpartyService.class);
	@Override
	public BussAccountThirdparty getModel() {
		return BussAccountThirdparty.dao;
	}
	
	public BussAccountThirdparty findByNo(int thirdparty_id,String thirdparty_no){
		return getModel().findFirstBy(" thirdparty_id=? and thirdparty_no=? ",thirdparty_id, thirdparty_no);
	}

}