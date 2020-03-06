package com.capgemini.librarymanagement.dto;

import java.util.Date;

public class UserBookDetail {
	
	private String userId;
	private String bookId;
	private Date issueDate;
	private Date returnDate;
	private double fine;
	private boolean isBorrowed;
	private int count;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String string) {
		this.userId = string;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String string) {
		this.bookId = string;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	

}
