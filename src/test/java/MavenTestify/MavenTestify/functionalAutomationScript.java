package MavenTestify.MavenTestify;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import Listeners.CustomTestListener;
@Listeners(CustomTestListener.class)
public class functionalAutomationScript extends BaseClass
{
	loginPage loginObj;
	searchPage searchObj;
	productPage productObj;
	cartPage cartObj;
	checkoutPage checkoutObj;
	
	
    public functionalAutomationScript()
    {
    	super();
    }
    
    @BeforeClass
    public void setUp()
    {
    	openUrl("https://demowebshop.tricentis.com/");
    	loginObj = new loginPage(driver);
    	searchObj = new searchPage(driver);
    	productObj = new productPage(driver);
    	cartObj = new cartPage(driver);
    	checkoutObj = new checkoutPage(driver);
    }
    
    @Test
    public void runTest()
    {
    	loginObj.login(locator.getProperty("email"),locator.getProperty("password"));
    	String current_title = driver.getTitle();
    	String target_title= "Demo Web Shop";
    	
    	Assert.assertEquals(target_title, current_title, "login Failed");
    	
    	//calling searchProduct method and s parameter we call getProperty of properties file 
    	searchObj.searchProduct(locator.getProperty("product"));
    	
    	//calling select product and add to cart product
    	productObj.selectProductAndAddToCart(locator.getProperty("selectedproduct"));
    	
    	//going to cart page
    	cartObj.goToCart();
    	
    	cartObj.checkOut();
    	
    	//complete order process
    	checkoutObj.confirmOrderProcess();
    }
}
