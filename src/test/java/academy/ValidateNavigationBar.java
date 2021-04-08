package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initilized");
	}

	@Test
	public void validateAppNavBar() throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("url is launched");
		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.getNavigationBar().isDisplayed());
		log.info("succesfully checked if the navgation bar is displayed or not");
		System.out.println("Test completed");
		// Assert.assertFalse(false);
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
