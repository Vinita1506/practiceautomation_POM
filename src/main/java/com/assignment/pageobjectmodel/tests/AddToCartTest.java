package com.assignment.pageobjectmodel.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.assignment.pageobjectmodel.model.AddToCart;

public class AddToCartTest extends FunctionalTest {

	private static final Logger LOG = Logger.getLogger(AddToCartTest.class);

	@Test
	public void addToCartDresses() {
		LoginTest.logIn();
		AddToCart addToCart = new AddToCart(WEB_DRIVER);
		addToCart(addToCart);

		addToCart.clickOnCartElement();
		addToCart.clickOnCartSummary();

		WebElement cartElementsTable = WEB_DRIVER.findElement(By.xpath("//*[@id=\"cart_summary\"]"));
		List<WebElement> products = cartElementsTable.findElements(By.xpath("//*[@id=\"cart_summary\"]/tbody"));
		

		WebElement totalPriceElement = WEB_DRIVER.findElement(By.id("total_price_container"));
		Double finalTotal = Double.valueOf(totalPriceElement.getText().substring(1));

		Double sum = 0.0;
		for (WebElement product : products) {
			WebElement totalPrice = product.findElement(By.xpath("//*[@id=\"product_5_19_0_349072\"]/td[6]"));
			
			
			sum += Double.valueOf(totalPrice.getText().substring(1));
		}

		if (finalTotal.equals(sum)) {
			LOG.info("Total matched...");
			addToCart.clickOnAfterTotalMatched();
		}

		addToCart.clickOnElement1();
		addToCart.clickOnElement2();
		addToCart.clickOnElement3();
		addToCart.clickOnElement4();
		addToCart.clickOnElement5();
		addToCart.clickOnElement6();
		addToCart.clickOnElement7();
		WebElement orderHistoryElement = addToCart.getOrderHistory();
		addToCart.buyTheCartItems(orderHistoryElement);

	}

	private void addToCart(AddToCart addToCart) {
		addToCart.clickOnWomenSec();
		addToCart.clickOnDress();
		addToCart.clickOnSummerDress();
		addToCart.dressElement1();
		addToCart.clickOnCenterColumn1();
		addToCart.dressElement2();
		addToCart.clickOnCenterColumn2();
	}
}
