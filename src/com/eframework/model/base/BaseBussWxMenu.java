package com.eframework.model.base;

import com.eframework.core.model.EModel;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseBussWxMenu<M extends BaseBussWxMenu<M>> extends EModel<M> {

	public void setVersion(java.lang.Integer version) {
		set("version", version);
	}

	public java.lang.Integer getVersion() {
		return get("version");
	}

	public void setName(java.lang.String name) {
		set("name", name);
	}

	public java.lang.String getName() {
		return get("name");
	}

	public void setType(java.lang.String type) {
		set("type", type);
	}

	public java.lang.String getType() {
		return get("type");
	}

	public void setEventNo(java.lang.String eventNo) {
		set("event_no", eventNo);
	}

	public java.lang.String getEventNo() {
		return get("event_no");
	}

	public void setPid(java.lang.Integer pid) {
		set("pid", pid);
	}

	public java.lang.Integer getPid() {
		return get("pid");
	}
	
	public void setUrl(java.lang.String url) {
		set("url", url);
	}

	public java.lang.String getUrl() {
		return get("url");
	}
	
	public java.lang.String getSort() {
		return get("sort");
	}

	public void getSort(java.lang.Integer sort) {
		set("sort", sort);
	}
	
	public void setMenuType(java.lang.Integer menu_type) {
		set("menu_type", menu_type);
	}

	public java.lang.Integer getMenuType() {
		return get("menu_type");
	}

}
