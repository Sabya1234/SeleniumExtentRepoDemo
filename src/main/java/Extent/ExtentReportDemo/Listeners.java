package Extent.ExtentReportDemo;

import java.io.IOException;

import org.testng.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReporterConfig.reportGenerator();

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().log(Status.PASS, "Success");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.get().fail(result.getThrowable());
		try {
			extentTest.get().addScreenCaptureFromPath(
					getScreenshotPath(result.getMethod().getMethodName(), getDriver()),
					result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
