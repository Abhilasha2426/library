package com.capgemini.librarymanagement.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserBookDetail;
import com.capgemini.librarymanagement.dto.UserInfoBean;
import com.capgemini.librarymanagement.exception.BookGenericException;
import com.capgemini.librarymanagement.exception.UserGenericException;

class LibraryManagementDaoTests {

	private BookInfo bookInfo = new BookInfo();
	private UserInfoBean userInfoBean = new UserInfoBean();
	private AdminBookDao dao = new AdminBookDaoImpl();
	private UserDAO userdDao = new UserDAOImpl();
	private UserBookDetail bookDetail = new UserBookDetail();

	// @BeforeEach
	// void addBook(BookInfo bookInfo) {
	// bookInfo.setBookId("01");
	// bookInfo.setBookName("Java Black Book");
	// bookInfo.setBookAuthor("Steven");
	// bookInfo.setNoOfBooks("10");
	// bookInfo.setPublisher("Dreamtech Press");
	// dao.addBook(bookInfo);
	// }

	@Test
	void testAddBook() {
		bookInfo = new BookInfo();
		bookInfo.setBookId("11");
		bookInfo.setBookName("OCA");
		bookInfo.setBookAuthor("Jeanne Boyarsky");
		bookInfo.setNoOfBooks("100");
		bookInfo.setPublisher("Sybex");
		try {
			boolean expectedFlag = dao.addBook(bookInfo);
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(BookGenericException.class, () -> {
				dao.addBook(bookInfo);
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
			boolean expectedFlag = dao.addUser(userInfoBean);
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(UserGenericException.class, () -> {
				dao.addUser(userInfoBean);
			});
		}

	}

	@Test
	void testDeleteBook() {
		bookInfo = new BookInfo();
		bookInfo.setBookId("11");
		try {
			boolean expectedFlag = dao.deleteBook(bookInfo.getBookId());
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(BookGenericException.class, () -> {
				dao.deleteBook(bookInfo.getBookId());

			});
		}
	}

	@Test
	void testDeleteUser() {
		userInfoBean = new UserInfoBean();
		userInfoBean.setUsrId("27");
		try {
			boolean expectedFlag = dao.deleteUser(userInfoBean.getUsrId());
			assertEquals(expectedFlag, true);
		} catch (Exception e) {
			assertThrows(UserGenericException.class, () -> {
				dao.deleteUser(userInfoBean.getUsrId());

			});
		}
	}

	@Test
	void testShowAllBooks() {
		List<BookInfo> allBooks = dao.showAllBooks();
		assertNotNull(allBooks);
	}

	@Test
	void testShowAllUser() {
		List<UserInfoBean> allUsers = dao.showAllUser();
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
			UserInfoBean expectedFlag = dao.updateUser(userInfoBean);
			assertEquals(expectedFlag, userInfoBean);
		} catch (Exception e) {
			assertThrows(UserGenericException.class, () -> {
				dao.updateUser(userInfoBean);
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
			BookInfo expectedFlag = userdDao.searchBookWithName(bookInfo.getBookName());
			assertEquals(expectedFlag, bookInfo);
		} catch (Exception e) {
			assertThrows(UserGenericException.class, ()->{
				userdDao.searchBookWithName(bookInfo.getBookName());
			});
		}
		
	}
	
	
//	void testRequestCheck() {
//		bookDetail = new UserBookDetail();
//		bookDetail.setUserId("11");
//		bookDetail.setBookId("21");
//		bookDetail.setIssueDate(23-03-2020);
//		
//	}
}
