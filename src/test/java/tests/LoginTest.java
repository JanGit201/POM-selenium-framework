package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void testValidLogin() {
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUsername("student");
		loginpage.enterPassword("Password123");
		loginpage.clickLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("practicetestautomation.com/logged-in-successfully/"));

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Logged In Successfully | Practice Test Automation");

		boolean isLogoutVisible = driver.findElement(By.linkText("Log out")).isDisplayed();
		Assert.assertTrue(isLogoutVisible, "Log out button should be visible");
	}
}