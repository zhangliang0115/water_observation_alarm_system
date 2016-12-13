package com.eframework.module.buss.wx.event.msg;

import java.util.Map;

import com.eframework.core.service.EService;
import com.eframework.kit.ElKit;
import com.eframework.kit.StrKit;
import com.eframework.model.BussWxEventMsg;
import com.google.common.collect.Maps;
import com.jfinal.aop.Duang;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.in.event.ScanCodeInfo;

/**
 * 微信事件回复消息业务层
 */
public class BussWxEventMsgService extends EService<BussWxEventMsg> {

	public static BussWxEventMsgService service = Duang.duang(BussWxEventMsgService.class);
	@Override
	public BussWxEventMsg getModel() {
		return BussWxEventMsg.dao;
	}
	
	public BussWxEventMsg findByEventNo(String no){
		return getModel().findFirstBy(" event_no=? ", no);
	}
	
	public String msg(InMenuEvent inMenuEvent){
		String enent_key=inMenuEvent.getEventKey();
		String msg=null;
		if(!StrKit.isBlank(enent_key)){
			BussWxEventMsg event=BussWxEventMsgService.service.findByEventNo(enent_key);
			if(event!=null){
				msg=event.getReplyMsg();
				if(!StrKit.isBlank(msg)){
					ElKit kit=new ElKit();
					Map<String,Object> map=Maps.newHashMap();
					map.put("openid", inMenuEvent.getFromUserName());
					if("1003".equals(enent_key) || "1004".equals(enent_key)){
						ScanCodeInfo info=inMenuEvent.getScanCodeInfo();
						String result=info.getScanResult();
						if(!StrKit.isBlank(result)){
							
						}
					}
					msg=kit.eval(msg, map);
				}
			}else{
			
			}
		}
		return msg;
	}

}