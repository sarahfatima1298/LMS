package org.Assignment.Main;

import org.Assignment.Book.BookInstance;
import org.Assignment.LibraryManagement.Library.Library;
import org.Assignment.LibraryManagement.LibraryInventory.LibraryInventory;
import org.Assignment.LibraryManagement.MultibranchLibrarySystem;
import org.Assignment.UserManagement.Accounts.Author;
import org.Assignment.UserManagement.Accounts.Librarian;
import org.Assignment.UserManagement.Accounts.Patron;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
	public static void main(String[] args) {
		// Create Librarians
		Librarian librarian1 = new Librarian("Alice Johnson", "librarian01", "alice.johnson@example.com", "LIB001");
		Librarian librarian2 = new Librarian("Jane Smith", "L101", "jane.smith@example.com", "LIB002");

		// Create Authors
		Author author1 = librarian1.addAuthor("George Orwell", "george.orwell@example.com", "British novelist");
		Author author2 = librarian2.addAuthor("J.K. Rowling", "jk.rowling@example.com", "British author");

		// Create Book Instances
		BookInstance book1 = new BookInstance("978-0451524935", "1984", author1, "B1", "1949");
		BookInstance book2 = new BookInstance("978-0747532743", "Harry Potter and the Philosopher's Stone", author2, "B2", "1997");

		// Create LibraryInventories
		List<BookInstance> bookList1 = new ArrayList<>();
		List<BookInstance> bookList2 = new ArrayList<>();
		LibraryInventory inventory1 = new LibraryInventory(bookList1);
		LibraryInventory inventory2 = new LibraryInventory(bookList2);

		// Add Books to inventory
		inventory1.addBook(book1);
		inventory2.addBook(book2);

		// Create Libraries
		Library library1 = new Library("L001", "Downtown Library", "Downtown", inventory1, librarian1);
		Library library2 = new Library("L002", "Uptown Library", "Uptown", inventory2, librarian2);

		// Create Multi-branch Library System
		MultibranchLibrarySystem multiBranchSystem = new MultibranchLibrarySystem();
		multiBranchSystem.addBranch(library1);
		multiBranchSystem.addBranch(library2);

		// Add new Patrons
		Patron patron1 = librarian1.addPatron("Bob Smith", "PAT001", "bob.smith@example.com");
		Patron patron2 = librarian2.addPatron("Alice Brown", "PAT002", "alice.brown@example.com");

		// Issue a book
		library1.issueBook(book1, patron1);

		// Return the book and print borrowed books
		library1.returnBook(book1, patron1);
		patron1.printBorrowedBooks();

		// Transfer a book between libraries
		System.out.println("\nTransferring book '1984' from Downtown Library to Uptown Library...");
		multiBranchSystem.transferBooks("L001", "L002", "B1");

		// Print book status in both libraries after transfer
		System.out.println("\nBooks in Downtown Library:");
		inventory1.printLibraryInventory();

		System.out.println("\nBooks in Uptown Library:");
		inventory2.printLibraryInventory();

		// Print all library branches
		System.out.println("\nAll Library Branches:");
		multiBranchSystem.printBranches();

		// Adding and updating patron information
		System.out.println("\nUpdating patron information...");
		library1.getLibrarian().updatePatron("alice.newemail@example.com", patron1);
		System.out.println("Patron Bob's updated email: " + patron1.getEmail());

		// Search for a book by title
		System.out.println("\nSearching for '1984':");
		List<BookInstance> foundBooksByTitle = library1.searchBook("1984");
		for (BookInstance foundBook : foundBooksByTitle) {
			foundBook.printBookInstance();
		}

		// Search for books by author
		System.out.println("\nSearching for books by J.K. Rowling:");
		List<BookInstance> foundBooksByAuthor = library2.searchBook(author2);
		for (BookInstance foundBook : foundBooksByAuthor) {
			foundBook.printBookInstance();
		}

		// Print final library inventory
		System.out.println("\nFinal inventory of Downtown Library:");
		inventory1.printLibraryInventory();

		System.out.println("\nFinal inventory of Uptown Library:");
		inventory2.printLibraryInventory();

		// Add a new patron and print information
		Patron patron3 = librarian1.addPatron("Charlie White", "PAT003", "charlie.white@example.com");
		System.out.println("\nAdded new patron: " + patron3.getName());

		// Update patron information
		System.out.println("\nUpdating patron information for: " + patron1.getName());
		patron1.setEmail("bob.newemail@example.com");
		librarian1.updatePatron("bob.newemail@example.com", patron1);
		System.out.println("Updated email for patron: " + patron1.getName() + " to " + patron1.getEmail());

		// Print borrowed books for all patrons
		System.out.println("\nBorrowed Books:");
		patron1.printBorrowedBooks();
		patron2.printBorrowedBooks();
		patron3.printBorrowedBooks();

		// Print borrowing history for all patrons
		System.out.println("\nBorrowing History:");
		patron1.printBorrowedBooksHistory();
		patron2.printBorrowedBooksHistory();
		patron3.printBorrowedBooksHistory();

		// Remove a branch and print the remaining branches
		System.out.println("\nRemoving Uptown Library branch...");
		multiBranchSystem.removeBranch("L002");
		multiBranchSystem.printBranches();
	}
}
