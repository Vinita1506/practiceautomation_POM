package com.assignment.pageobjectmodel.tests;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.assignment.pageobjectmodel.model.Register;
import com.assignment.pageobjectmodel.model.Signup;

public class SignupTest extends FunctionalTest {

	private static final Logger LOG = Logger.getLogger(SignupTest.class);
	static Properties properties;
	static {
		try {
			properties = new Properties();
			FileInputStream ip = new FileInputStream("src/main/resources/application.properties");
			properties.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void signup() {
		try {
			LOG.info("Creating account...");
			CreateAccTest.createAccount(properties.getProperty("create.account"));
			WEB_DRIVER.get(properties.getProperty("create.url"));
			Signup signup = new Signup(WEB_DRIVER);
			assertTrue(signup.isInitialized());
			buildSignupDetails(signup);
			validateRegistration(signup);
		} catch (NoSuchElementException noSuchElementException) {
			LOG.error("Exception occured. Please try with different email id.");
		}
	}

	private void buildSignupDetails(Signup signup) {
		WEB_DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		signup.enterName(properties.getProperty("signup.custFirstName"), properties.getProperty("signup.custLastName"));

		WEB_DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		signup.enterPwd(properties.getProperty("signup.password"));

		WEB_DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		signup.enterAddressDetails(properties.getProperty("address"), properties.getProperty("city"),
				properties.getProperty("state"), properties.getProperty("zipcode"),
				properties.getProperty("addressAlias"));

		WEB_DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		signup.enterAddress(properties.getProperty("signup.custFirstName"),
				properties.getProperty("signup.custLastName"), properties.getProperty("mobile.no"));
	}

	private void validateRegistration(Signup signup) {
		Register register = signup.submit();
		assertTrue(register.isInitalized());
	}

}
