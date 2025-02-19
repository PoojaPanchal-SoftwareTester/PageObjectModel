package MavenTestify.MavenTestify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cartPage
{
	WebDriver driver;
	@FindBy(xpath ="//div[@class='header-links']//ul//li[@id='topcartlink']")
	WebElement cart_page_link;
	
	@FindBy(xpath ="//input[@id='termsofservice']")
	WebElement terms_accept_checkbox;
	
	@FindBy(xpath ="//button[@id='checkout']")
	WebElement checkout_button;
	
	
	
   public cartPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void goToCart() 
   {
	   cart_page_link.click();
   }
   
   public void checkOut()
   {
	   terms_accept_checkbox.click();
	   checkout_button.click();
	   
   }
}
