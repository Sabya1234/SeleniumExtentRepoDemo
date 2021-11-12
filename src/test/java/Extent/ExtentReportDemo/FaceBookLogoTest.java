package Extent.ExtentReportDemo;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;




//import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookLogoTest extends BaseTest{
	

	
	@Test
	public void validateFaceBookLogo() throws InterruptedException
	{
		System.out.println(String.format("Test case started %S",Thread.currentThread().getId()));
		getDriver().navigate().to("https://www.facebook.com/");
		getDriver().manage().window().maximize();
		//test.log(Status.PASS,"Web page open");
		System.out.println(getDriver().getTitle());
		boolean visible=getDriver().findElement(By.cssSelector("img[alt='Facebook']")).isDisplayed();
		Thread.sleep(6000);
		Assert.assertTrue(visible);
		
	}
	
	
	
	
	

}
