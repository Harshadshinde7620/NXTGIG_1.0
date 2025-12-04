package stepDefination;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Utilities.screenshotUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ArtistRegistration;

public class registrationStepDefination {

	WebDriver driver= hooks.driver;

	//Artist Registration
    
    ArtistRegistration artistRegistration;
    
    @Given("Artist is on the homepage")
    public void artist_is_on_the_homepage() {
    	artistRegistration= new ArtistRegistration(driver);
    }
    
    @When("Artist clicks on the join as artist button and fills the {string} and {string}")
    public void artist_clicks_on_join_as_artist_button_and_fills(String whatsYourTalent, String gigLocation) {
    	artistRegistration.startRegistration(whatsYourTalent, gigLocation);
    }
    
    @Then("Artist should go to the {string}")
    public void artist_should_go_to_the(String expectedPageText) {
    	String actualText= artistRegistration.verifyPage1Text();
    	
    	try {
    	Assert.assertEquals(actualText, expectedPageText,
    			"Expected Page Text: " + expectedPageText + "But got: " + actualText);
    	} catch (AssertionError e)
    	{
	    	screenshotUtility.takescreenshot(driver, "SearchFailure");
	    	throw e;
    	}
    	}
    
     @When("Artist fills the personal details such as {string}, {string}, {string}, {string} and {string}")
        public void artist_fills_personal_details(String fullName, String professionalName, String dob, String password, String confirmPassword) throws InterruptedException {
    	 artistRegistration.artistPersonalDetails(fullName, professionalName, dob, password, confirmPassword);
        }
     
     @Then("Artist is directed to the {string}")
     public void artist_is_directed_to_the(String expectedText) {
    	    String actualText = artistRegistration.verifyPage2Text();
    try {	    
    	    Assert.assertTrue(actualText.contains(expectedText),
    	            "Expected Page Text: " + expectedText + " but got: " + actualText);
        }catch(AssertionError e)
    	 {
    		 screenshotUtility.takescreenshot(driver, actualText);
    		 throw e;
    	 }
     }
     
     @When("Artist fills service details such as {string} and {string}")
     public void artist_fills_service_details(String generalCategory, String specificCategory) {
    	 artistRegistration.artistService(generalCategory, specificCategory);
     }
     
     @Then("Artist verfies the {string}")
     public void artist_verifies_the_page(String expectedText) {
    	 String actualText= artistRegistration.verfiyPage3Text();
    	 
    	 try {
     	    Assert.assertTrue(actualText.contains(expectedText),
    	            "Expected Page Text: " + expectedText + " but got: " + actualText);
    	 }catch(AssertionError e)
    	 {
    		 screenshotUtility.takescreenshot(driver, actualText);
    		 throw e;
    	 }
     }

     @When("Artist shares where did he {string}")
     public void artist_shares_where_did_he(String hearAboutNXTGIG) {
    	 artistRegistration.HearAboutNXTGIG(hearAboutNXTGIG);
     }
     
     @Then("Artist leads to {string}")
     public void artist_leads_to(String expectedText) {
    	 String actualText= artistRegistration.verfiyPage4Text();
    	try {
    		Assert.assertTrue(actualText.contains(expectedText),
    				"Expected Text: " + expectedText + "But got: " +actualText);
    	}catch(AssertionError e) 
    	{
    	screenshotUtility.takescreenshot(driver, actualText);	
    	throw e;
    	}
     }
     
     @When("Artist fills following address details {string}, {string} and {string}")
     public void artist_fills_following_address_details(String address, String city, String zipCode) {
    	 artistRegistration.artistAddressFilling(address, city, zipCode);
     }
     
     @Then("verfies {string}")
     public void verfies(String expectedText) {
    	 String ActualText= artistRegistration.verfiyPage5Element();
    	 
    	 try {
    		 Assert.assertEquals(ActualText, expectedText,
    				 "Expected Text: " + expectedText + "But got: " + ActualText); 
    	 } catch(AssertionError e)
    	 {
    	    	screenshotUtility.takescreenshot(driver, ActualText);	
    	    	throw e;
    	 }
     }
     
     @When("Artist uploads {string}")
     public void artist_uploads(String profilePicture) {
    	 artistRegistration.uploadArtistProfilePicture(profilePicture);
     }
     @Then("Goes to next page {string}")
     public void goes_to_next_page(String pageName) {
    	 String ActualText= artistRegistration.verfiyPage6Element();
    	 
    	 try {
    		 Assert.assertEquals(ActualText, pageName,
    				 "Expected Text: " + pageName + "But got: " + ActualText); 
    	 } catch(AssertionError e)
    	 {
    	    	screenshotUtility.takescreenshot(driver, ActualText);	
    	    	throw e;
    	 }
     }

    
     
     @When("Artist fills his {string}")
     public void artist_fills_his_service_overview(String serviceOverview) {
    	 artistRegistration.fillServiceOverview(serviceOverview);
     }
     
     @Then("Artist need to verfiy {string}")
     public void artist_need_to_verify_page(String pageName) {
    	 String ActualText= artistRegistration.verfiyPage7Element();
    	 
    	 try {
    		 Assert.assertEquals(ActualText, pageName,
    				 "Expected Text: " + pageName + "But got: " + ActualText); 
    	 } catch(AssertionError e)
    	 {
    	    	screenshotUtility.takescreenshot(driver, ActualText);	
    	    	throw e;
    	 }
     }
    
     @When("Artist fills professional details {string}, {string}, {string}, {string}")
     public void artist_fills_professional_details(String phoneNumber, String email, String ssnNumber, String docName) {
    	 artistRegistration.fillAirtistsProfessionalDetails(phoneNumber, email, ssnNumber, docName);
     }
     
     @Then("Artist to verfiy {string}")
     public void artist_to_verfiy(String pageName) {
    	 String ActualText= artistRegistration.verfiyPage8Element();
    	 
    	 try {
    		 Assert.assertEquals(ActualText, pageName,
    				 "Expected Text: " + pageName + "But got: " + ActualText); 
    	 } catch(AssertionError e)
    	 {
    	    	screenshotUtility.takescreenshot(driver, ActualText);	
    	    	throw e;
    	 }
     }
     @When("Artist enters his social profiles such as {string}, {string}, {string} and {string}")
     public void artist_enters_his_social_profiles_such_as(String youtube, String insta, String twitter, String fb) {
    	 artistRegistration.fillartistSocialMediaLinks(youtube, insta, twitter, fb);
     }
     
     @Then("verfication of {string} should be done.")
     public void verfication_of_should_be_done(String string) {
    	 String ActualText= artistRegistration.verfiyPage9Element();
    	 
    	 try {
    		 Assert.assertEquals(ActualText, string,
    				 "Expected string Text: " + string + "But got: " + ActualText); 
    	 } catch(AssertionError e)
    	 {
    	    	screenshotUtility.takescreenshot(driver, ActualText);	
    	    	throw e;
    	 } 
     }

     @When("Artist selects a Plan")
     public void artist_selects_a_plan() {
    	 artistRegistration.artistSelectPlan();
     }

     @Then("artist verfies his {string}")
     public void artist_verfies_his(String registeredEmail) {
    	 String ActualText= artistRegistration.verfiyPage9Element();
    	 
    	 try {
    		 Assert.assertEquals(ActualText, registeredEmail,
    				 "Expected registered Email: " + registeredEmail + "But got: " + ActualText); 
    	 } catch(AssertionError e)
    	 {
    	    	screenshotUtility.takescreenshot(driver, ActualText);	
    	    	throw e;
    	 } 
     }

 

     
     
     
     
     }

     

