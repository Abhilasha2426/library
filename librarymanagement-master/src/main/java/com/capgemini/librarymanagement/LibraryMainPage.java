package com.capgemini.librarymanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.librarymanagement.controller.LibraryManagementController;
import com.capgemini.librarymanagement.controller.UserController;
import com.capgemini.librarymanagement.db.DbStore1;
import com.capgemini.librarymanagement.dto.UserInfoBean;
import com.capgemini.librarymanagement.exception.ValidInputException;

public class LibraryMainPage {

	public static void main(String str) {

		LibraryManagementController libraryManagementController = new LibraryManagementController();
		Scanner scanner = new Scanner(System.in);
		System.out.println("---*****LIBRARY MANAGEMENT SYSTEM*****---");
		System.out.println("---------------------------");
		boolean flag = true;
		while (flag) {
			System.out.println("Available Choices");
			System.out.println("1.Admin\n2.User\n3.Exit");
			System.out.println("---------------------------");
			System.out.println("Enter Your Choice");
			try {
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					System.out.println("----Login----");
					System.out.println("Enter UserName \n");
					String adminName = scanner.next();
					System.out.println("Enter Password \n");
					String adminPassword = scanner.next();
					if (adminName.equals("a") && adminPassword.equals("a")) {
						if (!DbStore1.user.isEmpty()) {
							System.out.println("req are here");
						}
						libraryManagementController.admin();
					} else {
						System.err.println("Please enter valid username and password");
					}
					break;
				case 2:
					System.out.println("----Login---->");
					System.out.println("Enter Email \n");
					String userEmail = scanner.next();
					System.out.println("Enter Password \n");
					String userPassword = scanner.next();

					for (UserInfoBean user : DbStore1.userInfoBean) {
						if (user.getUsrEmail().equals(userEmail) && user.getUsrPassword().equals(userPassword)) {
							DbStore1.user.add(user);
							UserController controller = new UserController();
							controller.user();

						} else {
							System.out.println("Please enter valid credential");
						}
					}
					break;
				case 3:
					System.exit(0);
				}
			} catch (InputMismatchException e) {

				try {
					throw new ValidInputException();
				} catch (ValidInputException exp) {
					System.out.println(exp.getMessage());
					main("start");
				}
			}
			
		}
		scanner.close();
	}
}
