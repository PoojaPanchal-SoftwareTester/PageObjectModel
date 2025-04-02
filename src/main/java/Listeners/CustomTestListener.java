package Listeners;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Base.BaseClass;


public class CustomTestListener  implements ITestListener  
{
	public WebDriver driver;

  

	 @Override
	    public void onTestStart(ITestResult result) {
		   ITestContext context = result.getTestContext();
	        driver = (WebDriver) context.getAttribute("WebDriver");
		
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        // This method will be invoked if the test is successful
	    	System.out.println("success");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        // This method will be invoked if the test fails
	    	//ExtentReport.test.fail(result.getThrowable());
	    	takeScreenshot(result.getName());
	    	System.out.println("Failed in this "+result.getName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        // This method will be invoked if the test is skipped
	    	//ExtentReport.test.skip("Test Skipped");
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // Not commonly used, this is invoked when a test fails but within the success percentage
	    }

	    @Override
	    public void onStart(ITestContext result) {
	        // This method will be invoked before any test starts
	    	
	    }

	    @Override
	    public void onFinish(ITestContext result) {
	        // This method will be invoked after all tests finish
	    	
	    }
	    private void takeScreenshot(String testName) {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);

	        // Define the destination file path
	        File destination = new File("C:\\Users\\pujap\\eclipse-workspace\\MavenTestify\\src\\main\\java\\ScreenShots\\" + testName + ".png");

	        try {
	            // Copy the screenshot to the destination folder
	        	 //File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	     FileUtils.copyFile(source , destination);
	            //FileHandler.copy(source, destination);
	            System.out.println("Screenshot taken: " + testName + ".png");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }   
	    
}
