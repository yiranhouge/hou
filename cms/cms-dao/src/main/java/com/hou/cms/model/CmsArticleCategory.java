package com.hou.cms.model;

/**
 * @author : houlk
 * @description :
 * @date : 2017/12/21
 */
public class CmsArticleCategory {
	private Integer articleCategoryId;
	private Integer articleId;
	private Integer categoryId;
	
	public Integer getArticleCategoryId() {
		return articleCategoryId;
	}
	
	public void setArticleCategoryId(Integer articleCategoryId) {
		this.articleCategoryId = articleCategoryId;
	}
	
	public Integer getArticleId() {
		return articleId;
	}
	
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}
