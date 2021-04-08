package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized ");
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("url is launched ");
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin(); // driver.findElement(By.css()
		lp.getEmail().sendKeys(Username);
		log.info("user id is entered");
		lp.getPassword().sendKeys(Password);
		log.info("password is entered ");
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		// 0th row
		data[0][0] = "abc@123";
		data[0][1] = "12345";
		// data[0][2] = "Restrcited User";
		// 1th row
		data[1][0] = "abcd@123";
		data[1][1] = "1234567";
		// data[1][2] = "NonRestrcited User";
		return data;
	}

}
