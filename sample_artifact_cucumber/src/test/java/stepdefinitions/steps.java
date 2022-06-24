package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import junit.framework.Assert;
import pageobjects.addcustomer;
import pageobjects.loginpage;
import pageobjects.searchcustomer;

public class steps extends baseclass {

	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		lp = new loginpage(driver);

	}

	@When("User Opens URL {string}")
	public void user_Opens_URL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String Email, String password) throws InterruptedException {
		lp.setusername(Email);
		lp.setpassword(password);
		Thread.sleep(2000);
	}

	@When("Click on Login")
	public void click_on_Login() throws InterruptedException {
		lp.clicklogin();
		Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) throws InterruptedException {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
			Thread.sleep(3000);
		}
	}

	@When("User click on Log Out Link")
	public void user_click_on_Log_Out_Link() throws InterruptedException {
		lp.logout();
		Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() throws InterruptedException {

		driver.close();
	}

//add customers step definitions

	@Then("user can view dashboard")
	public void user_can_view_dashboard() throws InterruptedException {
		addcus = new addcustomer(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcus.getPageTitle());
	}

	@When("User click on customer menu")
	public void user_click_on_customer_menu() {
		addcus.customersmenu();
	}

	@When("User click on customer menuitem")
	public void user_click_on_customer_menuitem() {
		addcus.customersmenu_item();
	}

	@When("User click on add button")
	public void user_click_on_add_button() {
		addcus.addnew();
	}

	@Then("user can view add customer page")
	public void user_can_view_add_customer_page() {

		Assert.assertEquals("Add a new customer / nopCommerce administration", addcus.getPageTitle());
	}

	@When("user enters customer info")
	public void user_enters_customer_info() {
		String email = randomstring() + "@gmail.com";
		addcus.email(email);
		addcus.password("test123");

		// addcus.customerroles();
		addcus.vendor();
		addcus.mgender(email);
		addcus.fname("bkjbjlve");
		addcus.lname("bkjbjlve");
		addcus.dob("09/10/20");
		addcus.companyname("bkjbjlve");
		addcus.admincomments(email);
	}

	@When("Click on save")
	public void click_on_save() {
		addcus.save();

	}

	@Then("user can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully"));
	}

	// Step Definitions for Search customer

	@When("Enter customer email")
	public void enter_customer_email() {
		searchcus = new searchcustomer(driver);
		searchcus.setemail("victoria_victoria@nopCommerce.com");
	}

	@Then("User click on search button")
	public void user_click_on_search_button() throws InterruptedException {
		searchcus.clickonsearch();
		Thread.sleep(2000);
	}

	@When("User find email in search table")
	public void user_find_email_in_search_table() {
		boolean status = searchcus.searchcustomerbyemail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

	// using name

	@When("Enter customer firstname")
	public void enter_customer_firstname() {
		searchcus = new searchcustomer(driver);
		searchcus.setfname("Victoria");
	}

	@When("Enter customer lastname")
	public void enter_customer_lastname() {
		searchcus.setlname("Terces");
	}

	@When("User find name in search table")
	public void user_find_name_in_search_table() {
		boolean status = searchcus.searchcustomerbyname("victoria Terces");
		Assert.assertEquals(true, status);
	}

}
