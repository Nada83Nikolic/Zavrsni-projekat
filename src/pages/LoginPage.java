package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	

	public LoginPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}

	public WebElement getUsername() {
		return this.driver.findElement(By.name("username"));
	}

	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}

	public WebElement getLoginButton() {
		return this.driver.findElement(By.name("btn_submit"));
	}

	public void login(String email, String password) {
		this.getUsername().clear();
		this.getUsername().sendKeys(email);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getLoginButton().click();
	}

}
