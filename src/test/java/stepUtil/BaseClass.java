package stepUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseClass {
	
	private static final Logger logger = Logger.getLogger(BaseClass.class);
	
	public WebDriver driver;
	public Properties prop;
	
	String path = System.getProperty("user.dir")+"\\src\\test\\resources\\deltax.properties";
	
	@BeforeTest	
	public void openBrower() throws FileNotFoundException {
		
		prop = new Properties();
		logger.info("Getting properties file");
		  FileInputStream objFile = new FileInputStream(path);
		  
		  try {			  
			  prop.load(objFile);
			  } catch (IOException e) {
			  System.out.println(e.getMessage());
			  e.printStackTrace();
			  }
		  
		  // Create a new instance of the browser
		  logger.info("Launch Chrome driver");
	      System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	      ChromeOptions options = new ChromeOptions();
		  options.addArguments("--test-type");
		  options.addArguments("--no-sandbox");
	      driver = new ChromeDriver(options);
	      	 
	      // Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
	      logger.info("Using implicitywait");
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      // Delete all cookies
	      driver.manage().deleteAllCookies();
		  logger.info("*********************Automation Testsuite Runner Log Info **********************************");
		  logger.info("New Browser Invoked");
		  
		  // Maximize the browser
	      logger.info("Maximize the browser");
	      driver.manage().window().maximize();
	 
	      // Launch the Registration site
	      logger.info("Launching Registration site");
	      driver.get(prop.getProperty("URL"));	
		
	}

	@AfterTest	
	public void closeBrowser() {
	
	   // Close the driver
	  logger.info("Quite from Chrome browser");
	  driver.quit();
	}

}
