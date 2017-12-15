package com.hou.mapper;

import com.hou.model.Book;
import com.hou.model.BookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : houlk
 * @description :
 * @date : 2017/12/14
 */
public interface BookMapper {
	int countByExample(BookExample example);
	
	int deleteByExample(BookExample example);
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(Book record);
	
	int insertSelective(Book record);
	
	List<Book> selectByExample(BookExample example);
	
	Book selectByPrimaryKey(Integer id);
	
	int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);
	
	int updateByExample(@Param("record") Book record, @Param("example") BookExample example);
	
	int updateByPrimaryKeySelective(Book record);
	
	int updateByPrimaryKey(Book record);
}