package com.assignment.pageobjectmodel.model;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Signup extends PageObject {

	private static final Logger LOG = Logger.getLogger(Signup.class);

	@FindBy(xpath = "//input[@id='customer_firstname']")
	private WebElement custFirstName;

	@FindBy(id = "customer_lastname")
	private WebElement customerLastName;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "firstname")
	private WebElement firstname;

	@FindBy(id = "lastname")
	private WebElement lastname;

	@FindBy(id = "company")
	private WebElement company;

	@FindBy(id = "address1")
	private WebElement address1;

	@FindBy(id = "address2")
	private WebElement address2;

	@FindBy(id = "city")
	private WebElement city;

	@FindBy(xpath = "//*[@id=\'id_state\']")
	private WebElement state;

	@FindBy(id = "postcode")
	private WebElement zipcode;

	@FindBy(id = "other")
	private WebElement additionalInfo;

	@FindBy(id = "phone_mobile")
	private WebElement mobile;

	@FindBy(id = "alias")
	private WebElement addressAlias;

	@FindBy(id = "submitAccount")
	private WebElement register;

	public Signup(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return firstname.isDisplayed();
	}

	public CreateAcc submit1() {
		register.click();
		return new CreateAcc(driver);
	}

	public void selectDropdown(WebElement state) {
		Select select = new Select(state);
		select.selectByVisibleText("Alabama");
	}

	public void enterName(String firstname, String lastname) {

		this.custFirstName.clear();
		this.custFirstName.sendKeys(firstname);

		this.customerLastName.clear();
		this.customerLastName.sendKeys(lastname);

	}

	public void enterPwd(String pswd) {
		this.password.clear();
		this.password.sendKeys(pswd);
	}

	public void enterAddress(String firstname, String lastname, String phn) {
		this.firstname.clear();
		this.firstname.sendKeys(firstname);

		this.lastname.clear();
		this.lastname.sendKeys(lastname);

		this.mobile.clear();
		this.mobile.sendKeys(phn);

	}

	public void enterAddressDetails(String address, String city, String state, String zipcode, String addressAlias) {

		this.address1.clear();
		this.address1.sendKeys(address);

		this.city.clear();
		this.city.sendKeys(city);

		this.state.sendKeys(state);

		this.zipcode.clear();
		this.zipcode.sendKeys(zipcode);

		this.addressAlias.clear();
		this.addressAlias.sendKeys(addressAlias);

	}

	public Register submit() {
		register.click();
		return new Register(driver);
	}

}
