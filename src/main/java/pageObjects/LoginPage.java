package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.xpath("//input[@id='user_email']");
	// By email=By.cssSelector("[id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By logIn = By.xpath("//input[@data-disable-with='Log In']");
	By forgotPassword = By.xpath("//a[contains(text(),'Forgot Password?')]");

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(logIn);
	}

	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);

	}

}
