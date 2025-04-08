package MavenTestify.MavenTestify;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import Listeners.CustomTestListener;

@Listeners(CustomTestListener.class)
public class loginPageScript extends BaseClass
{
	loginPage loginObj;
	public loginPageScript()
	{
		super();
		
	}
	
	@BeforeClass
	public void setUp()
	{
		//super.setUp(driver);
		openUrl("https://demowebshop.tricentis.com");
		loginObj = new loginPage(driver);
	}
	
	@Test(priority=1)
	public void testValidLogin()
	{
		loginObj.login(locator.getProperty("email"), locator.getProperty("password"));
		WebElement email_display = driver.findElement(By.xpath("//div[@class='header-links']//ul//li//a"));
		Assert.assertEquals(email_display.getText(),locator.getProperty("email"),"Unable to login with valid credentials" );
	}
	
	/*
	 * @Test(priority=2) public void testInvalidLogin() {
	 * loginObj.login(locator.getProperty("invalidEmail"),
	 * locator.getProperty("invalidPassword")); String message =
	 * loginObj.getErrorMessgae(); Assert.assertTrue(message.
	 * contains("Login was unsuccessful. Please correct the errors and try again."),
	 * "Error message is not displayed"); }
	 * 
	 * @Test(priority=1) public void testEmptyUsernameAndPassword() {
	 * loginObj.login("", ""); String message = loginObj.getErrorMessgae();
	 * Assert.assertTrue(message.
	 * contains("Login was unsuccessful. Please correct the errors and try again."),
	 * "Error is not dispalyed for empty credentails"); }
	 * 
	 * @Test(priority=3) public void testLoginWithRemenderMe() {
	 * loginObj.loginWithRemenderMe(locator.getProperty("email"),
	 * locator.getProperty("password")); WebElement email_display =
	 * driver.findElement(By.xpath("//div[@class='header-links']//ul//li//a"));
	 * Assert.assertEquals(email_display.getText(),locator.getProperty("email")
	 * ,"Unable to login with RemenderMe" ); }
	 */
}
