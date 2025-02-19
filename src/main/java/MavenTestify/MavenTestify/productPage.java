package MavenTestify.MavenTestify;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productPage 
{
	WebDriver driver;
	
	@FindBy(xpath ="//div[@class='search-results']//div[@class='item-box']")
	WebElement product_list;
	
	@FindBy(xpath ="//input[@class='button-1 add-to-cart-button']")
	WebElement addcart_button;
	
	public productPage(WebDriver driver)
	{
		if(driver!=null)
		{
			System.out.println("driver is not blank");
			PageFactory.initElements(driver, this);
		}
		else
		{
			System.out.println("driver is  blank");
			
		}
		
	}
	
	public void selectProductAndAddToCart(String targetProduct)
	{
		
		boolean yes =product_list.isDisplayed();
		System.out.println("herer   "+yes);
		List<WebElement> product_lists =  product_list.findElements(By.xpath("//h2[@class='product-title']"));
		System.out.println("size of product "+product_lists.size());
		for (WebElement product : product_lists)
		{
			WebElement product_value= product.findElement(By.tagName("a"));
			//String target_product_title_value ="TBlue Jeans";
			if(product_value.getText().equalsIgnoreCase(targetProduct))
			{
				product_value.click();
				break;
			}
		}
		
		addcart_button.click();
	}
}
