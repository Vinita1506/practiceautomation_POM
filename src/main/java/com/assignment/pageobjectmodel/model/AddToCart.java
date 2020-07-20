package com.assignment.pageobjectmodel.model;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends PageObject {

	public AddToCart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//women section
	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	private WebElement womenSecElement;

	@FindBy(xpath = "//*[@id=\"subcategories\"]/ul/li[2]/div[1]/a")
	private WebElement dressesSecElement;

	@FindBy(xpath = "//*[@id=\"subcategories\"]/ul/li[3]/div[1]/a")
	private WebElement summerDressesElement;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]")
	private WebElement dressElement1;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]")
	private WebElement addToCartElement;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]")
	private WebElement dressElement2;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[1]")
	private WebElement center_column2;
//
	@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	private WebElement cartElement;

	@FindBy(xpath = "//*[@id=\"order_step\"]/li[1]")
	private WebElement cartSummary;

	@FindBy(xpath = "//*[@id=\"cart_summary\"]")
	private WebElement cartElementsTable;

	@FindBy(id = "total_price_container")
	private WebElement totalPriceElement;

	@FindBy(xpath = "//*[@id=\"product_5_19_0_348700\"]/td[6]")
	private WebElement totalPrice;

	//// checkout
	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
	private WebElement element1;

	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
	private WebElement element2;

	@FindBy(id = "cgv")
	private WebElement element3;

	@FindBy(xpath = "//*[@id=\"form\"]/p/button")
	private WebElement element4;

	@FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")
	private WebElement element5;

	@FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
	private WebElement element6;

	@FindBy(xpath = "//*[@id=\"center_column\"]/p/a")
	private WebElement element7;

	@FindBy(xpath = "//*[@id=\"order-list\"]")
	private List<WebElement> orderList;

	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
	private WebElement afterTotalMatched;

	public void clickOnAfterTotalMatched() {
		afterTotalMatched.click();
	}

	public void clickOnWomenSec() {
		womenSecElement.click();
	}

	public void clickOnDress() {
		dressesSecElement.click();
	}

	public void clickOnSummerDress() {
		summerDressesElement.click();
	}

	public void dressElement1() {
		Actions actions = new Actions(driver);
		actions.moveToElement(dressElement1).perform();

	}

	public void dressElement2() {
		Actions actions = new Actions(driver);
		actions.moveToElement(dressElement2).perform();

	}

	public void clickOnCenterColumn2() {
		center_column2.click();
	}

	public void clickOnCenterColumn1() {
		addToCartElement.click();
	}

	public void clickOnCartElement() {
		cartElement.click();
	}

	public void clickOnCartSummary() {
		cartSummary.click();
	}

	public List<WebElement> getProducts() {
		return cartElementsTable.findElements(By.xpath("//*[@id=\"cart_summary\"]/tbody"));
	}

	public Double getTotalPrice() {
		return Double.valueOf(totalPriceElement.getText().substring(1));

	}

	public Double getSum(List<WebElement> products) {
		Double sum = 0.0;
		for (WebElement product : products) {
			WebElement totalPrice = product.findElement(By.xpath("//*[@id=\"product_5_19_0_348700\"]/td[6]"));
			sum += Double.valueOf(totalPrice.getText().substring(1));
		}
		return sum;
	}

	public void clickOnElement1() {
		element1.click();
	}

	public void clickOnElement2() {
		element2.click();
	}

	public void clickOnElement3() {
		element3.click();
	}

	public void clickOnElement4() {
		element4.click();
	}

	public void clickOnElement5() {
		element5.click();
	}

	public void clickOnElement6() {
		element6.click();
	}

	public void clickOnElement7() {
		element7.click();
	}

	public WebElement getOrderHistory() {
		if (!orderList.isEmpty()) {
			return orderList.get(0);
		}
		return null;
	}

	public void buyTheCartItems(WebElement element) {
		element.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr/td[1]")).click();
	}

}
