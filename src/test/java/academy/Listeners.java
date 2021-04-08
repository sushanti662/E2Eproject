package academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReportObject();
	// ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();-for thread
	// safe concept

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		// extentTest.set(test);//for thread safe concept

	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test passed");
		// extentTest.get().log(Status.PASS, "Test Passed"); for thread safe

	}

	public void onTestFailure(ITestResult result) {
		// extentTest.get().fail(result.getThrowable());for thread safe
		test.log(Status.FAIL, result.getThrowable());
		WebDriver driver = null;
		String testCaseName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			test.addScreenCaptureFromPath(takesScreenshotPath(testCaseName, driver),
					result.getMethod().getMethodName());
			// takesScreenshotPath(testCaseName, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		extent.flush();

	}

}
