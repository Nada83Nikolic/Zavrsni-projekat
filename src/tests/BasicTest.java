package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.ProfilePage;

public abstract class BasicTest {
	
	protected WebDriver driver;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
	
	protected LocationPopupPage locationPPage;
	protected LoginPage loginPage;
	protected NotificationSystemPage notifSystemPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSPage;
	protected String baseUrl = "http://demo.yo-meals.com/";
	protected String email = "customer@dummyid.com";
	protected String password = "12345678a";
	
	@BeforeMethod
		public void config() {
		System.setProperty("webdriver.chrome.driver", "driver-lib/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		js=(JavascriptExecutor) driver;
		wait=(WebDriverWait) driver;
		locationPPage = new LocationPopupPage(driver, js, wait);
		loginPage = new LoginPage(driver, js, wait);
		notifSystemPage = new NotificationSystemPage(driver, js, wait);
		profilePage = new ProfilePage(driver, js, wait);
		authPage = new AuthPage(driver, js, wait);
		mealPage = new MealPage(driver, js, wait);
		
	}
	
	
	
	
}
