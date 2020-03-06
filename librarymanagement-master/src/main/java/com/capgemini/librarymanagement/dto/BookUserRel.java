package com.capgemini.librarymanagement.dto;

import java.util.Date;
import java.util.List;

public class BookUserRel {
	
	private List<UserBookDetail> book;
	
	private UserInfoBean userInfoBean;
 
	private Date returnDate ;
	

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public List<UserBookDetail> getBook() {
		return book;
	}

	public void setBook(List<UserBookDetail> book) {
		this.book = book;
	}

	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}
	

	
}
