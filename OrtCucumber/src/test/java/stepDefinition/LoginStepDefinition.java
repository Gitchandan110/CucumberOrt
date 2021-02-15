package stepDefinition;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginStepDefinition {
	
	public static WebDriver driver;
	

	
	@Given("^user opens chrome driver$")
		
	public static WebDriver user_opens_chrome_driver() {
		
		
		System.setProperty("webdriver.chrome.driver", "F:\\Eclipse\\Git\\OrtCucumber\\Test Data\\chromedriver.exe");
        driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		return driver;
	
	
	}
	
	@Given("^user navigates to https://safety.kuvrr.com/$")
	
	public void user_navigates_to_loginPage() {
		
		driver.get("https://safety-test.kuvrr.com/");
		
	}
	
	
	@When("^title of the login page is Safety Kuvrr$")
	
	public void verifyloginPageTitle() {
		
	String pageTitle=driver.getTitle();	
	System.out.println("Login Page Title is :"+pageTitle);
	assertEquals(pageTitle, "Safety Kuvrr");
		
	}
	
	@Then ("^user enters email \"(.*)\" and password \"(.*)\"$")
	
	public void fillUserCredential(String email, String password) {
		
		driver.findElement(By.cssSelector("input[type='text'][id='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[type='password'][id='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[class='btn'][id='submit']")).click();
		
			
	}
	
	@Then ("^user click on continue button$")
	
	public void clickContinue() {
		
	WebElement btnContinue=driver.findElement(By.id("submit"));
		
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",btnContinue);	
			
	}


	@And ("^user is on home Page$")
	
	public void user_is_on_home_page() {
		
	String pageTitle=driver.getTitle();
	System.out.println("Home Page Title is :"+pageTitle);
	assertEquals(pageTitle, "Active Events");
		
		
	}
	
	
}
