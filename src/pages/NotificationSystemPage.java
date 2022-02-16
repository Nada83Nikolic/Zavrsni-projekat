package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {

	public NotificationSystemPage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);	
	}
	public WebElement getMessage () {
		return this.driver.findElement(By.xpath( "//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')][contains(@style,'display: block')]"));	
	}
	public String getMessageText() {
		return this.getMessage().getText();
	}
	//ceka da nestane
	public void waitMessageToDisappear() {
		WebElement m=this.driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
		this.wait.until(ExpectedConditions.attributeContains(By.xpath("//*[contains(@class, 'system_message')])"), "style", "display: none;"));
	}
	//vraca da li je nestala
	public boolean messageDisappeared() {
		WebElement m=this.driver.findElement(By.xpath("//*[contains(@class, 'system_message')]"));
		return this.wait.until(ExpectedConditions.attributeContains(m, "style", "display: none;"));
	}
}
