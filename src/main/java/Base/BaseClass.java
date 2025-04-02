package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	
	protected WebDriver driver;
	protected Properties locator;
	
	public BaseClass()
	{
		try {
			
	       
			// default browser is chrome 
			String browser = "Chrome"; 
			
			 System.out.println("Initializing browser: " + browser);  // Log when browser initialization starts
			 
			if(browser.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
			}
			else {
	            throw new IllegalArgumentException("Invalid browser name provided: " + browser);
	        }
			
			 System.out.println("Browser initialized: " + browser);  // Log when the browser is initialized
			
			 
			 //initialize Properties class
			  locator = new Properties();
	            try (FileInputStream file = new FileInputStream("src/main/java/Utility/config.properties")) 
	            {
	                //load file 
	            	locator.load(file);
	            }

	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	            driver.manage().window().maximize();

	        } 
		catch (IOException e) {
	            System.out.println("Error loading configuration: " + e.getMessage());
	        }
			
		 catch (Exception e) {
			System.out.println("Error on initalization of webdriver "+ e.getMessage());
		}
	}
	
	  @BeforeClass
	    public void setUp(ITestContext context) {
	       // driver.manage().window().maximize();
	        context.setAttribute("WebDriver", driver); // Store WebDriver in TestNG context
	    }
	
	// Method to open the URL
	public void openUrl(String url)
	{
		 driver.get(url);
	}
	
	// Excel Utility Method to get data from Excel
	  
	  public Object[][] getExcelData(String filePath, String sheetName) throws IOException {
		  // File path to the Excel file
		// String filePath ="C:\\Users\\pujap\\eclipse-workspace\\OptimTest\\src\\main\\java\\Resources\\TestData\\DataExcel.xlsx";
	  
	  // Initialize FileInputStream to read the Excel file 
		 FileInputStream fis =new FileInputStream(filePath);
	  
	  // Create a Workbook instance to access the Excel file
		  XSSFWorkbook workbook = new XSSFWorkbook(fis);
	  
	  // Access the first sheet 
		  XSSFSheet sheet = workbook.getSheet(sheetName);
	  
	  // Get the number of rows and columns
		  int rowCount =sheet.getPhysicalNumberOfRows();
		  int colCount =sheet.getRow(0).getPhysicalNumberOfCells();
	  
	  // Create a 2D array to store the data
		  Object[][] data = new Object[rowCount- 1][colCount]; // Exclude header row
	  
	  // Loop through rows and columns to fetch data
		  for (int i = 1; i < rowCount;  i++) {
			  // Start from row 1 to skip header
	  
	  XSSFRow row = sheet.getRow(i);
	  
	  for (int j = 0; j < colCount; j++) { //
	  //System.out.println(row.getCell(j).toString());
	  data[i - 1][j]=row.getCell(j).toString(); 
	  }
	  
	  }
	  
	  // Close the workbook and input stream
		  workbook.close(); 
		  fis.close();
	  
	  return data; 
	  }
	  
	  //screenshot
	  public void screenShots(String methodName)
	  {
		  
	  }

	//Quit the WebDriver when done
	public void quitDriver()
	{
		if(driver!=null)
		{
			driver.quit();
			driver = null;
		}
	}
	
	

}
