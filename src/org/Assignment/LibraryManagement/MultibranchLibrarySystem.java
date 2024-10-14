package org.Assignment.LibraryManagement;

import java.util.HashMap;
import java.util.Map;

import org.Assignment.LibraryManagement.Library.Library;

public class MultibranchLibrarySystem {
	Map<String, Library> branches;

	public MultibranchLibrarySystem() {
		this.branches = new HashMap<>();
	}

	public void addBranch(Library branch) {
		branches.put(branch.getLibraryId(), branch);
	}

	public Library getBranch(String branchId) {
		return branches.get(branchId);
	}

	public void removeBranch(String branchId) {
		branches.remove(branchId);
	}

	public void updateBranch(Library branch) {
		branches.put(branch.getLibraryId(), branch);
	}

	public void printBranches() {
		for (Map.Entry<String, Library> entry : branches.entrySet()) {
			System.out.println(entry.getValue().getLibraryName());
		}
	}

	public void transferBooks(String fromBranchId, String toBranchId, String bookId) {
		Library fromBranch = branches.get(fromBranchId);
		Library toBranch = branches.get(toBranchId);

		toBranch.getLibraryInventory().addBook(fromBranch.getLibraryInventory().getBookInstance(bookId));
		fromBranch.getLibraryInventory().removeBook(bookId);
	}
}
