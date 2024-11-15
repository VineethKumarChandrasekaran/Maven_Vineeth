package com.testng;

import org.testng.annotations.Test;

public class GroupExecution02 {
	@Test(groups = {"functional","sanity"})
	public void facebook() {
		System.out.println("Facebook Application");
	}
    @Test(groups = "sanity")
	public void trello() {
		System.out.println("Trello Application");
	}
}
