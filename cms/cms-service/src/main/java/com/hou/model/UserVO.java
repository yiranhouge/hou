package com.hou.model;


import java.util.List;

/**
 * @author : houlk
 * @description :用户VO
 * @date : 2017/12/18
 */
public class UserVO {
	private List<Book> books;
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
