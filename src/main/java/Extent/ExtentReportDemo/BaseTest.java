package Extent.ExtentReportDemo;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	/*
	 * Intialize webdriver in this Method
	 *
	 */
	@BeforeMethod
	//@Parameters(value = { "browser" })
	public void setUpTest() {
		
		
		String browser= System.getProperty("browserName");
		System.out.println("The user select execution browser is:"+browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}

		else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}

		else {
			System.out.println("Invalid Broswer choice");
		}

	}

	public WebDriver getDriver() {
		return driver.get();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}

	@AfterClass

	public void dispose() {
		driver.remove();
	}

	public String getScreenshotPath(String TestCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "\\Screenshot\\" + TestCaseName + ".png";
		File file = new File(destPath);
		FileUtils.copyFile(source, file);
		return destPath;

	}

}
