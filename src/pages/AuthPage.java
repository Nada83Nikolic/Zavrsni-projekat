package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}

	public WebElement getAccountDropDoown() {
		return this.driver.findElement(By.xpath("//*[@class='filled ']/a"));
	}

	public WebElement getMyAccountField() {
		return this.driver.findElement(By.linkText("My Account"));
	}

	public WebElement getLogOutField() {
		return this.driver.findElement(By.linkText("Logout"));
	}

	public void logOut() {
		this.getAccountDropDoown().click();
		this.getLogOutField().click();
	}
}
