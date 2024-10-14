package org.Assignment.UserManagement.Accounts;

import org.Assignment.Book.BookInstance;
import org.Assignment.BookManagementSystem.BookIssueService;
import org.Assignment.LibraryManagement.Library.Library;
import org.Assignment.LibraryManagement.LibraryInventory.LibraryInventory;
import org.Assignment.UserManagement.UserManager;

public class Librarian extends User implements UserManager {
	private String librarianId;

	public Librarian(String name, String userId, String email, String librarianId) {
		super(name, email);
		this.librarianId = librarianId;
	}

	public String getLibrarianId() {
		return librarianId;
	}

	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}

	// Librarian-specific methods (add/remove books, manage patrons, etc.)
	public void addBook(BookInstance book, Library library) {
		LibraryInventory libraryInventory = library.getLibraryInventory();
		libraryInventory.addBook(book);
	}

	public void removeBook(BookInstance book, Library library) {
		LibraryInventory libraryInventory = library.getLibraryInventory();
		libraryInventory.removeBook(book);
	}

	public boolean issueBook(BookInstance book, Patron patron) {
		if (BookIssueService.issueBook(book)) {
			patron.borrowBook(book);
			return true;
		}
		return false;
	}

	public void returnBook(BookInstance book, Patron patron) {
		BookIssueService.returnBook(book);
		patron.returnBook(book);
	}

	public Author addAuthor(String name, String email, String bio) {
		return (new Author(name, email, bio));
	}

	@Override
	public Patron addPatron(String name, String userId, String email) {
		return (new Patron(name, userId, email));
	}

	@Override
	public void updatePatron(String email, Patron patron) {
		patron.setEmail(email);
	}
}
