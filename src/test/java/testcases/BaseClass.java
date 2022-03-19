package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static WebDriverWait wait;
	
	XSSFWorkbook wbook;
    XSSFSheet sheet;
    
    public static ExtentReports report;
    public static ExtentTest test;
    
    
    @BeforeTest
    public void DataSetUp() throws IOException {
    	
    	FileInputStream fis = new FileInputStream("exceldata.xlsx");
    	
    	wbook = new XSSFWorkbook(fis);
    	sheet = wbook.getSheet("Sheet1");
    	
    	report = new ExtentReports("ExtentReport.html");
    }
    
    @AfterTest
    public void DataTeardown() throws IOException {
    	
    	wbook.close();
    	report.flush();
    	report.close();
    }
	
    
	@BeforeMethod
	public void Setup(Method method) {
		
		test = report.startTest(method.getName());
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();

		driver.get("https://www.simplilearn.com/");	
		
		//Maximize window
		driver.manage().window().maximize();
		
		//wait for browser to load - implicit
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		//explicitly wait for browser
		wait = new WebDriverWait(driver, 50);
		
	}
	
	@AfterMethod
	public void TearDown() {
		
		driver.close();
		report.endTest(test);
		
	}

}
