package stepUtil;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import helpers.Constents;
import helpers.UtilityHelper;

public class DeltaxTest extends BaseClass{
	
private static final Logger logger = Logger.getLogger(DeltaxTest.class);
	
	SoftAssert sa = new SoftAssert();
	@Test	
	public void Test() throws FileNotFoundException {
		
		String a = UtilityHelper.email();
		String b = UtilityHelper.uName();
		
		logger.info("Test Execution is started.");
		
		// Enter first name
		WebElement fName1 = driver.findElement(By.name(Constents.fName));
		fName1.sendKeys(prop.getProperty("FirstName"));
		
		// Enter last name
		WebElement lName1 = driver.findElement(By.name(Constents.lName));
		lName1.sendKeys(prop.getProperty("LastName"));
		
		// Select department from the list
		Select sc = new Select(driver.findElement(By.name(Constents.dep)));
		sc.selectByVisibleText("Engineering");
		
		// Enter username
		WebElement uName = driver.findElement(By.name(Constents.uName));
		uName.sendKeys(b);
				
		// Enter password
		WebElement passW = driver.findElement(By.name(Constents.pass));
		passW.sendKeys(prop.getProperty("Password"));
		
		// Enter conform password
		WebElement cPass1 = driver.findElement(By.name(Constents.cPass));
		cPass1.sendKeys(prop.getProperty("CPassword"));
		
		// Enter email address
		WebElement eMail = driver.findElement(By.name(Constents.eMail));
		eMail.sendKeys(a);
		
		// Enter contact number
		WebElement cNum1 = driver.findElement(By.name(Constents.cNum));
		cNum1.sendKeys(prop.getProperty("CNo"));
		
		// Click on Submit button
		WebElement sub = driver.findElement(By.xpath(Constents.sButton));
		sub.click();
		
		logger.info("Checking assert conditions");
		boolean expect = driver.getPageSource().contains("Please enter your Username");
		sa.assertEquals(true, expect);
		
		boolean expect1 = driver.getPageSource().contains("Please enter your Password");
		sa.assertEquals(true, expect1);
		
		sa.assertAll();
		
	}	
}