package com.hou.cms.model;

/**
 * @author : houlk
 * @description :
 * @date : 2017/12/21
 */
public class CmsArticleTag {
	private Integer articleTagId;
	private Integer articleId;
	private Integer tagId;
	
	public Integer getArticleTagId() {
		return articleTagId;
	}
	
	public void setArticleTagId(Integer articleTagId) {
		this.articleTagId = articleTagId;
	}
	
	public Integer getArticleId() {
		return articleId;
	}
	
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	public Integer getTagId() {
		return tagId;
	}
	
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
}
