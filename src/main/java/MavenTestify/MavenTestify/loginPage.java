package MavenTestify.MavenTestify;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage 
{
	WebDriver driver;
	
	@FindBy(xpath ="//div[@class='header-links']//ul//li//a[@class='ico-login']")
	WebElement login_page_link;
	
	@FindBy(xpath ="//input[@id=\"Email\"]")
	WebElement email_input;
	
	@FindBy(xpath ="//input[@id=\"Password\"]")
	WebElement password_input;
	
	@FindBy(xpath ="//input[@value=\"Log in\"]")
	WebElement login_button;
	
	
	
  public loginPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  
  public void login(String email, String password)
  {
	  login_page_link.click();
	  
	  WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(email_input)).sendKeys(email);
	  
	  password_input.sendKeys(password);
	  
	  login_button.submit();  
  }
}
