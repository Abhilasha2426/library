package com.capgemini.librarymanagement.service;

import java.util.List;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserInfoBean;

public interface AdminBookService {

	public boolean addBook(BookInfo bookInfo);

	public boolean addUser(UserInfoBean userInfoBean);

	public boolean deleteUser(String userId);

	public boolean deleteBook(String bookId);

	public UserInfoBean updateUser(UserInfoBean bean);

	public List<UserInfoBean> showAllUser();

	public List<BookInfo> showAllBooks();

	public boolean requestPass();

	public boolean bookRecieve();
}
