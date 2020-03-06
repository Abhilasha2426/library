package com.capgemini.librarymanagement.controller;

import java.util.Date;
import java.util.Scanner;

import com.capgemini.librarymanagement.LibraryMainPage;
import com.capgemini.librarymanagement.db.DbStore1;
import com.capgemini.librarymanagement.dto.BookInfo;
import com.capgemini.librarymanagement.dto.UserBookDetail;
import com.capgemini.librarymanagement.dto.UserInfoBean;
import com.capgemini.librarymanagement.exception.BookGenericException;
import com.capgemini.librarymanagement.service.UserService;
import com.capgemini.librarymanagement.service.UserServiceImpl;
import com.capgemini.librarymanagement.validation.LibraryManageValidation;

public class UserController {

	UserService userService = new UserServiceImpl();
	Scanner scanner = new Scanner(System.in);

	public void user() {
		System.out.println("User login successfully");
		while (true) {
			System.out.println("Enter your choice");
			System.out.println("1.Search Book\n2.Logout");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				displaySearchBookWithName();
				break;
			case 2:
				System.out.println("Logout Successfull");
				LibraryMainPage.main(null);

				break;

			}
		}
	}

	// private void displaySearchBook() {
	// System.out.println("Search Based on Book Id");
	// String bookId = scanner.next();
	// LibraryManageValidation searchIdValidation = new LibraryManageValidation();
	// if (searchIdValidation.bookValidation(bookId)) {
	// BookInfo book = userService.searchBook(bookId);
	// if (book != null) {
	// System.out.println(book.getBookName());
	// }
	// } else {
	// throw new BookGenericException("Invalid book id");
	//
	// }
	//
	// }

	private void displaySearchBookWithName() {
		System.out.println("Search Based on Book Name");
		String name = scanner.next();
		LibraryManageValidation searchValidation = new LibraryManageValidation();

		if (searchValidation.bookValidation(name)) {
			BookInfo book = userService.searchBookWithName(name);
			if (book != null) {
				System.out.println(book.getBookName());
				UserInfoBean bean = new UserInfoBean();
				System.out.println("1.Borrow\n2.Return Book\n3.Logout\n");
				int choice = scanner.nextInt();
				switch (choice) {

				case 1:
					if (barrow(book, bean)) {
						System.out.println("request sent successfully");
					} else {
						System.out.println("unable to send Request");
					}

					break;
				case 2:
					if (userService.bookReturn()) {
						System.out.println("Book Return Request Sent Successfully");

					} else {
						System.out.println("Unable to send book return request");

					}
					break;
				case 3:
					System.out.println("Logout Successfull");
					LibraryMainPage.main(null);

				default:
					break;
				}
			}else {
				try {
					throw new BookGenericException("Invalid Name");
				} catch (BookGenericException e) {
					System.out.println(e.getMessage());
				}
		} 

		}

	}

	public boolean barrow(BookInfo book, UserInfoBean bean) {

		if (userService.requestCheck(book, bean)) {
			return true;

		} else {
			return false;
		}

	}

}
