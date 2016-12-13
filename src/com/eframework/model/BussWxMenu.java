package com.eframework.model;

import java.io.Serializable;
import com.eframework.model.base.BaseBussWxMenu;

/**
 * 微信菜单
 */
@SuppressWarnings("serial")
public class BussWxMenu extends BaseBussWxMenu<BussWxMenu>  implements Serializable{
	public static final BussWxMenu dao = new BussWxMenu();
}
