package testNGListeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testngTests.TestNGTest;

public class TestNGListeners implements ITestListener {

	TestNGTest tesNgTest;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure");
		TakesScreenshot srcshot = ((TakesScreenshot) TestNGTest.driver);
		File srcFile = srcshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(
				System.getProperty("user-dir") + "/screenshots/" + System.currentTimeMillis() + ".png");
		try {
			FileUtils.copyFile(srcFile, destinationFile);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("OnTest Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On TestFailedBut Wihin Success percentage");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("ON Start");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish");
	}

}
