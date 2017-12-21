package com.hou.model;


import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : houlk
 * @description :用户VO
 * @date : 2017/12/18
 */
@Repository
public class UserVO {
	private List<Book> books;
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
