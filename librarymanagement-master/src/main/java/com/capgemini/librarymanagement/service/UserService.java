package com.capgemini.librarymanagement.service;

import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserInfoBean;

public interface UserService {
	
	public BookInfo searchBookWithName(String name);
	public boolean requestCheck(BookInfo bookInfo, UserInfoBean bean);
	public boolean bookReturn();
}
