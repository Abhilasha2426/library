package com.capgemini.librarymanagement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Scanner;

public class SampleDateClass {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date);
		LocalDate returnDate = date.now().plusDays(15);
		System.out.println(returnDate);
		
		Scanner sc = new Scanner(System.in);
		String returnBookDate = sc.next();
		
		String[] bookBook = returnBookDate.split("-");
		int[] dateRe = new int[3];
		for (int i = 0; i < bookBook.length; i++) {
			dateRe[i]=Integer.parseInt(bookBook[i]);
		}
		
		LocalDate reDate = LocalDate.of(dateRe[0],dateRe[1],dateRe[2]);
		
		System.out.println(reDate);
		
		Period p = Period.between(returnDate, reDate);
		System.out.println(p.getDays());
		if(p.getDays()>0) {
			int fine = p.getDays()*5;
			System.out.println("Fine is "+fine);
		}
		else {
			System.out.println("No Fine");
		}
		
		
	}
}
