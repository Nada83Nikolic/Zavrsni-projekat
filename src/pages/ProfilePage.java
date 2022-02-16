package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver, JavascriptExecutor js, WebDriverWait wait) {
		super(driver, js, wait);
	}
//img
	public WebElement getImgUpload() {
		return this.driver.findElement(By.xpath("//*[@title='Uplaod']"));
	}

	public WebElement getFileInput() {
		return this.driver.findElement(By.xpath("//*[@type='file']"));
	}

	public WebElement getImgRemove() {
		return this.driver.findElement(By.xpath("//*[@title='Remove']"));
	}
//info
	public WebElement getFirstNameInput() {
		return this.driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastNameInput() {
		return this.driver.findElement(By.name("user_last_name"));
	}

	public WebElement getAddressInput() {
		return this.driver.findElement(By.name("user_address"));
	}

	public WebElement getPhoneInput() {
		return this.driver.findElement(By.name("user_phone"));
	}

	public WebElement getZipCodeInput() {
		return this.driver.findElement(By.name("user_zip"));
	}

	public WebElement getCountrySelect() {
		return this.driver.findElement(By.id("user_country_id"));
	}

	public Select selectCountry() {
		Select selectCountry = new Select(this.getCountrySelect());
		return selectCountry;
	}

	public WebElement getStateSelect() {
		return this.driver.findElement(By.id("user_state_id"));
	}

	public Select selectState() {
		Select selectState = new Select(this.getStateSelect());
		return selectState;
	}

	public WebElement getCitySelect() {
		return this.driver.findElement(By.id("user_city"));
	}

	public Select selectCity() {
		Select selectCity = new Select(this.getCitySelect());
		return selectCity;
	}

	public WebElement getSaveInfoButton() {
		return this.driver.findElement(By.xpath("//*[@id='profileInfoFrm']/div[5]/div/fieldset/input"));
	}
//password
	public WebElement getCurrentPassword() {
		return this.driver.findElement(By.name("current_password"));
	}

	public WebElement getNewPassword() {
		return this.driver.findElement(By.name("new_password"));
	}

	public WebElement getConfirm() {
		return this.driver.findElement(By.name("conf_new_password"));
	}

	public WebElement getSavePassword() {
		return this.driver.findElement(By.xpath("//*[@id='frm_fat_id_changePwdFrm']/div/div[4]/fieldset/input"));
	}
	
//methods
	public void uploadImg(String imgPath) {
		js.executeScript("arguments[0].click", this.getImgUpload());
		this.getFileInput().sendKeys(imgPath);
	}

	public void removeImg() {
		js.executeScript("arguments[0].click", this.getImgRemove());
	}

	public void changePersonalInfo(String fName, String lName, String address, String phone, String zipCode,
			String country, String state, String city) {
		this.getFirstNameInput().clear();
		this.getFirstNameInput().sendKeys(fName);
		this.getLastNameInput().clear();
		this.getLastNameInput().sendKeys(lName);
		this.getAddressInput().clear();
		this.getAddressInput().sendKeys(address);
		this.getPhoneInput().clear();
		this.getPhoneInput().sendKeys(phone);
		this.getZipCodeInput().clear();
		this.getZipCodeInput().sendKeys(zipCode);
		this.selectCountry().selectByVisibleText(country);
		this.selectState().selectByVisibleText(state);
		this.selectCity().selectByVisibleText(city);
		this.getSaveInfoButton().click();
	}
}
