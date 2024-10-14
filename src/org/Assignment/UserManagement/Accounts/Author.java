package org.Assignment.UserManagement.Accounts;

public class Author extends User {
	private String bio;

	Author(String name, String email, String bio) {
		super(name, email);
		this.bio = bio;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}
}
