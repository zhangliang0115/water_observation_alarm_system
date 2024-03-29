package com.eframework.model;

import java.util.Map;
import java.util.HashMap;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

/**
 * Generated by JFinal, do not modify this file.
 * <pre>
 * Example:
 * public void configPlugin(Plugins me) {
 *     ActiveRecordPlugin arp = new ActiveRecordPlugin(...);
 *     _MappingKit.mapping(arp);
 *     me.add(arp);
 * }
 * </pre>
 */
public class _ModuleMappingKit {

	public static Map<String,Object> map=new HashMap<String,Object>();

	public static void mapping(ActiveRecordPlugin arp) {
		arp.addMapping("buss_account_info", "id", BussAccountInfo.class);
		map.put("BussAccountInfo", BussAccountInfo.class);
		arp.addMapping("buss_account_thirdparty", "id", BussAccountThirdparty.class);
		map.put("BussAccountThirdparty", BussAccountThirdparty.class);
		arp.addMapping("buss_wx_event_msg", "id", BussWxEventMsg.class);
		map.put("BussWxEventMsg", BussWxEventMsg.class);
		arp.addMapping("buss_wx_menu", "id", BussWxMenu.class);
		map.put("BussWxMenu", BussWxMenu.class);
		arp.addMapping("buss_wx_tag", "id", BussWxTag.class);
		map.put("BussWxTag", BussWxTag.class);
		
	}
}

