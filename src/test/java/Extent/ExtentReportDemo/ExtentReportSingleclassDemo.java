package Extent.ExtentReportDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportSingleclassDemo {
	
	WebDriver driver;
	ExtentReports extent;
	
	
	@BeforeTest
	public ExtentReports config()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Sabyasachi Nag");
		extent.setSystemInfo("Production","QA");
		
		return extent;
	}
	
	
	
	
	@Test
	public void initialDemo()
	{
		ExtentTest test=extent.createTest("demo extent reporter Test");
		//WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		test.log(Status.PASS,"Web page open");
		System.out.println(driver.getTitle());
		driver.close();
		test.pass("Test case passed");
		extent.flush();
		//driver.
	}
	

}
