package com.capgemini.librarymanagement.db;

import java.util.LinkedList;
import java.util.List;

import com.capgemini.librarymanagement.dto.AdminInfoBean;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.BookUserRel;
import com.capgemini.librarymanagement.dto.UserBookDetail;
import com.capgemini.librarymanagement.dto.UserInfoBean;

public class DbStore1 {
	public final static List<AdminInfoBean> adminInfoBeans = new LinkedList<AdminInfoBean>();
	public final static List<BookInfo> bookInfo = new LinkedList<BookInfo>();
	public final static List<UserInfoBean> userInfoBean = new LinkedList<UserInfoBean>();
	public final static List<UserBookDetail> userBookDetails = new LinkedList<UserBookDetail>();
	public final static List<UserInfoBean> user = new LinkedList<UserInfoBean>();
	public final static List<BookUserRel> userBorrowedBook = new LinkedList<BookUserRel>();
	public final static List<BookUserRel> userReturnBooks = new LinkedList<BookUserRel>();

	static {
		BookInfo bookInfo1 = new BookInfo();
		bookInfo1.setBookId("7");
		bookInfo1.setBookName("My Truth");
		bookInfo1.setBookAuthor("Indhira Gandhi");
		bookInfo1.setNoOfBooks("12");
		bookInfo1.setPublisher("Abhi");
		bookInfo.add(bookInfo1);

		BookInfo bookInfo2 = new BookInfo();
		bookInfo2.setBookId("8");
		bookInfo2.setBookName("Death Of City");
		bookInfo2.setBookAuthor("Amrita Pritam");
		bookInfo2.setNoOfBooks("14");
		bookInfo2.setPublisher("Komathi");
		bookInfo.add(bookInfo2);

		BookInfo bookInfo3 = new BookInfo();
		bookInfo3.setBookId("9");
		bookInfo3.setBookName("Jail Dairy ");
		bookInfo3.setBookAuthor("Chandrashekar");
		bookInfo3.setNoOfBooks("56");
		bookInfo3.setPublisher("Sangeetha");
		bookInfo.add(bookInfo3);

		BookInfo bookInfo4 = new BookInfo();
		bookInfo4.setBookId("10");
		bookInfo4.setBookName("Half Girl Friend");
		bookInfo4.setBookAuthor("Chetan Bhagat");
		bookInfo4.setNoOfBooks("34");
		bookInfo4.setPublisher("Rohit");
		bookInfo.add(bookInfo4);

		UserInfoBean userInfoBean1 = new UserInfoBean();
		userInfoBean1.setUsrId("7");
		userInfoBean1.setUsrName("Abhilasha");
		userInfoBean1.setUsrEmail("abhi@gmail.com");
		userInfoBean1.setUsrPassword("Abhi@123");
		userInfoBean.add(userInfoBean1);

		UserInfoBean userInfoBean2 = new UserInfoBean();
		userInfoBean2.setUsrId("8");
		userInfoBean2.setUsrName("Sangeetha");
		userInfoBean2.setUsrEmail("sangi@gmail.com");
		userInfoBean2.setUsrPassword("Sangi@123");
		userInfoBean.add(userInfoBean2);

		UserInfoBean userInfoBean3 = new UserInfoBean();
		userInfoBean3.setUsrId("9");
		userInfoBean3.setUsrName("Rohit");
		userInfoBean3.setUsrEmail("rohit@gmail.com");
		userInfoBean3.setUsrPassword("Rohit@123");
		userInfoBean.add(userInfoBean3);

		UserInfoBean userInfoBean4 = new UserInfoBean();
		userInfoBean4.setUsrId("10");
		userInfoBean4.setUsrName("Komathi");
		userInfoBean4.setUsrEmail("komathi@gmail.com");
		userInfoBean4.setUsrPassword("Komathi@123");
		userInfoBean.add(userInfoBean4);

	}

}
