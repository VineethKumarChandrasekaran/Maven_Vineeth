package com.testng;

import org.testng.annotations.Test;

public class GroupExecution01 {
	@Test(groups = "functional")
	public void home() {
		System.out.println("Home Page");
	}
@Test(groups = "smoke")
	public void logout() {
		System.out.println("Logout Page");
	}
@Test(groups = "sanity")
	public void profile() {
		System.out.println("Profile Page");
	}
@Test(groups = "smoke")
	public void login() {
		System.out.println("Login Page");
	}
}
