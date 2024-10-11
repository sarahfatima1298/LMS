package org.Assignment.UserManagement;

import org.Assignment.UserManagement.Accounts.Patron;

public interface UserManager {

	// Add a new patron
	public Patron addPatron(String name, String userId, String email);

	// Update an existing patron
	public void updatePatron(String name, Patron patron);
}
