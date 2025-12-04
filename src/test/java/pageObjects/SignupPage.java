package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {

	//Constructor
	WebDriver driver;
	
	public SignupPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//Elements
	By homepageSignUp_Loc= By.xpath("//a[@class='menu__link'][normalize-space()='Sign Up']");
	By firstName_Loc= By.xpath("//input[@id='userFirstName']");
	By lastName_Loc= By.xpath("//input[@id='userLastName']");
	By email_Loc= By.xpath("//input[@id='userEmail']");
	By mobileNumber_Loc= By.xpath("//input[@id='userMobile']");
	By password_Loc= By.xpath("//input[@id='userPassword']");
	By confirmPassword_Loc= By.xpath("//input[@id='userConfirmPassword']");
	By passwordEyeicon_loc= By.xpath("//span[@id='password-show']");
	By confirmPasswordEyeIcon_Loc= By.xpath("//span[@id='confirmpass-show']");
	By signUp_btn= By.xpath("//button[normalize-space()='Sign up']");
	
	By welcomeText_Loc = By.xpath("//div[contains(@class,'font-2') and contains(@class,'text-center') and contains(@class,'cbbold')]");
	
	//ErrorElements
	By firtsNameError_loc= By.xpath("//div[@id='userFirstName-error']");
	By lastNameError_loc= By.xpath("//div[@id='userLastName-error']");
	By emailError_loc= By.xpath("//div[@id='userEmail-error']");
	By mobileNumberError_loc= By.xpath("//div[@id='userMobile-error']");	
	By passwordErrorMessage= By.xpath("//div[@id='userPassword-error']");
	By confirmpasswordErrorMessage= By.xpath("//div[@id='userConfirmPassword-error']");	
	
	//Action Methods
	
	public void signUp(String firstName, String lastName, String email, String phoneNumber, String password, String confirmPassowrd) {
	
		driver.findElement(homepageSignUp_Loc).click();
		driver.findElement(firstName_Loc).sendKeys(firstName);
		driver.findElement(lastName_Loc).sendKeys(lastName);
		driver.findElement(email_Loc).sendKeys(email);
		driver.findElement(mobileNumber_Loc).sendKeys(phoneNumber);
		driver.findElement(password_Loc).sendKeys(password);
		driver.findElement(passwordEyeicon_loc).click();
		driver.findElement(confirmPassword_Loc).sendKeys(confirmPassowrd);
		driver.findElement(confirmPasswordEyeIcon_Loc).click();
		
		driver.findElement(signUp_btn).click();	
	}
	
	public String getWelcomeMessage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeText_Loc));
	    return text.getText().trim();
	}

	public void fillform(String firstName, String lastName, String email, String phoneNumber, String password, String confirmPassowrd ) {
		
		driver.findElement(homepageSignUp_Loc).click();
		
		if (firstName != null) 
		{
		driver.findElement(firstName_Loc).clear();	
		driver.findElement(firstName_Loc).sendKeys(firstName);

		}
		
		if (lastName != null)
		{
		driver.findElement(lastName_Loc).clear();
		driver.findElement(lastName_Loc).sendKeys(lastName);
		
		}
		
		if (email != null)
		{
			driver.findElement(email_Loc).clear();
			driver.findElement(email_Loc).sendKeys(email);
		}
		
		if (phoneNumber != null )
		{
			driver.findElement(mobileNumber_Loc).clear();
			driver.findElement(mobileNumber_Loc).sendKeys(phoneNumber);
		}
	
		if  (password != null)
		{
			driver.findElement(password_Loc).clear();
			driver.findElement(password_Loc).sendKeys(password);
		}
		
		if (confirmPassowrd != null)
		{
			driver.findElement(confirmPassword_Loc).clear();
			driver.findElement(confirmPassword_Loc).sendKeys(confirmPassowrd);
		}
		
		driver.findElement(signUp_btn).click();		
	}
	
	public List<String> getErrorMessages(){
		List<String> errors= new ArrayList<>();
		
		addErrorIfPresent(errors,firtsNameError_loc);		
		addErrorIfPresent(errors,lastNameError_loc);		
		addErrorIfPresent(errors,emailError_loc);		
		addErrorIfPresent(errors,mobileNumberError_loc);		
		addErrorIfPresent(errors,passwordErrorMessage);		
		addErrorIfPresent(errors,confirmpasswordErrorMessage);		
		
		return errors;
		
	}

	private void addErrorIfPresent(List<String> errors, By locator) 
	{
	    List<WebElement> elements = driver.findElements(locator);

	    if (!elements.isEmpty()) {
	        WebElement el = elements.get(0);
	        if (el.isDisplayed() && !el.getText().trim().isEmpty()) {
	            errors.add(el.getText().trim());
	        }
	    }	
}
	}
