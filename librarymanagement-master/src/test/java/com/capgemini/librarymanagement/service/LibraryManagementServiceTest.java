package com.capgemini.librarymanagement.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserInfoBean;
import com.capgemini.librarymanagement.exception.BookGenericException;
import com.capgemini.librarymanagement.exception.UserGenericException;

class LibraryManagementServiceTest {
	private BookInfo bookInfo = new BookInfo();
	private UserInfoBean userInfoBean = new UserInfoBean();
	private AdminBookService adminBookService = new AdminBookServiceImpl();
	private UserService userService = new UserServiceImpl();
	
	@Test
	void testAddBook() {
		bookInfo = new BookInfo();
		bookInfo.setBookId("11");
		bookInfo.setBookName("OCA");
		bookInfo.setBookAuthor("Jeanne Boyarsky");
		bookInfo.setNoOfBooks("100");
		bookInfo.setPublisher("Sybex");
		try {
			boolean expectedFlag = adminBookService.addBook(bookInfo);
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(BookGenericException.class, () -> {
				adminBookService.addBook(bookInfo);
			});
		}

	}

	@Test
	void testAddUser() {
		userInfoBean = new UserInfoBean();
		userInfoBean.setUsrId("27");
		userInfoBean.setUsrName("James Gosling");
		userInfoBean.setUsrEmail("james@gmail.com");
		userInfoBean.setUsrPassword("James@1234");
		try {
			boolean expectedFlag = adminBookService.addUser(userInfoBean);
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(UserGenericException.class, () -> {
				adminBookService.addUser(userInfoBean);
			});
		}

	}

	@Test
	void testDeleteBook() {
		bookInfo = new BookInfo();
		bookInfo.setBookId("11");
		try {
			boolean expectedFlag = adminBookService.deleteBook(bookInfo.getBookId());
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(BookGenericException.class, () -> {
				adminBookService.deleteBook(bookInfo.getBookId());

			});
		}
	}

	@Test
	void testDeleteUser() {
		userInfoBean = new UserInfoBean();
		userInfoBean.setUsrId("27");
		try {
			boolean expectedFlag = adminBookService.deleteUser(userInfoBean.getUsrId());
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(UserGenericException.class, () -> {
				adminBookService.deleteUser(userInfoBean.getUsrId());

			});
		}
	}

	@Test
	void testShowAllBooks() {
		List<BookInfo> allBooks = adminBookService.showAllBooks();
		assertNotNull(allBooks);
	}

	@Test
	void testShowAllUser() {
		List<UserInfoBean> allUsers = adminBookService.showAllUser();
		assertNotNull(allUsers);
	}

	@Test
	void testUpdateUser() {
		userInfoBean = new UserInfoBean();
		userInfoBean.setUsrId("27");
		userInfoBean.setUsrName("James");
		userInfoBean.setUsrEmail("abhi@gmail.com");
		userInfoBean.setUsrPassword("Abhi@1234");
		try {
			UserInfoBean expectedFlag = adminBookService.updateUser(userInfoBean);
			assertEquals(expectedFlag, userInfoBean);
		} catch (Exception e) {
			assertThrows(UserGenericException.class, () -> {
				adminBookService.updateUser(userInfoBean);
			});
		}

	}

	@Test
	void testSearchBookWithName() {
		bookInfo = new BookInfo();
		bookInfo.setBookId("11");
		bookInfo.setBookName("OCA");
		bookInfo.setBookAuthor("Jeanne Boyarsky");
		bookInfo.setNoOfBooks("100");
		bookInfo.setPublisher("Sybex");
		try {
			BookInfo expectedFlag = userService.searchBookWithName(bookInfo.getBookName());
			assertEquals(expectedFlag, bookInfo);
		} catch (Exception e) {
			assertThrows(UserGenericException.class, ()->{
				userService.searchBookWithName(bookInfo.getBookName());
			});
		}
		
	}
	
	

}
