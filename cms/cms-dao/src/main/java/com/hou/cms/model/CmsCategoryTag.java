package com.hou.cms.model;

/**
 * @author : houlk
 * @description :
 * @date : 2017/12/21
 */
public class CmsCategoryTag {
	private Integer categoryTagId;
	private Integer categoryId;
	private Integer tagId;
	
	public Integer getCategoryTagId() {
		return categoryTagId;
	}
	
	public void setCategoryTagId(Integer categoryTagId) {
		this.categoryTagId = categoryTagId;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	public Integer getTagId() {
		return tagId;
	}
	
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
}
