package com.eframework.model.base;

import com.eframework.core.model.EModel;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseBussWxTag<M extends BaseBussWxTag<M>> extends EModel<M> {

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

	public void setTagId(java.lang.Integer tagId) {
		set("tag_id", tagId);
	}

	public java.lang.Integer getTagId() {
		return get("tag_id");
	}

	public void setTagNo(java.lang.Integer tagNo) {
		set("tag_no", tagNo);
	}

	public java.lang.Integer getTagNo() {
		return get("tag_no");
	}

}