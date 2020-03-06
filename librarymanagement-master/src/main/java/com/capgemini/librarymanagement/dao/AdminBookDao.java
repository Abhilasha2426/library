package com.capgemini.librarymanagement.dao;

import java.util.List;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserInfoBean;

public interface AdminBookDao {

	public boolean addBook(BookInfo bookInfo);

	public boolean addUser(UserInfoBean userInfoBean);

	public boolean deleteUser(String userId);

	public boolean deleteBook(String bookId);
	
	public UserInfoBean updateUser(UserInfoBean userInfoBean);

	public List<UserInfoBean> showAllUser();
	
	public List<BookInfo> showAllBooks();
	
	public boolean requestPass();
	
	
	public boolean bookRecieve();
	
	
	

}
