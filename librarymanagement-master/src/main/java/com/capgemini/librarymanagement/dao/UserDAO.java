package com.capgemini.librarymanagement.dao;

import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserInfoBean;

public interface UserDAO {
	
	public BookInfo searchBookWithName(String name);
	public boolean requestCheck(BookInfo bookInfo);
	public boolean bookReturn();
}
