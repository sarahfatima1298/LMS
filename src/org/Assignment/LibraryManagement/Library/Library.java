package org.Assignment.LibraryManagement.Library;

import java.util.List;

import org.Assignment.Book.BookInstance;
import org.Assignment.LibraryManagement.LibraryInventory.LibraryInventory;
import org.Assignment.UserManagement.Accounts.Author;
import org.Assignment.UserManagement.Accounts.Librarian;
import org.Assignment.UserManagement.Accounts.Patron;

public class Library {
	String libraryId;
	String libraryName;
	String libraryLocation;
	LibraryInventory libraryInventory;
	Librarian librarian;

	public Library(String libraryId, String libraryName, String libraryLocation, LibraryInventory libraryInventory, Librarian librarian) {
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.libraryLocation = libraryLocation;
		this.libraryInventory = libraryInventory;
		this.librarian = librarian;
	}

	public Librarian getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Librarian librarian) {
		this.librarian = librarian;
	}

	public String getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(String libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryLocation() {
		return libraryLocation;
	}

	public void setLibraryLocation(String libraryLocation) {
		this.libraryLocation = libraryLocation;
	}

	public LibraryInventory getLibraryInventory() {
		return libraryInventory;
	}

	public void setLibraryInventory(LibraryInventory libraryInventory) {
		this.libraryInventory = libraryInventory;
	}

	public void issueBook(BookInstance book, Patron patron) {
		if (this.librarian.issueBook(book, patron)) {
			System.out.println("Book issued successfully: Book: " + book.getTitle() + " to User: " + patron.getName());
			return;
		}
		System.out.println("Error while issuing the book");
	}

	public void renewBook(BookInstance book, Patron patron) {
		this.issueBook(book, patron);
	}

	public void returnBook(BookInstance book, Patron patron) {
		this.librarian.returnBook(book, patron);
		System.out.println("Book returned successfully: Book: " + book.getTitle() + " by User: " + patron.getName());
	}

	public List<BookInstance> searchBook(String title) {
		return this.libraryInventory.searchBookInstances(title);
	}

	public List<BookInstance> searchBook (Author author) {
		return this.libraryInventory.searchBookInstances(author);
	}

	public Patron addPatron(String name, String memberId, String email) {
		return this.librarian.addPatron(name, memberId, email);
	}

	public void updatePatron(String email, Patron patron) {
		this.librarian.updatePatron(email, patron);
		System.out.println("Patron updated successfully: " + patron.getName());
	}
}
