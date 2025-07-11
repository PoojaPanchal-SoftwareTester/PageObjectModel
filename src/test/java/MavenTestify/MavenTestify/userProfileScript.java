package MavenTestify.MavenTestify;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import Listeners.CustomTestListener;
@Listeners(CustomTestListener.class)
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
	
	@Test(priority= 1)
	
	public void updateCustomerBasicInfo()
	{
		//System.out.println("here .....");
		loginObj.login(locator.getProperty("email"), locator.getProperty("password"));
		obj.updateCustomerBasicInfo();
	
	}
	
	@Test(priority= 2)
	public void updateAddress()
	{
		String action = "add";//delete and add
		
		obj.updatedAddress(action);
	}
}
