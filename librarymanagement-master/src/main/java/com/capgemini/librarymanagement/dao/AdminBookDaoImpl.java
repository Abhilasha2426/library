package com.capgemini.librarymanagement.dao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.capgemini.librarymanagement.db.DbStore1;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.BookUserRel;
import com.capgemini.librarymanagement.dto.UserBookDetail;
import com.capgemini.librarymanagement.dto.UserInfoBean;

public class AdminBookDaoImpl implements AdminBookDao {

	public static int count = 0;
	public static int size = 0;
	public static int add = 0;

	public boolean addBook(BookInfo bookInfo) {
		DbStore1.bookInfo.add(bookInfo);
		return true;
	}

	public boolean addUser(UserInfoBean userInfoBean) {
		DbStore1.userInfoBean.add(userInfoBean);
		return true;
	}

	public boolean deleteUser(String userId) {
		Iterator<UserInfoBean> itr = DbStore1.userInfoBean.iterator();
		while (itr.hasNext()) {
			UserInfoBean user = itr.next();
			if (user.getUsrId().equals(userId)) {
				DbStore1.userInfoBean.remove(user);
				return true;
			}
		}
		return false;
	}

	public boolean deleteBook(String bookId) {
		Iterator<BookInfo> itr = DbStore1.bookInfo.iterator();
		while (itr.hasNext()) {
			BookInfo book = itr.next();
			if (book.getBookId().equals(bookId)) {
				DbStore1.bookInfo.remove(book);
				return true;
			}
		}
		return false;
	}

	public List<BookInfo> showAllBooks() {
		return DbStore1.bookInfo;

	}

	public List<UserInfoBean> showAllUser() {
		return (DbStore1.userInfoBean);
	}

	public UserInfoBean updateUser(UserInfoBean userInfoBean) {
		UserInfoBean bean;
		Iterator<UserInfoBean> itr = DbStore1.userInfoBean.iterator();
		while (itr.hasNext()) {
			bean = itr.next();
			if (bean.getUsrId().equals(userInfoBean.getUsrId())) {
				bean.setUsrName(userInfoBean.getUsrName());
				bean.setUsrEmail(userInfoBean.getUsrEmail());
				bean.setUsrPassword(userInfoBean.getUsrPassword());
				return bean;
			}
		}
		return null;

	}

	public boolean requestPass() {
		BookUserRel userRel = new BookUserRel();
		List<UserBookDetail> bookList = new LinkedList<UserBookDetail>();
		for (UserBookDetail books : DbStore1.userBookDetails) {
			for (UserInfoBean users : DbStore1.user) {
				if (books.getUserId() == users.getUsrId()) {
					count++;

					if (count <= 3) {
						books.setBorrowed(true);
						books.setIssueDate(new Date());
						long lTime = new Date().getTime() + 15 * 24 * 60 * 60 * 1000;

						SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

						try {
							books.setReturnDate(sdf.parse(sdf.format(new Date(lTime))));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						System.out.println("Please return at mentioned date" + books.getReturnDate());

						bookList.add(books);
						userRel.setUserInfoBean(users);
					}
				} else {
					System.out.println("Borrow limit is exceeded(more than three Books)");
				}
			}
		}
		userRel.setBook(bookList);
		DbStore1.userBorrowedBook.add(userRel);
		return true;
	}

	public boolean bookRecieve() {
		for (BookUserRel fine : DbStore1.userReturnBooks) {
			for (UserBookDetail detail : DbStore1.userBookDetails) {
				System.out.println(fine.getReturnDate());
				System.out.println(detail.getReturnDate());
				if (detail.getUserId().equals(fine.getUserInfoBean().getUsrId())) {
					if (detail.getReturnDate().compareTo(fine.getReturnDate()) < 0) {
						long diff = fine.getReturnDate().getTime() - detail.getReturnDate().getTime();
						long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

						for (BookUserRel bookUserRel : DbStore1.userBorrowedBook) {
							if (bookUserRel.getUserInfoBean().getUsrId() == detail.getUserId()) {
								size++;

							}
						}
						double amount = days * 5 * size;
						System.out.println("Fine=" + amount);
						size = 0;
					} else {
						System.out.println("You returned the book on Time");
						return true;

					}

				}
			}

		}
		return true;
	}

}
