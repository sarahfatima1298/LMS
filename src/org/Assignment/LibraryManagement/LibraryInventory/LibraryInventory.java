package org.Assignment.LibraryManagement.LibraryInventory;

import java.util.ArrayList;
import java.util.List;

import org.Assignment.Book.BookInstance;
import org.Assignment.Book.BookStatus;
import org.Assignment.UserManagement.Accounts.Author;

public class LibraryInventory {
	List<BookInstance> bookList;

	public LibraryInventory(List<BookInstance> bookList) {
		this.bookList = bookList;
	}

	public List<BookInstance> getBookList() {
		return bookList;
	}

	public void setBookList(List<BookInstance> bookList) {
		this.bookList = bookList;
	}

	public void addBook(BookInstance bookInstance) {
		bookList.add(bookInstance);
		bookInstance.setBookStatus(BookStatus.AVAILABLE);
	}

	public void removeBook(BookInstance bookInstance) {
		bookList.remove(bookInstance);
	}

	public void removeBook(String bookId) {
		BookInstance bookInstance = getBookInstance(bookId);
		bookList.remove(bookInstance);
	}

	public void updateBookStatus(BookInstance bookInstance, BookStatus newStatus) {
		bookInstance.setBookStatus(newStatus);
	}

	public BookInstance getBookInstance(String bookId) {
		for(BookInstance bookInstance : bookList) {
			if(bookInstance.getBookId().equals(bookId)) {
				return bookInstance;
			}
		}
		return null;
	}

	public List<BookInstance> getBookInstances() {
		return bookList;
	}

	public List<BookInstance> searchBookInstances(String title) {
		List<BookInstance> searchResults = new ArrayList<BookInstance>();
		for(BookInstance bookInstance : bookList) {
			if(bookInstance.getTitle().equals(title)) {
				searchResults.add(bookInstance);
			}
		}
		return searchResults;
	}

	public List<BookInstance> searchBookInstances(Author author) {
		List<BookInstance> searchResults = new ArrayList<BookInstance>();
		for(BookInstance bookInstance : bookList) {
			if(bookInstance.getAuthor().equals(author)) {
				searchResults.add(bookInstance);
			}
		}
		return searchResults;
	}

	public void printLibraryInventory() {
		System.out.println("Library Inventory:");
		for(BookInstance bookInstance : bookList) {
			System.out.println("Book ID: " + bookInstance.getBookId() + ", Title: " + bookInstance.getTitle() + ", Author: " + bookInstance.getAuthor().getName() + ", Status: " + bookInstance.getBookStatus());
		}
	}
}
