package com.dataprovider;

public class DataProvider {
	
	@org.testng.annotations.DataProvider
	public String[][] logindata(){
		String[][] data = {{"abc@gmail.com","abc@123"},{"def@gmail.com","def@123"},{"ghi@gmail.com","ghi@123"}};
		return data;
	}

}
