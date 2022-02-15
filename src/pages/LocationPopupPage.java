package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);
	}

	public WebElement getClose() {
		return this.driver.findElement(By.className("close-btn close-btn-white"));
	}

	public WebElement getHeaderLocation() {
		return this.driver.findElement(By.className("location-selector"));
	}

	public WebElement getKeyWord() {
		return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

	public WebElement getLocationInput() {
		return this.driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	public void OpenPopup() {
		this.getHeaderLocation().click();
	}

	public void closePopup() {
		this.getClose().click();
	}

	public void setLocationName(String locationName) {
		this.getKeyWord().click();
		String location = this.getLocationItem(locationName).getAttribute("data-value");
		js.executeScript("arguments[0].value=arguments[1]", this.getLocationInput(), location);
		js.executeScript("arguments[0].click", this.getSubmit());
	}
}
