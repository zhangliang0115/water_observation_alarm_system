package com.eframework.model;

import java.io.Serializable;
import com.eframework.model.base.BaseBussAccountThirdparty;

/**
 * 第三方用户信息
 */
@SuppressWarnings("serial")
public class BussAccountThirdparty extends BaseBussAccountThirdparty<BussAccountThirdparty>  implements Serializable{
	public static final BussAccountThirdparty dao = new BussAccountThirdparty();
}
