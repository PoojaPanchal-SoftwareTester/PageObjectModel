package MavenTestify.MavenTestify;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Console;

import Base.BaseClass;
import Listeners.CustomTestListener;
@Listeners(CustomTestListener.class)
public class registerTest extends BaseClass
{
	
	public registerTest(String browser) {
		super();
		// TODO Auto-generated constructor stub
	}

	registerPage regObj;
	@BeforeClass
	
	  // Initialize the WebDriver from BaseClass
	public void setUp()
	{
		if(driver!=null)
		{
			regObj = new registerPage(driver);
		}
		else
		{
			System.out.println("webdriver initialization failed");
		}
		
		System.out.println("while register page open ");  // Log when browser initialization starts
		openUrl("https://demowebshop.tricentis.com/register");//called openurl method to open page
	}
	
	@Test
	public void registerFormTest()
	{
		
		try {
			
			// Get test data from Excel (example: ExcelData.xlsx, RegisterSheet)
			 Object[][] RegisterData =getExcelData("C:\\Users\\pujap\\eclipse-workspace\\MavenTestify\\src\\main\\java\\Utility\\ExcelData.xlsx","RegisterSheet");
			 
			 for (Object[] data : RegisterData) 
			 {
				 String gender = (String) data[0]; // First column is gender
		         String first_name = (String) data[1]; // Second column is first_name
		         String last_name = (String) data[2]; // third column is last_name
		         String email = (String) data[3]; // fourth column is email
		         String password = (String) data[4]; // five column is password
		         String confirm_password = (String) data[5]; // six column is confirm_password
		         
		         
		         regObj.registerForm(gender,first_name,last_name,email,password,confirm_password); //call registerForm method
		         
		        String currentUrl=  driver.getCurrentUrl();
		        String expectedUrl = "https://demowebshop.tricentis.com/registerresult/1";
		        //System.out.println("registered title"+currentUrl);
		         Assert.assertEquals(currentUrl, expectedUrl, "User already exist or due to some reason registration failed");
			 }
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
