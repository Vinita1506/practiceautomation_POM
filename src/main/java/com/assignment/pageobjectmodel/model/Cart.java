package com.assignment.pageobjectmodel.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends PageObject {

	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	private WebElement cart;

	public Cart(WebDriver driver) {
		super(driver);
	}
}
