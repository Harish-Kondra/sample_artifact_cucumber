package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import stepdefinitions.baseclass;
import utilities.Waithelper;

public class searchcustomer extends baseclass {

	public WebDriver ldriver;
	Waithelper waithelper;

	public searchcustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		waithelper = new Waithelper(rdriver);
	}

	@FindBy(how = How.ID, using = "SearchEmail")
	@CacheLookup
	WebElement txtemail;

	@FindBy(how = How.ID, using = "SearchFirstName")
	@CacheLookup
	WebElement fname;

	@FindBy(how = How.ID, using = "SearchLastName")
	@CacheLookup
	WebElement lname;

	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement btnsearch;

	@FindBy(how = How.XPATH, using = "//table[@role='grid']")
	@CacheLookup
	WebElement tblsearchresults;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
	WebElement table;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']/tbody/tr")
	List<WebElement> tablerows;

	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']/tbody/tr/td")
	List<WebElement> tablecolumns;

	public void setemail(String email) {
		waithelper.waitforelement(txtemail, 30);
		txtemail.clear();
		txtemail.sendKeys(email);
	}

	public void setfname(String name) {
		fname.clear();
		fname.sendKeys(name);
	}

	public void setlname(String name) {
	lname.clear();
	lname.sendKeys(name);
	}

	public void clickonsearch() {
		btnsearch.click();
		waithelper.waitforelement(btnsearch, 30);
	}

	public int getnoofrows() {
		return (tablerows.size());
	}

	public int getnoofcolumns() {
		return (tablecolumns.size());
	}

	public boolean searchcustomerbyemail(String email) {
		boolean flag = false;
		for (int i = 1; i <= getnoofrows(); i++) {
			String emailid = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
					.getText();
			System.out.println(emailid);
			if (emailid.equals(email)) {
				flag = true;
			}
		}
		return flag;

	}

	public boolean searchcustomerbyname(String email) {
		boolean flag = false;
		for (int i = 1; i <= getnoofrows(); i++) {
			String name = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]"))
					.getText();
			String names[] = name.split(" ");
			if (names[0].equals("Victoria") && names[1].equals("Terces")) {
				flag = true;
			}
		}
		return flag;

	}
}
