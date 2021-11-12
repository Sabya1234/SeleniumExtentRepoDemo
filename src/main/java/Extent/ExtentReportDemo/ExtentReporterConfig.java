package Extent.ExtentReportDemo;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.internal.annotations.ITest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * here we are creating object ExtentSparkReporter and ExtentReports
 * globally declare ExtentReport object because we need this to every Test
 */
public class ExtentReporterConfig {
	static ExtentReports extent;
	
	
	public static ExtentReports reportGenerator()
	{
		String path = System.getProperty("user.dir")+"\\reports\\TestExecution.html";
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Sabyasachi Nag");
		//String browserInfo= getBrowserInfo(context);
		extent.setSystemInfo("Stage","QA");
		//extent.setSystemInfo("Browser",browserInfo);
		
		return extent;
	}
	
	
}
