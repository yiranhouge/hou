package com.hou.cms.mapper;

import com.hou.cms.model.UserExample;
import com.hou.cms.model.User;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * @author : houlk
 * @description :
 * @date : 2017/12/14
 */
public interface UserMapper {
	int countByExample(UserExample example);
	
	int deleteByExample(UserExample example);
	
	int deleteByPrimaryKey(Integer id);
	
	int insert(User record);
	
	int insertSelective(User record);
	
	List<User> selectByExampleWithBLOBs(UserExample example);
	
	List<User> selectByExample(UserExample example);
	
	User selectByPrimaryKey(Integer id);
	
	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);
	
	int updateByExampleWithBLOBs(@Param("record") User record, @Param("example") UserExample example);
	
	int updateByExample(@Param("record") User record, @Param("example") UserExample example);
	
	int updateByPrimaryKeySelective(User record);
	
	int updateByPrimaryKeyWithBLOBs(User record);
	
	int updateByPrimaryKey(User record);
}
