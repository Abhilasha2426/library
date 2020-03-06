package com.capgemini.librarymanagement.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.capgemini.librarymanagement.exception.BookGenericException;
import com.capgemini.librarymanagement.exception.UserGenericException;

public class LibraryManageValidation {

	final Pattern validEmail = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");

	final Pattern validName = Pattern.compile("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$");

	final Pattern validPassword = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");

	final Pattern validId = Pattern.compile("([0-9])");

	final Pattern validUserId = Pattern.compile("([0-9])");

	final Pattern validBookNum = Pattern.compile("([0-9])");

	final Pattern validDate=Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");

	public boolean bookIdValidation(String bookId) {
		Matcher bookIdMathcher = validId.matcher(bookId);
		if (bookIdMathcher.find() && bookId.length() > 0) {
			return true;
		} else {
			try {
				throw new BookGenericException("The Book id must be integer ");
			} catch (BookGenericException e) {
				System.err.println(e.getMessage());
				return false;
			}
		}

	}

	public boolean bookValidation(String name) {
		Matcher bookNameMatcher = validName.matcher(name);
		if (bookNameMatcher.find() && name.length() > 2 && name.length() < 30) {
			return true;
		} else {
			try {
				throw new BookGenericException(
						"Book Name must contain atleast 2 character and should not exceed 30 character");
			} catch (BookGenericException e) {
				System.err.println(e.getMessage());
				return false;
			}
		}
	}

	public boolean bookValidation(String bookId, String bookName, String bookAuth, String bookNum, String pubName) {
		Matcher bookNameMatcher = validName.matcher(bookName);
		Matcher authorNameMatcher = validName.matcher(bookAuth);
		Matcher publisherNameMatcher = validName.matcher(pubName);
		Matcher bookIdMathcher = validId.matcher(bookId);
		Matcher bookNumMatcher = validBookNum.matcher(bookNum);
		if (bookIdMathcher.find() && bookId.length() > 0) {
			if (bookNameMatcher.find() && bookName.length() > 2 && bookName.length() < 30) {
				if (authorNameMatcher.find() && bookAuth.length() > 2 && bookAuth.length() < 50) {
					if (bookNumMatcher.find() && bookNum.length() > 0) {
						if (publisherNameMatcher.find() && pubName.length() > 2 && pubName.length() < 30) {
							return true;
						} else {
							try {
								throw new BookGenericException(
										"publisher Name must contain atleast 3 character and should not exceed 30 character  ");
							} catch (BookGenericException e) {
								System.err.println(e.getMessage());
								return false;
							}
						}

					} else {
						try {
							throw new BookGenericException("Book Number must be integer");
						} catch (BookGenericException e) {
							System.err.println(e.getMessage());
							return false;
						}
					}

				} else {
					try {
						throw new BookGenericException("Book Author Name is Invalid");
					} catch (BookGenericException e) {
						System.err.println(e.getMessage());
						return false;
					}
				}

			} else {
				try {
					throw new BookGenericException(
							"Book Name must contain atleast 3 character and should not exceed 30 character");
				} catch (BookGenericException e) {
					System.err.println(e.getMessage());
					return false;
				}

			}
		} else {
			try {
				throw new BookGenericException("Book Id should be Integer");
			} catch (BookGenericException e) {
				System.err.println(e.getMessage());
				return false;
			}
		}

	}

	public boolean userIdValidation(String userId) {
		Matcher userIdMathcher = validId.matcher(userId);
		if (userIdMathcher.find() && userId.length() > 0) {
			return true;
		} else {
			try {
				throw new BookGenericException("The Id should be greater than 0");
			} catch (BookGenericException e) {
				System.err.println(e.getMessage());
			}
		}
		return false;

	}

	public boolean userValidation(String usrId, String usrName, String usrEmail, String usrPassword) {
		Matcher userNameMatcher = validName.matcher(usrName);
		Matcher emailMatcher = validEmail.matcher(usrEmail);
		Matcher passwordMatcher = validPassword.matcher(usrPassword);
		Matcher userIdMathcher = validId.matcher(usrId);
		if (userIdMathcher.find() && usrId.length() > 0) {
			if (userNameMatcher.find() && usrName.length() > 2 && usrName.length() < 30) {
				if (emailMatcher.find() && usrEmail.length() > 5 && usrEmail.length() < 50) {
					if (passwordMatcher.find() && usrPassword.length() > 7 && usrPassword.length() < 12) {
						return true;
					} else {
						try {
							throw new UserGenericException(
									"Password that you've entered is incorrect,should contain atleast 8 characters including special characters");
						} catch (UserGenericException e) {
							System.err.println(e.getMessage());
						}
					}
				} else {
					try {
						throw new UserGenericException("please check entered email");
					} catch (UserGenericException e) {
						System.err.println(e.getMessage());
					}
				}

			} else {
				try {
					throw new UserGenericException("user name Should contain only Alphabets");
				} catch (UserGenericException e) {
					System.err.println(e.getMessage());
				}
			}

		} else {
			try {
				throw new UserGenericException("the id should be greater than 0");
			} catch (UserGenericException e) {
				System.err.println(e.getMessage());
			}
		}
		return false;

	}
}
