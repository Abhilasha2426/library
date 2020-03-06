package com.capgemini.librarymanagement.service;

import java.util.List;

import com.capgemini.librarymanagement.dao.AdminBookDao;
import com.capgemini.librarymanagement.dao.AdminBookDaoImpl;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserInfoBean;

public class AdminBookServiceImpl implements AdminBookService {

	private AdminBookDao dao = new AdminBookDaoImpl();

	public boolean addBook(BookInfo bookInfo) {
		return dao.addBook(bookInfo);
	}

	public boolean addUser(UserInfoBean userInfoBean) {
		return dao.addUser(userInfoBean);
	}

	public List<UserInfoBean> showAllUser() {
		return dao.showAllUser();

	}

	public boolean deleteUser(String userId) {
		return dao.deleteUser(userId);
	}

	public boolean deleteBook(String bookId) {
		return dao.deleteBook(bookId);
	}

	public List<BookInfo> showAllBooks() {
		return dao.showAllBooks();
	}

	public UserInfoBean updateUser(UserInfoBean bean) {
		return dao.updateUser(bean);
	}

	public boolean requestPass() {
		return dao.requestPass();

	}

	public boolean bookRecieve() {
		return dao.bookRecieve();
	}

}
