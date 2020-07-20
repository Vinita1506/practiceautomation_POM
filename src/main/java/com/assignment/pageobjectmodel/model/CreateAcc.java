package com.assignment.pageobjectmodel.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAcc extends PageObject {

	@FindBy(xpath = "//*[@id='email_create']")
	private WebElement emailId;

	public CreateAcc(WebDriver driver) {
		super(driver);
	}

	public void setEmailId(String emailId) {
		this.emailId.clear();
		this.emailId.sendKeys(emailId);
	}

	public WebElement createacc() {
		return driver.findElement(By.name("SubmitCreate"));
	}

}
