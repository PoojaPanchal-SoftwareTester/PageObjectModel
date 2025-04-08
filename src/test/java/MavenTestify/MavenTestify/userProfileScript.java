package MavenTestify.MavenTestify;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseClass;

public class userProfileScript extends BaseClass
{
	
	userProfilePage obj;
	loginPage loginObj;
	public userProfileScript()
	{
		super();
	}
	
	@BeforeClass
	public void setUp()
	{
		//System.out.println("setup driver"+driver);
		openUrl("https://demowebshop.tricentis.com/login");
		loginObj = new loginPage(driver);
		obj = new userProfilePage(driver);
		
	}
	
	@Test
	
	public void updateCustomerBasicInfo()
	{
		//System.out.println("here .....");
		loginObj.login(locator.getProperty("email"), locator.getProperty("password"));
		obj.updateCustomerBasicInfo();
	
	}
}
