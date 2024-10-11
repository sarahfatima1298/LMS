package org.Assignment.Book;

import org.Assignment.UserManagement.Accounts.Author;

public class Book {
	String ISBN;
	String title;
	Author author;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book(String ISBN, String title, Author author) {
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
	}
}
