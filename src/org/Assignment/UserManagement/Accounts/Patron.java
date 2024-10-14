package org.Assignment.UserManagement.Accounts;

import java.util.ArrayList;
import java.util.List;

import org.Assignment.Book.Book;
import org.Assignment.Book.BookInstance;

public class Patron extends User {
	private String patronId;
	private List<Book> borrowedBooks = new ArrayList<>();
	private List<Book> borrowingHistory = new ArrayList<>();

	Patron(String name, String memberId, String email) {
		super(name, email);
		this.patronId = memberId;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public List<Book> getBorrowingHistory() {
		return borrowingHistory;
	}

	public void setBorrowingHistory(List<Book> borrowingHistory) {
		this.borrowingHistory = borrowingHistory;
	}

	// Methods to manage borrowed books
	public void borrowBook(Book book) {
		borrowedBooks.add(book);
		borrowingHistory.add(book);
	}

	public void returnBook(BookInstance book) {
		borrowedBooks.remove(book);
	}

	public String getPatronId() {
		return patronId;
	}

	public void setPatronId(String patronId) {
		this.patronId = patronId;
	}

	public void updatePatron(Patron patron, String email) {
		patron.setEmail(email);
	}

	public void printBorrowedBooks() {
		System.out.println("Borrowed Books by user " + getName() + ":");
		for(Book book : borrowedBooks) {
			System.out.println(book.getTitle());
		}
	}

	public void printBorrowedBooksHistory() {
		System.out.println("Borrowing history of Books by user " + getName() + ":");
		for(Book book : borrowingHistory) {
			System.out.println(book.getTitle());
		}
	}
}
