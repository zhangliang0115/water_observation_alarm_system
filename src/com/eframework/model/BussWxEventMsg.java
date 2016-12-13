package com.eframework.model;

import java.io.Serializable;
import com.eframework.model.base.BaseBussWxEventMsg;

/**
 * 微信事件回复消息
 */
@SuppressWarnings("serial")
public class BussWxEventMsg extends BaseBussWxEventMsg<BussWxEventMsg>  implements Serializable{
	public static final BussWxEventMsg dao = new BussWxEventMsg();
}
