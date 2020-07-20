package com.assignment.pageobjectmodel.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObject {
	public Login(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	private WebElement logInPage;

	@FindBy(xpath = "//*[@id=\"email\"]")
	private WebElement email;

	@FindBy(xpath = "//*[@id=\"passwd\"]")
	private WebElement password;

	@FindBy(xpath = "//*[@id=\"SubmitLogin\"]")
	private WebElement submit;

	public void clickOnLogIn() {
		logInPage.click();
	}

	public void setEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}

	public void setPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void setSubmit() {
		this.submit.click();
	}

}
