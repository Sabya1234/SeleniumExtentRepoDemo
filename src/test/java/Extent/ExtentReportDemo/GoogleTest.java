package Extent.ExtentReportDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest extends BaseTest {

	@Test
	public void validateGooglesearch() throws InterruptedException {
		System.out.println(String.format("Test case started %S",Thread.currentThread().getId()));
		getDriver().get("https://www.google.com/");
		getDriver().manage().window().maximize();
		// test.log(Status.PASS,"Web page open");
		System.out.println(getDriver().getTitle());
		
		Thread.sleep(7000);

		getDriver().findElement(By.name("q")).sendKeys("naveen automation labs");
		getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
		String actualName = getDriver().findElement(By.xpath("//h3[contains(text(),'Welcome to')]")).getText();
		System.out.println(actualName);
		// Assert.assertTrue(actualName.contains("Welcome to Naveen"));
		Assert.assertTrue(actualName.contains("Welcome to Sabya"));
		
	}

	

}
