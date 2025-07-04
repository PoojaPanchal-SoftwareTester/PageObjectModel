package MavenTestify.MavenTestify;

import java.awt.print.PrinterException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkoutPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//div[@id='billing-buttons-container']//input[@class='button-1 new-address-next-step-button']")
	WebElement continue_button;
	
	@FindBy(xpath="//input[@id ='BillingNewAddress_Company']")
	WebElement company_input;
	
	@FindBy(xpath="//select[@id ='BillingNewAddress_CountryId']")
	WebElement country_dropdown;
	
	@FindBy(xpath="//input[@id ='BillingNewAddress_City']")
	WebElement city_input;
	
	@FindBy(xpath="//input[@id ='BillingNewAddress_Address1']")
	WebElement address1_input;
	
	@FindBy(xpath="//input[@id ='BillingNewAddress_ZipPostalCode']")
	WebElement zip_input;
	
	@FindBy(xpath="//input[@id ='BillingNewAddress_PhoneNumber']")
	WebElement phone_input;
	
	@FindBy(xpath="//input[@class ='button-1 new-address-next-step-button']")
	WebElement address_confirm_button;
	
	@FindBy(xpath="//div[@id ='billing-new-address-form']")
	WebElement new_billing_address;
	
	@FindBy(xpath="//div[@class ='section select-billing-address']")
	WebElement select_billing_address;
	
	@FindBy(xpath="//div[@id ='shipping-buttons-container']//input[@class='button-1 new-address-next-step-button']")
	WebElement shipping_address_continue_button;
	
	@FindBy(xpath="	//div[@id ='shipping-method-buttons-container']//input[@class='button-1 shipping-method-next-step-button']")
	WebElement shipping_method_continue_button;
	
	@FindBy(xpath="//div[@id ='payment-method-buttons-container']//input[@class='button-1 payment-method-next-step-button']")
	WebElement payment_method_continue_button;
	
	@FindBy(xpath="//div[@id ='payment-info-buttons-container']//input[@class='button-1 payment-info-next-step-button']")
	WebElement payment_info_continue_button;
	
	@FindBy(xpath="//div[@id ='confirm-order-buttons-container']//input[@class='button-1 confirm-order-next-step-button']")
	WebElement confirm_order_button;
	
	@FindBy(xpath="//input[@class='button-2 order-completed-continue-button']")
	WebElement order_confirm_button;
	
	
	
	
	public checkoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public  void confirmOrderProcess()
	{
	try {
		boolean newbillingdisplayValue  = new_billing_address.isDisplayed();//full form firstname and etc...
		//boolean selectbillingdisplayValue  = select_billing_address.isDisplayed();//already have address
		
		
		if (newbillingdisplayValue) 
		{
			 System.out.println("Element is hidden (display: none)");
			 Select dropdown = new Select(country_dropdown);
			  List<WebElement> option_list = dropdown.getOptions();
			  
			  for (WebElement option_value : option_list) 
			  {
				  if(option_value.getText().equalsIgnoreCase("India"))
				  {
					  option_value.click();
				  }
				//System.out.println("test "+option_value.getText());
			  }
				
			
			city_input.sendKeys("indore");
			address1_input.sendKeys("indore");
			zip_input.sendKeys("452012");
			phone_input.sendKeys("8959204209");
			continue_button.click();
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(address_confirm_button)).click();
			
			
		} 
		 else {
			 System.out.println("Element is visible dispaly");
			 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(address_confirm_button)).click();
				
				wait.until(ExpectedConditions.visibilityOf(shipping_address_continue_button)).click();
				//shipping_address_continue_button.click();
				
				wait.until(ExpectedConditions.visibilityOf(shipping_method_continue_button)).click();
				
				wait.until(ExpectedConditions.visibilityOf(payment_method_continue_button)).click();
				
				wait.until(ExpectedConditions.visibilityOf(payment_info_continue_button)).click();
				
				wait.until(ExpectedConditions.visibilityOf(confirm_order_button)).click();
				
				wait.until(ExpectedConditions.visibilityOf(order_confirm_button)).click();
 
			}		
			//address_confirm_button.click();  
	}
	catch (Exception e) {
		System.out.println("error"+e.getMessage());
	}
		
	
	}
}
