package com.capgemini.librarymanagement.service;

import com.capgemini.librarymanagement.dao.UserDAO;
import com.capgemini.librarymanagement.dao.UserDAOImpl;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserInfoBean;

public class UserServiceImpl implements UserService{
	
	private UserDAO dao=new UserDAOImpl();

	
	public BookInfo searchBookWithName(String name) {
		return dao.searchBookWithName(name);
	}

	public boolean requestCheck(BookInfo bookInfo, UserInfoBean bean) {
		return dao.requestCheck(bookInfo);
	}

	public boolean bookReturn() {
		return dao.bookReturn();
	}

	
}
