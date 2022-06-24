package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	public WebDriver ldriver;

	public loginpage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	@CacheLookup
	WebElement txtemail;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement txtpwd;

	@FindBy(xpath = "//button[@class=\"button-1 login-button\"]")
	@CacheLookup
	WebElement btnlogin;

	@FindBy(xpath = "//a[@href='/logout']")
	@CacheLookup
	WebElement btnlogout;

	public void setusername(String uname) {
	
		txtpwd.clear();
		txtpwd.sendKeys(uname);
	}

	public void setpassword(String pwd) {
		txtpwd.clear();
		txtpwd.sendKeys(pwd);
	}

	public void clicklogin() {
		btnlogin.click();

	}

	public void logout() {
		btnlogout.click();
	}

}
