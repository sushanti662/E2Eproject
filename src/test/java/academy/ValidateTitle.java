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

public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initilized");
	}

	@Test
	public void validateAppTitle() throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("navigated to the url");
		LandingPage l = new LandingPage(driver);
		String title = l.getTitle().getText();
		log.info("getting the text of the title");
		Assert.assertEquals(title, "FEATURED COUR13SES");
		log.info("succesfully validated The text message");
		System.out.println("test passed and completed");
		log.info("test case is passed after assertion");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
