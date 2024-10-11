package org.Assignment.BookManagementSystem;

import java.util.Date;

import org.Assignment.Book.BookInstance;
import org.Assignment.Book.BookStatus;
import org.Assignment.LibraryManagement.Library.Library;

public class BookIssueService {

	public static boolean issueBook(BookInstance book) {
		if (book.getBookStatus() == BookStatus.AVAILABLE) {
			book.setBookStatus(BookStatus.ISSUED);
			book.setBookIssuedDate(new Date());
			return true;
		}
		return false;
	}

	public static boolean renewBook(BookInstance book) {
		return issueBook(book);
	}

	public static void returnBook(BookInstance book) {
		book.setBookStatus(BookStatus.AVAILABLE);
		book.setBookIssuedDate(null);
	}

}
