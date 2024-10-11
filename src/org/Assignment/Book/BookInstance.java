package org.Assignment.Book;

import java.util.Date;

import org.Assignment.UserManagement.Accounts.Author;

public class BookInstance extends Book{
	String bookId;
	String publicationYear;
	BookStatus status;
	Date bookIssuedDate;

	public BookInstance(String ISBN, String title, Author author, String bookId, String publicationYear) {
		super(ISBN, title, author);
		this.bookId = bookId;
		this.publicationYear = publicationYear;
		this.status = BookStatus.AVAILABLE;
		this.bookIssuedDate = null;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public BookStatus getBookStatus() {
		return status;
	}

	public void setBookStatus(BookStatus status) {
		this.status = status;
	}

	public Date getBookIssuedDate() {
		return bookIssuedDate;
	}

	public void setBookIssuedDate(Date bookIssuedDate) {
		this.bookIssuedDate = bookIssuedDate;
	}

	public void issueBook() {
		this.status = BookStatus.ISSUED;
	}

	public void returnBook() {
		this.status = BookStatus.AVAILABLE;
	}

	public void reserveBook() {
		this.status = BookStatus.RESERVED;
	}

	public void renewBook() {
		this.bookIssuedDate = new Date();
		this.status = BookStatus.ISSUED;
	}

	public void cancelReservation() {
		this.status = BookStatus.AVAILABLE;
	}

	public void updateIssuedDate(Date bookIssuedDate) {
		this.bookIssuedDate = bookIssuedDate;
	}

	public void loseBook() {
		this.status = BookStatus.LOST;
	}

	public void foundBook() {
		this.status = BookStatus.AVAILABLE;
	}

	public BookInstance getBookInstance() {
		return this;
	}

	public void printBookInstance() {
		System.out.println("Book ID: " + this.bookId);
		System.out.println("ISBN: " + this.getISBN());
		System.out.println("Title: " + this.getTitle());
		System.out.println("Author: " + this.getAuthor().getName());
		System.out.println("Publication Year: " + this.publicationYear);
		System.out.println("Status: " + this.status);
		System.out.println("Book Issued Date: " + this.bookIssuedDate);
	}
}
