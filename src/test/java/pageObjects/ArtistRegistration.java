package pageObjects;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ArtistRegistration {

	WebDriver driver;
	
	
	//Constructor
	public ArtistRegistration(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement
	
	//Homepage Elements
	By JoinAsArtist_btn= By.xpath("//a[@class='menu__link']//button[@type='button'][normalize-space()='Join as Artist']");
	
	//page 1 elements
	By WhatsYourTalent_loc= By.xpath("//select[@id='artistRegistrationTalent']");
	By GigLocation_loc= By.xpath("//input[@id=\"artistRegistrationGig\"]");
	By startGettingGig_btn= By.xpath("//button[normalize-space()='Start Getting Gigs']");
	
	
	//page 2 elements
	By ArtistName= By.xpath("//input[@id='artistRegistrationFullName']");
	By ErrorArtistName= By.xpath("//div[@id='name-error']");
	
	By ProfessionalName= By.xpath("//input[@id='artistRegistrationProfessionalName']");
	By ErrorProfessionalName= By.xpath("//div[@id='pro-name-error']");
	
	By ArtistDOB= By.xpath("//input[@id='artistRegistrationDob']");
	By ErrorArtistDOB= By.xpath("//input[@id='artistRegistrationDob']");
	
	By ArtistRegistrationPassword= By.xpath("//input[@id='artistRegistrationPassword']");
	By ErrorArtistRegistrationPassword= By.xpath("//input[@id='artistRegistrationPassword']");
	
	By ArtistRegistrationConfirmPassword= By.xpath("//input[@id='artistRegistrationConfirmPassword']");
	By ErrorArtistRegistrationConfirmPassword= By.xpath("//div[@id='conf-pass-error']");
	

	By Continue2_Btn= By.xpath("//button[normalize-space()='Continue']");
	
	//page 3 elements
	By GeneralCategory= By.xpath("//select[@id='artistRegistrationGeneralCategory']");
	By SpecificCategory= By.xpath("//select[@id='artistRegistrationSpecificCategory']");
	By Continue3_Btn= By.xpath("//button[normalize-space()='Continue']");
	
	
	
	//page 4 elements
	By HearAboutNXTGIG= By.xpath("//select[@id='artistRegistrationHearingSource']");
	By Continue4_Btn= By.xpath("//button[normalize-space()='Continue']");

	//Page 5 Elements [Artsit Adress]

	By ArtistAddress= By.xpath("//input[@id='artistRegistrationAddress']");
	By ArtistCity= By.xpath("//select[@id='artistRegistrationCity']");
	By ArtistZipCode= By.xpath("//input[@id='artistRegistrationZipCode']");
	By Continue5_Btn= By.xpath("//button[normalize-space()='Continue']");

	// PAGE 6 elements
	By ArtistProfilePic= By.xpath("//input[@id='image_name']");
	By Continue6_Btn= By.xpath("//button[normalize-space()='Continue']");

	// PAGE 7 elements
	By ServiceOverview= By.xpath("//textarea[@id= 'serviceOverview']");
	By Continue7_Btn= By.xpath("//button[@class='btn btn-blue text-white py-2 w-25']");
	
	//Page 8 Elements [Artist Business details]
	By ArtistPhoneNumber= By.xpath("//input[@id='phone_number']");
	By ArtistEmail= By.xpath("//input[@id='email']");
	By FreeTextNofitications= By.xpath("//input[@id='exampleCheck1']");
	By ArtistSSN=By.xpath("//input[@id='business_ssn']");
	By ArtistDocumentsUpload= By.xpath("//input[@id='image_name']");
	By NXTGIGTermsOfUseCheckBox= By.xpath("//input[@id='flexCheckDefault']");
	By Continue8_Btn= By.xpath("//button[normalize-space()='Continue']");
	
	//Page 9 Elements[Artist Social Media Links]
	By ArtistYoutubeLink= By.xpath("//input[@id='youtube']");
	By ArtistInstaLink= By.xpath("//input[@id='insta']");
	By ArtistTwitter= By.xpath("//input[@id='twitter']");
	By ArtistFb= By.xpath("//input[@id='facebook']");
	By Continue9_Btn= By.xpath("//button[normalize-space()='Continue']");
	
	//Page 10 Elements [Choose a Plan]
	
	By ArtistProPlan= By.xpath("(//button[contains(text(),'Choose this plan')])[1]");
	By ArtistPremiumPlan= By.xpath("(//button[contains(text(),'Choose this plan')])[2]");
	By ArtistFeaturedPlan= By.xpath("//div[@class='col px-md-5 px-md-2 px-4 feature-bg']//button[normalize-space()='Choose this plan']");
		
	//Verfification Text
	By Page1Text= By.xpath("//div[@class='font-2 blue text-center cbbold']");
	By Page2Text= By.xpath("//div[contains(text(),'Nice to meet you')]");
	By Page3Text= By.xpath("//label[normalize-space()='How did you hear about NXTGIG? (Optional)']");
	By Page4Text= By.xpath("//label[normalize-space()='Address']");
	By Page5Text= By.xpath("//button[normalize-space()='Continue']");
	By Page6Text= By.xpath("//label[normalize-space()= 'Service overview']");
	By Page7Text= By.xpath("//label[normalize-space()='Phone number']");
	By Page8Text= By.xpath("//label[normalize-space()='Social media']");
	By Page9Text= By.xpath("//h4[normalize-space()='Pro']");
	By Page10Text= By.xpath("//span[@id='areaUserEmail']");
	
	//Action methods
	public void startRegistration(String Talent, String Location){
	
		driver.findElement(JoinAsArtist_btn).click();			
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(WhatsYourTalent_loc));
		
		//As we have drop down so we create new web element
		WebElement drpdown= driver.findElement(WhatsYourTalent_loc);
		Select select= new Select(drpdown);
		select.selectByVisibleText(Talent);
		
		driver.findElement(GigLocation_loc).sendKeys(Location);
		
		WebElement btn1= wait.until(ExpectedConditions.elementToBeClickable(startGettingGig_btn));
		btn1.click();
	}
	
	public void artistPersonalDetails(String Name, String professionalName, String DOB, String Password, String confirmPassword) throws InterruptedException {
		
		driver.findElement(ArtistName).sendKeys(Name);
		driver.findElement(ProfessionalName).sendKeys(professionalName);
		driver.findElement(ArtistDOB).sendKeys(DOB);
		driver.findElement(ArtistRegistrationPassword).sendKeys(Password);
		driver.findElement(ArtistRegistrationConfirmPassword).sendKeys(confirmPassword);
		
		WebElement continueButton = driver.findElement(Continue2_Btn);
		
		//Scroll to the button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", continueButton);
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(Continue2_Btn));
		
	    // Try clicking via JS to avoid interception
		try {
	    	continueButton.click();
	    } catch (Exception e) {
	        js.executeScript("arguments[0].click();", continueButton);
	    }

	}
	
	public void artistService(String genaralCategory , String specificCategory) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(GeneralCategory));
		
		WebElement drpdown= driver.findElement(GeneralCategory);
		Select select= new Select(drpdown);
		select.selectByVisibleText(genaralCategory);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(SpecificCategory));
		
		WebElement drpdown2= driver.findElement(SpecificCategory);
		Select select2= new Select(drpdown2);
		select2.selectByVisibleText(specificCategory);		
		
		WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(Continue3_Btn));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

	}
	
	public void HearAboutNXTGIG(String nxtgigHearing) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement drpdown= wait.until(ExpectedConditions.visibilityOfElementLocated(HearAboutNXTGIG));
		
		Select select= new Select(drpdown);
		select.selectByVisibleText(nxtgigHearing);

		
		WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(Continue4_Btn));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
		
	}
	
	public void artistAddressFilling(String Address, String City, String Zipcode) {
		
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
		
		driver.findElement(ArtistAddress).sendKeys(Address);
		
		WebElement drpdown= wait.until(ExpectedConditions.visibilityOfElementLocated(ArtistCity));
		Select select= new Select(drpdown);
		select.selectByVisibleText(City);
		
		driver.findElement(ArtistZipCode).sendKeys(Zipcode);
		
		WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(Continue4_Btn));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
		
	}
	
	public void uploadArtistProfilePicture(String fileName) {
		
		    String fullPath = Paths.get(System.getProperty("user.home"), "Downloads", fileName).toString();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		    // Try to dismiss browser overlays first
		    try { new Actions(driver).sendKeys(Keys.ESCAPE).perform(); } catch(Exception e) {}

		    // Wait for presence (not visibility), then make visible if required
		    WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(ArtistProfilePic));
		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].style.display='block'; arguments[0].style.visibility='visible'; arguments[0].style.opacity=1;", input);

		    // upload file
		    input.sendKeys(fullPath);

		    // wait for file value or thumbnail to appear
		   //s wait.until(ExpectedConditions.attributeToBeNotEmpty((WebElement) ArtistProfilePic, "value"));

		    // then click continue
		    WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(Continue6_Btn));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
	}
	
	public void fillServiceOverview (String serviceOverview )
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    
		driver.findElement(ServiceOverview).sendKeys(serviceOverview);
	    
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(Continue7_Btn));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);

	}
	public void fillAirtistsProfessionalDetails(String phoneNumber, String emailId, String ssnNumber, String docName)
	{
		driver.findElement(ArtistPhoneNumber).sendKeys(phoneNumber);
		driver.findElement(ArtistEmail).sendKeys(emailId);
		driver.findElement(ArtistSSN).sendKeys(ssnNumber);
		
	    String fullPath = Paths.get(System.getProperty("user.home"), "Downloads", docName).toString();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    
	    // Try to dismiss browser overlays first
	    try { new Actions(driver).sendKeys(Keys.ESCAPE).perform(); } catch(Exception e) {}

	    // Wait for presence (not visibility), then make visible if required
	    WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(ArtistDocumentsUpload));
	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].style.display='block'; arguments[0].style.visibility='visible'; arguments[0].style.opacity=1;", input);

	    // upload file
	    input.sendKeys(fullPath);

	    // then click continue
	    WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(Continue7_Btn));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
		
	}
	
	
	public void fillartistSocialMediaLinks(String youtube, String Insta, String Twitter, String Fb) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.findElement(ArtistYoutubeLink).sendKeys(youtube);
		driver.findElement(ArtistInstaLink).sendKeys(Insta);
		driver.findElement(ArtistTwitter).sendKeys(Twitter);
		driver.findElement(ArtistFb).sendKeys(Fb);
		
	    // then click continue
	    WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(Continue7_Btn));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);		
	}
	
	public void artistSelectPlan() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement plan= wait.until(ExpectedConditions.visibilityOfElementLocated(ArtistFeaturedPlan));
		
	    // Scroll into view before clicking
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plan);

	    // Add a slight pause (helps on slow UIs)
	    try {
	        Thread.sleep(500);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    
	    plan.click();
		
		 // then click continue
	    WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(Continue7_Btn));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);		
	}
	
	public String verifyPage1Text()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement pageTitle= wait.until(ExpectedConditions.visibilityOfElementLocated(Page1Text));
		return pageTitle.getText().trim();			
	}
	
	public String verifyPage2Text()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement pageTitle= wait.until(ExpectedConditions.visibilityOfElementLocated(Page2Text));
		// Wait until element has ANY non-empty text
	    wait.until(driver -> !pageTitle.getText().trim().isEmpty());

	    String actualText = pageTitle.getText().trim();
	    System.out.println("DEBUG >>> Page text is: " + actualText);

	    return actualText;	
	}
	
	public String verfiyPage3Text() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pageTitle= wait.until(ExpectedConditions.visibilityOfElementLocated(Page3Text));
		
		return pageTitle.getText().trim();
	}
	
	public String verfiyPage4Text() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pageTitle= wait.until(ExpectedConditions.visibilityOfElementLocated(Page4Text));
		
		return pageTitle.getText().trim();
	}
	
	public String verfiyPage5Element() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement btn= wait.until(ExpectedConditions.visibilityOfElementLocated(Page5Text));
		btn.isDisplayed();
		return btn.getText().trim();
	}

	public String verfiyPage6Element() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pageText= wait.until(ExpectedConditions.visibilityOfElementLocated(Page6Text));

		return pageText.getText().trim();
	}
	
	public String verfiyPage7Element() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pageText= wait.until(ExpectedConditions.visibilityOfElementLocated(Page7Text));
		
		return pageText.getText().trim();
		
	}
	public String verfiyPage8Element() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pageText= wait.until(ExpectedConditions.visibilityOfElementLocated(Page8Text));
		
		return pageText.getText().trim();
		
	}
	
	public String verfiyPage9Element() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pageText= wait.until(ExpectedConditions.visibilityOfElementLocated(Page9Text));
		
		return pageText.getText().trim();
		
	}
	
	public String verfiyPage10Element() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pageText= wait.until(ExpectedConditions.visibilityOfElementLocated(Page10Text));
		
		return pageText.getText().trim();
		
	}
}
