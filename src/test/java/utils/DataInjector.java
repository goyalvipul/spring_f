package utils;


import org.testng.annotations.DataProvider;

public class DataInjector {
	
	@DataProvider(name = "emailInvalidValues")
	public static Object[][] getEmailInvalidValues() {
		return new Object[][] {
			{"invalidtestemail"},
			{"testemail@"},
			{"testemail@sdj%^&**@gmail.com"}
		};
	}
	
	
	@DataProvider(name = "emailValidValues")
	public static Object[][] getFormValidValues() {
		return new Object[][] {
			{"FirstName_one", "LastName_one", "validtestemail@gmail.com", "CommentsAutomation"},
			{"FirstName_two", "LastName_two", "testemail_underscore@gmail.com", "CommentsAutomation"},
		};
	}
	
}