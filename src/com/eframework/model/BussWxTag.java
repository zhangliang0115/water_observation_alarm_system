package com.eframework.model;

import java.io.Serializable;
import com.eframework.model.base.BaseBussWxTag;

/**
 * 微信Tag
 */
@SuppressWarnings("serial")
public class BussWxTag extends BaseBussWxTag<BussWxTag>  implements Serializable{
	public static final BussWxTag dao = new BussWxTag();
}
