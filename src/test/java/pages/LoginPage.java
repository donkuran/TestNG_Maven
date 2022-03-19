package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
	
	WebDriver driver = BaseClass.driver;
	WebDriverWait wait = BaseClass.wait;
	
	ExtentTest test = BaseClass.test;
	
	//===============================Web Elements=====================================
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
//	@FindBy(className = "login")
//	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(name = "btn_login")
	WebElement LoginBtn;
	
	@FindBy(className = "rememberMe")
	WebElement RememberMe;
	
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	//================================Functions ==========================================
	public void LoginFunction(String UserNameVal, String PasswordVal) {

		wait.until(ExpectedConditions.elementToBeClickable(LoginLink));
		
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login Link", "Login link clicked successfully");
		
		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter Username", "Username entered successfully");
		
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password", "Password entered successfully");
		
		RememberMe.click();
		test.log(LogStatus.PASS, "Click Remember Me", "Remember Me clicked successfully");
		
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click Login Button", "Login button clicked successfully");
	}
	
	public void UICheck() {
		
		Assert.assertTrue(UserName.isDisplayed());
	}
}
