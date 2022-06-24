package stepdefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageobjects.addcustomer;
import pageobjects.loginpage;
import pageobjects.searchcustomer;

public class baseclass {

	public WebDriver driver;
	public loginpage lp;
	public addcustomer addcus;
	public searchcustomer searchcus;
	
	
	public static String randomstring() {
		String generatedstr1= RandomStringUtils.randomAlphabetic(5);
		return(generatedstr1);
	}
}
