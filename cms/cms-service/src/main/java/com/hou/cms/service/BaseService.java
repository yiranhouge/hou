package com.hou.cms.service;

/**
 * @author : houlk
 * @description :baseService 接口
 * @date : 2017/12/18
 */
public interface BaseService<Mapper> {
	/**
	 * 获取基本Mapper
	 * @return
	 */
	Mapper getMapper();
}
