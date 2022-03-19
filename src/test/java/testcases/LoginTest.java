package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void LoginFailureTest( ) {
		
//		test = report.startTest("LoginFailureTest");
		
		LoginPage login = new LoginPage();
		login.LoginFunction("loginfailuretest@email.com", "Abc@12345");
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
//		report.endTest(test);
		
	}
	
	@Test
	public void LoginSuccessTest( ) {
		
//		test = report.startTest("LoginSuccessTest");
		
		LoginPage login = new LoginPage();
		login.LoginFunction("donald.kurangwa@asu.edu", "RA9YRJ8eKe7%Q3s");
		
		WebElement ProgramName = driver.findElement(By.xpath ("//*[contains(text(),'Automation Testing Masters Program')]"));
		
		String ActualMsg = ProgramName.getText();
		String ExpMsg = "Automation Testing Masters Program";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
//		report.endTest(test);
	}
	
	
	@Test 
	@Parameters({"Param1", "Param2"})
	public void ParameterizedTest(String UserNameVal, String PasswordVal) {
		
//		test = report.startTest("ParameterizedTest");
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal, PasswordVal);
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
//		report.endTest(test);
	}
	
	@Test
	public void ExternalDataTest( ) {
		
//		test = report.startTest("ExternalDataTest");
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal, PasswordVal);
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);
		
//		report.endTest(test);
	}

}
