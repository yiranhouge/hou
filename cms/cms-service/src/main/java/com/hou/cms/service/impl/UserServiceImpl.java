package com.hou.cms.service.impl;

import com.hou.cms.mapper.UserMapper;
import com.hou.cms.mapper.UserVOMapper;
import com.hou.cms.model.User;
import com.hou.cms.model.UserVO;
import com.hou.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author : houlk
 * @description :用户service实现
 * @date : 2017/12/18
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserVOMapper userVOMapper;
	
	/**
	 * 获取带book数据的用户
	 *
	 * @param id id
	 * @return
	 */
	public UserVO selectUserWithBook(int id) {
		return userVOMapper.selectUserWithBook(id);
	}
	
	/**
	 * 根据条件获取用户列表
	 *
	 * @param map 参数
	 * @return
	 */
	public List<User> selectAll(Map<String, Object> map) {
		return userVOMapper.selectAll(map);
	}
	
	/**
	 * 插入用户并返回主键
	 *
	 * @param user 用户
	 */
	public void insertAutoKey(User user) {
		this.userVOMapper.insertAutoKey(user);
	}
	
	/**
	 * 获取基本操作mapper
	 *
	 * @return
	 */
	public UserMapper getMapper() {
		return userMapper;
	}
}
