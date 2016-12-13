package com.eframework.model;

import java.io.Serializable;
import com.eframework.model.base.BaseBussAccountInfo;

/**
 * 注册用户
 */
@SuppressWarnings("serial")
public class BussAccountInfo extends BaseBussAccountInfo<BussAccountInfo>  implements Serializable{
	public static final BussAccountInfo dao = new BussAccountInfo();
}
