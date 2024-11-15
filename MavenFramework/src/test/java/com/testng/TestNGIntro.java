package com.testng;

import org.testng.annotations.Test;

public class TestNGIntro {
@Test(priority = 2)
	public void home() {
		System.out.println("Home Page");
	}
@Test(priority = 4)
	public void logout() {
		System.out.println("Logout Page");
	}
@Test(priority = 3)
	public void profile() {
		System.out.println("Profile Page");
	}
@Test(priority = 1)
	public void login() {
		System.out.println("Login Page");
	}
}
