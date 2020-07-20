package com.assignment.pageobjectmodel.tests;

import org.testng.annotations.Test;

import com.assignment.pageobjectmodel.model.CreateAcc;

public class CreateAccTest extends FunctionalTest {

	@Test
	public void createAccTest() {
		createAccount("n12373464@gmail.com");
	}

	public static void createAccount(String emailId) {
		CreateAcc createAcc = new CreateAcc(WEB_DRIVER);
		createAcc.setEmailId(emailId);
		createAcc.createacc().click();
	}

}
