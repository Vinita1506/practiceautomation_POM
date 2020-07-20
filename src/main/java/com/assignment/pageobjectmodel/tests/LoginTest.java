package com.assignment.pageobjectmodel.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.assignment.pageobjectmodel.model.Login;

public class LoginTest extends FunctionalTest {
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
	private void login() {
		logIn();
	}

	public static void logIn() {
		Login login = new Login(WEB_DRIVER);
		login.clickOnLogIn();
		login.setEmail(properties.getProperty("create.account"));
		login.setPassword(properties.getProperty("signup.password"));
		login.setSubmit();
	}

}
