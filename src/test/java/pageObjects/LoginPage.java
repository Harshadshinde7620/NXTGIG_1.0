package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		}
	
	//find all elements
	By homepagelogin_loc= By.xpath("//a[@class='menu__link'][normalize-space()='Login']");
	By username_loc= By.xpath("//input[@id='loginUserName']");
	By password_loc= By.xpath("//input[@id='loginUserPassword']");
	By keepMeLogin_loc= By.xpath("//input[@id='flexCheckDefault']");
	By login_btn= By.xpath("//button[normalize-space()='Login']");
	By forgetPassword_loc= By.xpath("//div[@class='d-flex justify-content-end']");
	By signUp_loc= By.xpath("//span[@class='ms-2 blue']");
	
	
	//Error Elements
	By usernameError_loc= By.xpath("//div[@id='loginUserName-error']");
	By passwordError_loc= By.xpath("//div[@id='loginUserPassword-error']");
	
	//Action Methods
	
	public void login(String Username, String Password)
	{
		driver.findElement(homepagelogin_loc).click();
		driver.findElement(username_loc).sendKeys(Username);
		driver.findElement(password_loc).sendKeys(Password);
		driver.findElement(keepMeLogin_loc).click();
		driver.findElement(login_btn).click();
	
	}
	
	public void errorMessgaesLogin(String Username, String Password)
	{
		driver.findElement(homepagelogin_loc).click();
		if (Username != null)
		{		
			driver.findElement(username_loc).clear();
			driver.findElement(username_loc).sendKeys(Username);
		
		}
		if (Password != null)
		{
			driver.findElement(password_loc).clear();
			driver.findElement(password_loc).sendKeys(Password);
		}
		driver.findElement(login_btn).click();
	
	}
	
	public String getErrorMessages ()
	{
	try
	{
		 return driver.findElement(usernameError_loc).getText().trim();
	}
	
	catch (Exception e)
	{
		return driver.findElement(passwordError_loc).getText().trim();
	}
	}
	
	
	public void forgetPassword() {
		
		driver.findElement(forgetPassword_loc).click();
	}
	
}
