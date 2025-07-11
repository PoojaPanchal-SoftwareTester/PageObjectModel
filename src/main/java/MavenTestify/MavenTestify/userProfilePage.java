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
	
	@FindBy(xpath = "//div[@class='column my-account']//ul//li//a[contains(text(),\"Addresses\")]")
	WebElement address_list;
	
	@FindBy(xpath = "//input[@class=\"button-2 edit-address-button\"]")
	WebElement address_edit_btn;
	
	@FindBy(xpath = "//input[@class=\"button-2 delete-address-button\"]")
	WebElement address_delete_btn;
	
	@FindBy(xpath = "//input[@class=\"button-1 add-address-button\"]")
	WebElement add_new_address_btn;
	
	@FindBy(xpath = "//input[@id='Address_FirstName']")
	WebElement address_firstName;
	
	@FindBy(xpath = "//input[@id='Address_LastName']")
	WebElement address_lastName;
	
	@FindBy(xpath = "//input[@id='Address_Email']")
	WebElement address_email;
	
	@FindBy(xpath = "//input[@id='Address_City']")
	WebElement address_city;
	
	@FindBy(xpath = "//input[@id='Address_Address1']")
	WebElement address_address1;
	
	@FindBy(xpath = "//input[@id='Address_ZipPostalCode']")
	WebElement address_zipPostalCode;
	
	@FindBy(xpath = "//input[@id='Address_PhoneNumber']")
	WebElement address_phonenumber;
	
	@FindBy(xpath = "//select[@id='Address_CountryId']")
	WebElement address_countryId;
	
	@FindBy(xpath = "//input[@class='button-1 save-address-button']")
	WebElement save_address_button;
	
	
	public userProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void updateCustomerBasicInfo()
	{
		
		my_account_link.click();
	}
	
	public void updatedAddress(String action)
	{
		address_list.click();
		
		if(action.equalsIgnoreCase("edit"))
		{
			address_edit_btn.click();
			
			
		}
		else if(action.equalsIgnoreCase("delete"))
		{
			address_delete_btn.click();
		}
		else
		{
			add_new_address_btn.click();
		}
	}

}
