package com.capgemini.librarymanagement.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.librarymanagement.db.DbStore1;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.BookUserRel;
import com.capgemini.librarymanagement.dto.UserBookDetail;
import com.capgemini.librarymanagement.dto.UserInfoBean;

public class UserDAOImpl implements UserDAO {

	static int count = 0;


	public BookInfo searchBookWithName(String name) {
		for (BookInfo book : DbStore1.bookInfo) {
			if (book.getBookName().startsWith(name)  || book.getBookAuthor().startsWith(name)) {
				return book;
			}
			}
		return null;
	}

	public boolean requestCheck(BookInfo book) {
		UserBookDetail bookDetail = new UserBookDetail();
		bookDetail.setBookId(book.getBookId());
		bookDetail.setCount(1);
		bookDetail.setUserId(DbStore1.user.get(0).getUsrId());
		DbStore1.userBookDetails.add(bookDetail);
		
		for (UserBookDetail bookDetailReq : DbStore1.userBookDetails) {
			System.out.println("Book Id:"+bookDetailReq.getBookId());
			System.out.println("User Id:"+bookDetailReq.getUserId());
		}
		return true;
	}

	public boolean bookReturn() {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter return date");
		String date=scanner.next();
		BookUserRel userRel = new BookUserRel();
		List<UserBookDetail> bookList = new LinkedList<UserBookDetail>();
		for ( BookUserRel  relation: DbStore1.userBorrowedBook) {
			try {
				userRel.setReturnDate(new SimpleDateFormat("dd-MM-yyyy").parse(date));
			} catch (ParseException e) {
				System.err.println(e.getMessage());
			}
			
			userRel.setUserInfoBean(relation.getUserInfoBean());
			
			bookList.addAll(relation.getBook());
		}
		DbStore1.userReturnBooks.add(userRel);
//		
		return true;
	}
 
}
