package com.hou.mapper;

import com.hou.model.User;
import com.hou.model.UserVO;

import java.util.List;
import java.util.Map;

/**
 * @author : houlk
 * @description :用户mapper
 * @date : 2017/12/18
 */
public interface UserVOMapper extends UserMapper {
	UserVO selectUserWithBook(int id);
	
	List<User> selectAll(Map<String,Object> map);
	
	void insertAutoKey(User user);
}
