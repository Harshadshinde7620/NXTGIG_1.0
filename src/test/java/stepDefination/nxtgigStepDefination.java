package stepDefination;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.alertUtil;
import Utilities.screenshotUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Exception;
import io.opentelemetry.api.internal.Utils;
import pageObjects.ArtistRegistration;
import pageObjects.LoginPage;
import pageObjects.SearchFunctionality;
import pageObjects.SignupPage;

public class nxtgigStepDefination 
{

//LOGIN PAGE
	
	WebDriver driver= hooks.driver;
	LoginPage loginPage;
	
	
	@Given("user is on Login Page")
	public void user_is_on_login_page() {
    	loginPage= new LoginPage(driver);
    }
    
	@When("user should be able to login with valid {string} and {string}")
	public void user_should_be_able_to_login_with_valid_and(String username, String password) {
    	loginPage.login(username, password);
    }
    
	@Then("user shoule be directed to {string} pages")
	public void user_shoule_be_directed_to_pages(String expectedDashboard) {
    	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs(expectedDashboard));
		
		String actualPageName= driver.getTitle();
		
		if (actualPageName.equals(expectedDashboard))
		{

			System.out.println("User Login Sucessfull");
		}
		else 
		{
			System.out.println("User Login un-sucessfull");
			screenshotUtility.takescreenshot(driver, "LoginFailed");
			Assert.fail("ExpectedDashboard: "+ expectedDashboard + ", but found :" + actualPageName ); 

		}
	
    }
	// Login with invalid credentials
	
	    @When("user should not be login into with {string} and {string}")
	    public void user_should_not_be_login_into_with_and(String username, String password) {
	        loginPage.login(username, password);
	    }
	    
	    @Then("user must be shown {string}")
	    public void user_must_be_shown(String expectedError) {
	    	String actualError= alertUtil.getAlertText(driver);
	    	Assert.assertEquals(actualError, expectedError);
	    	
	    	alertUtil.acceptAlert(driver);
	    }
    
	    // Error messages for Login Page
	    @When("user enters wrong details of {string} and {string}")
	    public void user_enters_wrong_details_of_and(String username, String password) 	{
	    	loginPage.errorMessgaesLogin(username, password);
	    }
	    
	    @Then("user should be shown {string}")
	    public void user_should_be_shown(String expectedError) 
	    {
	    String actualError= loginPage.getErrorMessages();
	    
	    Assert.assertEquals(actualError, expectedError,
		"ExpectedError:" + expectedError + "but found: " +actualError);
	    }

//SIGNUP PAGE
	    
	    SignupPage signupPage;
	    
	    @Given("User is on the signup page")
	    public void user_is_on_the_signup_page() {
	    	signupPage= new SignupPage(driver);
	    }
	    
	    @When("User fills the {string}, {string}, {string}, {string}, {string}, and {string}")
	    public void user_fills_the_and(String firstName, String lastName, String emailId, String phoneNumber, String password, String confirmPassword) {
	    	signupPage.signUp(firstName, lastName, emailId, phoneNumber, password, confirmPassword);
	    }
	    
	    @Then("User sees following {string}")
	    public void user_sees_following(String expectedMessage) {
	    	String actualMessage = signupPage.getWelcomeMessage();	    	
	    Assert.assertEquals(actualMessage, expectedMessage,
	    		"ExpectedMessage: " + expectedMessage + "but found:" + actualMessage ); 
	    }
	    //Re-regsitration
	    
	    @Then("User sees {string}")
	    public void user_sees(String expectedMessage) {
	    	String actualMessage = alertUtil.getAlertText(driver);	    	
	    Assert.assertEquals(actualMessage, expectedMessage,
	    		"ExpectedMessage: " + expectedMessage + "but found:" + actualMessage ); 
	    }
	    //Error Validation
	    @Then("User gets {string}")
	    public void user_gets(String expectedErrorMessage) {
	        List<String> actualErrors = signupPage.getErrorMessages();
	        Assert.assertTrue(actualErrors.contains(expectedErrorMessage),
	                "Expected error: " + expectedErrorMessage + " but found: " + actualErrors);

	    }
//SEARCH FUNCTIONALITY
	    //Single Day Event search with valid data
	    SearchFunctionality searchFunctionality;
	    
	    @Given("user is on the website")
	    public void user_is_on_the_website() {
	    	searchFunctionality = new SearchFunctionality(driver);
	    }
	    @When("user fills the {string}, {string} and {string}")
	    public void user_fills_the_and(String upcomingEvent, String city, String eventDate) {
	    	searchFunctionality.singleDayEvent(upcomingEvent, city, eventDate);
	    }
	    
	    @Then("list of registered user should be shown {string}")
	    public void list_of_registered_user_should_be_shown(String verificationText) {
	    	String actualText= searchFunctionality.getSearchResultText();
	    try {	
	    	Assert.assertEquals(actualText, verificationText,
	    			"VerificationText" + verificationText + "but got:" +actualText);
	    } catch (AssertionError e)
	    {
	    	screenshotUtility.takescreenshot(driver, "SearchFailure");
	    	throw e;
	    }
	    }
	    
	    //Error on single day event.
	    @Then("user must verfies {string}")
	    public void user_must_verfies(String expectedMessage) {
	    	String actualMessage= searchFunctionality.getSearchResultText();
	    	
	    	try {
	    		Assert.assertEquals(actualMessage, expectedMessage, 
	    				"VerificationText: " +expectedMessage+ "But got: " + actualMessage);
	    	} catch (AssertionError e)
	    	{
		    	screenshotUtility.takescreenshot(driver, "SearchFailure");
		    	throw e;
	    	}

	    }
	    
	    //find Registered Artist for single day event
	    @Then("verfiy no of registered artists with thier {string}")
	    public void verfiy_no_of_registered_artists_with_thier(String expectedResult) {
	    	String actualResult= searchFunctionality.verfiyNumberofRegisteredArtists();
	    	
	    	try
	    	{
	    		Assert.assertEquals(actualResult, expectedResult,
	    				"Expected Result: " + expectedResult + "but found: " +actualResult);
	    		
	    	} catch (AssertionError e)
	    	{
	    		screenshotUtility.takescreenshot(driver, actualResult);
	    		throw e;
	    	}
	    }
	    
	    //Verify the profile pic of artists
	    @Then("the artist's profile picture should be displayed")
	    public void verify_artist_profile_picture() {
	    	searchFunctionality.verfiyProfilePic();
	    }

	    
	    //find the no of artist and their name
	    @Then("get the registered artists with {string} and {string}")
	    public void get_the_registered_artists_with_and(String expectedResults, String expectedArtistName) {
	    	String actualResults= searchFunctionality.verfiyNumberofRegisteredArtists();
	    	Assert.assertEquals(actualResults, expectedResults,
	    				"Expected Results: " + expectedResults + "But got: " +actualResults);
	    	
	    	List<String> artists= searchFunctionality.ArtistsList();
	        boolean isArtistPresent = artists.stream()
	                .anyMatch(name -> name.equalsIgnoreCase(expectedArtistName));
	        Assert.assertTrue(isArtistPresent, 
	        		"Expected artist name: " + expectedArtistName + "But got:" +artists);

	    	
	    }
	    
	    //Extract searched event name and date
	    @Then("get the {string} and {string} from the search page")
	    public void get_the_and_from_the_search_page(String expectedSearchEvent, String expectedSearchEventDate) {
	    	String actualSearchEvent= searchFunctionality.getSearchedEvent();
	    	Assert.assertEquals(actualSearchEvent, expectedSearchEvent,
	    			"Expected Search Event:" + expectedSearchEvent + "But got:" +actualSearchEvent);
	    	
	    	
	    	String actualSearchEventDate= searchFunctionality.getSearchedEventDate();
	    	
	    	Assert.assertEquals(actualSearchEventDate, expectedSearchEventDate,
	    			"Expected Search Event Date: " + expectedSearchEventDate + "But got:" +actualSearchEventDate);
	    }
	        
	    //update the event and date field in serach page
	    @When("user fills {string}, {string}, and {string}")
	    public void user_fills_and(String upcomingEvent, String city, String eventDate) {
	    	searchFunctionality.singleDayEvent(upcomingEvent, city, eventDate);
	    }

	    @And("verifies {string} and {string}")
	    public void verifies_event_and_date(String searchEvent, String searchEventDate) {
	    	String actualSearchEvent= searchFunctionality.getSearchedEvent();
	    	Assert.assertEquals(actualSearchEvent, searchEvent,
	    			"Expected Search Event:" + searchEvent + "But got:" +actualSearchEvent);
	    	
	    	
	    	String actualSearchEventDate= searchFunctionality.getSearchedEventDate();
	    	
	    	Assert.assertEquals(actualSearchEventDate, searchEventDate,
	    			"Expected Search Event Date: " + searchEventDate + "But got:" +actualSearchEventDate);
	    }
	
	    
	    
	    @Then("user updates fields with {string}, {string}, and {string} on the search page")
	    public void user_updates_fields(String updatedEvent, String updatedCity, String updatedEventDate) throws InterruptedException {
	    	Thread.sleep(10);
	    	searchFunctionality.updateSearchpagefields(updatedEvent, updatedCity, updatedEventDate);
	    	
	    	String actualSearchEvent= searchFunctionality.getSearchedEvent();
	    	Assert.assertEquals(actualSearchEvent, updatedEvent,
	    			"Expected Search Event:" + updatedEvent + "But got:" + actualSearchEvent);
	    	
	    	String actualSearchEventDate= searchFunctionality.getSearchedEventDate();
	    	Assert.assertEquals(actualSearchEventDate, updatedEventDate,
	    			"Expected Search Event Date: " + updatedEventDate + "But got:" +actualSearchEventDate);

	    	
	    }

	    
	    //Multiple Dya Event with valid data
	    
	    @When("user submits the {string}, {string} and {string} data")
	    public void user_submits_the_and_data(String upcomingEvent, String city, String eventDate) {
	    	searchFunctionality.multipleDayEvent(upcomingEvent, city, eventDate);
	    }
	    
	    @Then("user_verfies {string}")
	    public void user_verfies(String verificationText) {
	    	String actualText= searchFunctionality.getSearchResultText();
	    	
	    	try {
	    		Assert.assertEquals(actualText, verificationText, 
	    				"VerificationText: " +verificationText+ "But got: " + actualText);
	    	} catch (AssertionError e)
	    	{
		    	screenshotUtility.takescreenshot(driver, "SearchFailure");
		    	throw e;

	    	}
	    	
	    }
	    
	    //Get the regsitered artist number in multi day event
	    @Then("get registered artists number using{string}")
	    public void get_registered_artists_number_using(String expectedResult) {
	    	String actualResult= searchFunctionality.verfiyNumberofRegisteredArtists();
	    	
	    	try
	    	{
	    		Assert.assertEquals(actualResult,expectedResult,
	    				"Expected Result:" + expectedResult + "But found:" +actualResult);
	    	}catch (AssertionError e)
	    	{
	    		screenshotUtility.takescreenshot(driver, actualResult);
	    		throw e;
	    		
	    	}
	    	
	    }
	    
	    //Verfiy the number of registered artists
	    @Then("verfiy the registered artists with the help of {string} and {string}")
	    public void verfiy_the_registered_artists_with_the_help_of_and(String expectedResults, String expectedArtistName) {
	    	
	    	String ActualResults=  searchFunctionality.verfiyNumberofRegisteredArtists();
	    	
	    	Assert.assertEquals(ActualResults, expectedResults,
	    	"Expected Results: " + expectedResults + "But got: " +ActualResults);
	    	
	    	
	    	List<String> artistslist= searchFunctionality.ArtistsList();
	    	boolean isartistpresent= artistslist.stream()
	    			.anyMatch(name-> name.equalsIgnoreCase(expectedArtistName));
	    	
	    	Assert.assertTrue(isartistpresent,
	    			"Expected Artist Name:" + expectedArtistName + "But got:" +artistslist);
	    	
	    }
	    
	    
	    //Error on multi day event.
	    @Then("user should verfies {string}")
	    public void user_should_verfies(String expectedMessage) {
	    	String actualMessage= alertUtil.getAlertText(driver);
	    	try
	    	{	Assert.assertEquals(actualMessage, expectedMessage,
	    			"Expected: " + expectedMessage + "but got: " + actualMessage);
	    	} catch (AssertionError e)
	    	{
		    	screenshotUtility.takescreenshot(driver, "SearchFailure");
		    	throw e;

	    	}
	    }

	    
	   	    	
	    	


	    
}
