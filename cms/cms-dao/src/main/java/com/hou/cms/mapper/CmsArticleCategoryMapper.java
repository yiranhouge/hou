package com.hou.cms.mapper;

import com.hou.cms.model.CmsArticleCategory;
import com.hou.cms.model.CmsArticleCategoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : houlk
 * @description :
 * @date : 2017/12/21
 */
public interface CmsArticleCategoryMapper {
	int countByExample(CmsArticleCategoryExample example);
	
	int deleteByExample(CmsArticleCategoryExample example);
	
	int deleteByPrimaryKey(Integer articleCategoryId);
	
	int insert(CmsArticleCategory record);
	
	int insertSelective(CmsArticleCategory record);
	
	List<CmsArticleCategory> selectByExample(CmsArticleCategoryExample example);
	
	CmsArticleCategory selectByPrimaryKey(Integer articleCategoryId);
	
	int updateByExampleSelective(@Param("record") CmsArticleCategory record, @Param("example") CmsArticleCategoryExample example);
	
	int updateByExample(@Param("record") CmsArticleCategory record, @Param("example") CmsArticleCategoryExample example);
	
	int updateByPrimaryKeySelective(CmsArticleCategory record);
	
	int updateByPrimaryKey(CmsArticleCategory record);
}
