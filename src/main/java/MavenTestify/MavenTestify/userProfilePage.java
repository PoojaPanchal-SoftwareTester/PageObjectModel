package MavenTestify.MavenTestify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userProfilePage 
{
	//public WebDriver driver;
	
	@FindBy(xpath = "//div[@class='column my-account']/ul/li/a[@class='account']")
	WebElement my_account_link;
	
	public userProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void updateCustomerBasicInfo()
	{
		
		my_account_link.click();
	}

}
