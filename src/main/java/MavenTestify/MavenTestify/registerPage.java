package MavenTestify.MavenTestify;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseClass;

public class registerPage 
{
	WebDriver driver;
	
  @FindBy(xpath="//div[@class='inputs']//div[@class='gender']//label")
  WebElement gender_label;
  
  @FindBy(xpath ="//input[@id ='FirstName']")
  WebElement first_input;
  
  @FindBy(xpath = "//input[@id ='LastName']")
  WebElement last_input;
  
  @FindBy(xpath = "//input[@id ='Email']")
  WebElement email_input;
  
  @FindBy(xpath = "//input[@id ='Password']")
  WebElement password_input;
  
  @FindBy(xpath = "//input[@id ='ConfirmPassword']")
  WebElement confirm_password_input;
  
  @FindBy(xpath ="//input[@id ='register-button']")
  WebElement registered_button;
  
	public registerPage(WebDriver driver)
	{
		//super("Chrome");
		PageFactory.initElements(driver, this);
	}
	
	public void registerForm(String gender,String first_name,String last_name, String email,String password,String confirm_password)
	{
		
		if(gender_label.getText().equalsIgnoreCase(gender))
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(gender_label)).click();
		}

		first_input.sendKeys(first_name);
		last_input.sendKeys(last_name);
		email_input.sendKeys(email);
		password_input.sendKeys(password);
		confirm_password_input.sendKeys(confirm_password);
		
		registered_button.click();
		
		
	}

}
