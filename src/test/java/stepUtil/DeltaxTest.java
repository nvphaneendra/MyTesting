package stepUtil;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.io.FileNotFoundException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import helpers.Constents;
import helpers.UtilityHelper;

public class DeltaxTest extends BaseClass{
	
private static final Logger logger = Logger.getLogger(DeltaxTest.class);
	
	@Test	
	public void Test() throws FileNotFoundException {
		
		String a = UtilityHelper.email();
		String b = UtilityHelper.uName();
		
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
//		WebElement uName = driver.findElement(By.name(Constents.uName));
//		uName.sendKeys(b);
		WebElement expected = driver.findElement(By.xpath("*//[id='contact_form']/fieldset/div[4]/div/small[2]"));
		String str = expected.getText();
		Assert.assertEquals("Please enter your Username", str);
		
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
		
	}	
}