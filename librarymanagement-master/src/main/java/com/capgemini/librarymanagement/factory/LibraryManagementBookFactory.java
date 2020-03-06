package com.capgemini.librarymanagement.factory;

import com.capgemini.librarymanagement.dao.AdminBookDao;
import com.capgemini.librarymanagement.dao.AdminBookDaoImpl;
import com.capgemini.librarymanagement.service.AdminBookService;
import com.capgemini.librarymanagement.service.AdminBookServiceImpl;

public class LibraryManagementBookFactory {
	public LibraryManagementBookFactory() {

	}

	public static AdminBookDao objLibraryDao() {
		AdminBookDao dao1 = new AdminBookDaoImpl();
		return dao1;

	}

	public static AdminBookService objLibraryService() {
		AdminBookService service = new AdminBookServiceImpl();
		return service;

	}

}
