package Extent.ExtentReportDemo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMTest extends BaseTest {

	@Test
	public void validateHRMPageTitle() throws InterruptedException {
		System.out.println(String.format("Test case started %S",Thread.currentThread().getId()));
		getDriver().get("https://opensource-demo.orangehrmlive.com/");
		getDriver().manage().window().maximize();
		
		Thread.sleep(6000);
		// test.log(Status.PASS,"Web page open");
		System.out.println(getDriver().getTitle());
		
	}

	
}
