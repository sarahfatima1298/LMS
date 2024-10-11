package org.Assignment.Main;

import org.Assignment.Book.Book;
import org.Assignment.Book.BookInstance;
import org.Assignment.LibraryManagement.Library.Library;
import org.Assignment.LibraryManagement.LibraryInventory.LibraryInventory;
import org.Assignment.UserManagement.Accounts.Author;
import org.Assignment.UserManagement.Accounts.Librarian;
import org.Assignment.UserManagement.Accounts.Patron;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		// Create Authors
		Author author1 = new Author("George Orwell", "george.orwell@example.com", "British novelist");
		Author author2 = new Author("J.K. Rowling", "jk.rowling@example.com", "British author");

		// Create Book Instances
		List<BookInstance> bookList = new ArrayList<>();
		BookInstance bookInstance1 = new BookInstance("978-0451524935", "1984", author1, "B1", "1949");
		BookInstance bookInstance2 = new BookInstance("978-0747532743", "Harry Potter and the Philosopher's Stone", author2, "B2", "1997");
		bookList.add(bookInstance1);
		bookList.add(bookInstance2);

		// Create Library Inventory
		LibraryInventory libraryInventory = new LibraryInventory(bookList);

		// Create Librarian
		Librarian librarian = new Librarian("Alice Johnson", "librarian01", "alice.johnson@example.com", "LIB001");

		// Create Library
		Library library = new Library("LIB001", "City Library", "123 Main St", libraryInventory, librarian);

		// Create Patrons
		Patron patron1 = new Patron("Bob Smith", "PAT001", "bob.smith@example.com");
		Patron patron2 = new Patron("Alice Brown", "PAT002", "alice.brown@example.com");

		// Print initial library inventory
		libraryInventory.printLibraryInventory();

		// Issue a book to a patron
		library.issueBook(bookInstance1, patron1);
		bookInstance1.printBookInstance();
		patron1.printBorrowedBooks();

		// Return the book
		library.returnBook(bookInstance1, patron1);
		patron1.printBorrowedBooks();

		// Issue another book to the same patron
		library.issueBook(bookInstance2, patron1);
		bookInstance2.printBookInstance();
		patron1.printBorrowedBooks();

		// Search for a book by title
		System.out.println("\nSearching for '1984':");
		List<BookInstance> foundBooksByTitle = library.searchBook("1984");
		for (BookInstance foundBook : foundBooksByTitle) {
			foundBook.printBookInstance();
		}

		// Search for books by author
		System.out.println("\nSearching for books by J.K. Rowling:");
		List<BookInstance> foundBooksByAuthor = library.searchBook(author2);
		for (BookInstance foundBook : foundBooksByAuthor) {
			foundBook.printBookInstance();
		}

		// Print final library inventory
		libraryInventory.printLibraryInventory();

		// Add a new patron
		Patron patron3 = librarian.addPatron("Charlie White", "PAT003", "charlie.white@example.com");
		System.out.println("\nAdded new patron: " + patron3.getName());

		// Update patron information
		System.out.println("\nUpdating patron information for: " + patron1.getName());
		patron1.setEmail("bob.newemail@example.com");
		librarian.updatePatron("bob.newemail@example.com", patron1);
		System.out.println("Updated email for patron: " + patron1.getName() + " to " + patron1.getEmail());

		// Print borrowed books
		System.out.println("\nBorrowed Books:");
		patron1.printBorrowedBooks();
		patron2.printBorrowedBooks();
		patron3.printBorrowedBooks();

		System.out.println("\nBorrowing History Books:");
		patron1.printBorrowedBooksHistory();
		patron2.printBorrowedBooksHistory();
		patron3.printBorrowedBooksHistory();
	}
}
