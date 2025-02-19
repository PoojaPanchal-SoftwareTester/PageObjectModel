package MavenTestify.MavenTestify;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPage
{
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id=\"small-searchterms\"]")
	WebElement search_box;
	
	@FindBy(xpath = "//input[@value=\"Search\"]")
	WebElement search_button;
	
	
	
  public searchPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  
  public void searchProduct(String product)
  {
	  search_box.sendKeys(product);
	  search_button.submit();
  }
  
  
}
