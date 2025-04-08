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
	
	@FindBy(xpath ="//div[@class='message-error']//div//span")
	WebElement error_messgae;
	
	@FindBy(xpath ="//input[@id='RememberMe']")
	WebElement rememberMe_checkbox;
	
	
	
	
	
  public loginPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
	  //System.out.println("driver...."+driver);
  }
  
  public void login(String email, String password)
  {
	 
	  login_page_link.click();
	  
	  enterUsername(email);
	  
	  enterPassword(password);
	  
	  login_button.submit();  
  }
  
  public void enterUsername(String username)
  {
	 
	  email_input.clear();
	  WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.visibilityOf(email_input)).sendKeys(username);
  }
  
  public void enterPassword(String Password)
  {
	  password_input.clear();
	  password_input.sendKeys(Password);
  }
  
  public String getErrorMessgae()
  {
	String msg =  error_messgae.getText();
	return msg;
  }
  
  public void loginWithRemenderMe(String email, String password)
  {
      login_page_link.click();
	  
	  enterUsername(email);
	  
	  enterPassword(password);
	  
	  
	  if(rememberMe_checkbox.isSelected()==false)
	  {
		  rememberMe_checkbox.click();
	  }
	  
	  login_button.submit();
  }
  
  
}
