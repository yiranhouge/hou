package com.hou.cms.service;

import com.hou.cms.mapper.UserMapper;
import com.hou.cms.model.User;
import com.hou.cms.model.UserVO;

import java.util.List;
import java.util.Map;

/**
 * @author : houlk
 * @description :用户Service接口
 * @date : 2017/12/18
 */
public interface UserService extends BaseService<UserMapper>{
	/**
	 * 获取带book数据的用户
	 * @param id id
	 * @return
	 */
	UserVO selectUserWithBook(int id);
	
	/**
	 * 根据条件获取用户列表
	 * @param map 参数
	 * @return
	 */
	List<User> selectAll(Map<String,Object> map);
	
	/**
	 * 插入用户并返回主键
	 * @param user 用户
	 */
	void insertAutoKey(User user);
}
