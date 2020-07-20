package com.assignment.pageobjectmodel.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register extends PageObject {

	@FindBy(tagName = "h1")
	private WebElement header;

	public Register(WebDriver driver) {
		super(driver);
	}

	public String getConfirmationHeader() {
		return header.getText();
	}

	public boolean isInitalized() {
		return header.isDisplayed();
	}
}
