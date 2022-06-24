package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.baseclass;

public class addcustomer extends baseclass {
	public WebDriver ldriver;

	public addcustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

// find elements
	By customersmenu = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
	By customersmenu_item = By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	By addnew = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	By email = By.xpath("//*[@id=\"Email\"]");
	
	By customerroles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	
	
	By newsletter = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]");
	By vendor = By.xpath("	//*[@id=\"VendorId\"]/option[2]");
	By admincomments = By.xpath("//*[@id=\"AdminComment\"]");
	By password = By.xpath("//*[@id=\"Password\"]");
	By fname = By.xpath("//*[@id=\"FirstName\"]");
	By lname = By.xpath("//*[@id=\"LastName\"]");
	By mgender = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[5]/div[2]/div/div[1]/label");
	By fgender = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[5]/div[2]/div/div[2]/label");
	By companyname = By.xpath("//*[@id=\"Company\"]");
	By taxcheck = By.xpath("//*[@id=\"IsTaxExempt\"]");
	By dob = By.xpath("//*[@id=\"DateOfBirth\"]");
	By save = By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");
	By active = By.xpath("//*[@id=\"Active\"]");

	// actions methods
	
	public String getPageTitle() {
		return ldriver.getTitle();
		
	}
	public void customersmenu() {
		ldriver.findElement(customersmenu).click();
	}

	public void customersmenu_item() {
		ldriver.findElement(customersmenu_item).click();
	}

	public void addnew() {
		ldriver.findElement(addnew).click();
	}

	public void email(String Email) {
		ldriver.findElement(email).sendKeys(Email);
	}

	public void password(String pwd) {
		ldriver.findElement(password).sendKeys(pwd);
	}

	public void fname(String fn) {
		ldriver.findElement(fname).sendKeys(fn);
	}

	public void lname(String ln) {
		ldriver.findElement(lname).sendKeys(ln);
	}

	public void mgender(String gender) {
		if (gender.equals("male")) {
			ldriver.findElement(mgender).click();
		}
		else if(gender.equals("female")) {
			ldriver.findElement(fgender).click();
		}
		else  {
			ldriver.findElement(mgender).click(); // default
		}
		
	}

	public void dob(String date) {
		ldriver.findElement(dob).sendKeys(date);
	}

	public void companyname(String cname) {
		ldriver.findElement(companyname).sendKeys(cname);
	}

	public void taxcheck() {
		ldriver.findElement(taxcheck).click();
	}

	public void newsletter() {
		ldriver.findElement(newsletter).click();
	}

	public void customerroles() {
		ldriver.findElement(customerroles).click();
	}

	public void vendor() {
		ldriver.findElement(vendor).click();
	}

	public void active() {
		ldriver.findElement(active).click();
	}

	public void admincomments(String content) {
		ldriver.findElement(admincomments).sendKeys(content);
	}
	
	public void save() {
		ldriver.findElement(save).click();
	}

}
