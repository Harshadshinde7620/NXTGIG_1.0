package pageObjects;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.it.Date;

public class SearchFunctionality {
	WebDriver driver;
	
	//Constructor
	public SearchFunctionality(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);

	}
	
	//Elements
	By event_loc= By.xpath("//select[@id='searchArtistCategory']");
	By city_Loc= By.xpath("//select[@id='searchArtistCityCode']");
	By eventDate_Loc= By.xpath("//input[@id='searchArtistDate']");
	By singledayevent_btn= By.xpath("//input[@id='searchArtistSingleDayEvent']");
	By multipledayevent_btn= By.xpath("//input[@id='eventTypeMultiple']");
	By startMatching_btn= By.xpath("//button[normalize-space()='Start matching']");
	
	By numberofRegisteredArtist= By.xpath("//span[@class='cbbold']");
	By afterSearchEventText= By.xpath("//div[@class='cbbold font-2']");
	By artistList= By.xpath("//div[contains(@class,'p-3 mb-3 blue-border hov')]//div[contains(@class,'cbbold me-2')]");
	
	//Search Page Elements
	
	By searchEventName= By.xpath("//div[@class='col-md-4 col mb-md-0 mb-2']/select[@id='searchArtistCategory']");
	By searchDate= By.xpath("//div[@class='col-md-3 col mb-md-0 mb-2']/input[@id='searchArtistDate']");
	By searchEventCity= By.xpath("//div[@class='col-md-2 col mb-md-0 mb-2']/input[@id='searchArtistZipCode']");
	
	By searchProfilePic= By.xpath("//div[@class='d-md-flex align-items-center']//img[@src='http://18.191.214.63:8090/webroot/assets/image/']");
	
	//Action Methods
	public void singleDayEvent(String upcomingEvent, String city, String eventDate) {
		
		driver.findElement(singledayevent_btn).click();

		if (upcomingEvent != null && !upcomingEvent.isEmpty())
		{	
			WebElement eventDropdown= driver.findElement(event_loc);
			Select select= new Select(eventDropdown);
			select.selectByVisibleText(upcomingEvent);
		}
		
		if (city != null && !city.isEmpty())
		{
			WebElement cityDropdown= driver.findElement(city_Loc);
			Select select= new Select(cityDropdown);
			select.selectByVisibleText(city);
		}
		
		if (eventDate !=null && !eventDate.isEmpty())
		{
			driver.findElement(eventDate_Loc).clear();
			driver.findElement(eventDate_Loc).sendKeys(eventDate);
		}
		
		driver.findElement(startMatching_btn).click();
	}
	
	public void multipleDayEvent(String upcomingEvent, String city, String eventDate) {
		
		driver.findElement(multipledayevent_btn).click();
		
		if (upcomingEvent != null && !upcomingEvent.isEmpty())
		{	
			WebElement eventDropdown= driver.findElement(event_loc);
			Select select= new Select(eventDropdown);
			select.selectByVisibleText(upcomingEvent);
		}
		
		if (city != null && !city.isEmpty())
		{
			WebElement cityDropdown= driver.findElement(city_Loc);
			Select select= new Select(cityDropdown);
			select.selectByVisibleText(city);
		}
		
		if (eventDate !=null && !eventDate.isEmpty())
		{
			driver.findElement(eventDate_Loc).clear();
			driver.findElement(eventDate_Loc).sendKeys(eventDate);
		}
		
		driver.findElement(startMatching_btn).click();
	}

	public String getSearchResultText() {
	WebElement verficationText= driver.findElement(afterSearchEventText);
	return verficationText.getText().trim();	
	
	}
	
	public String verfiyNumberofRegisteredArtists()
	{
		WebElement artistsNumber_loc = driver.findElement(numberofRegisteredArtist);
		return artistsNumber_loc.getText().replace("(", "").replace(")", "").trim();
	
	}
	

	public List<String> ArtistsList() {

	List<WebElement> artists= driver.findElements(artistList);
	
	List<String> artistNames= new ArrayList<>();
	for (WebElement artist: artists)
	{
		String artistName= artist.getText().trim();
		artistNames.add(artistName);
		System.out.println("The name of artists are:" +artistName);
	}
	return artistNames;
	}
	
	public String getSearchedEvent()
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement eventDropdown= wait.until(ExpectedConditions.presenceOfElementLocated(searchEventName));

		Select select= new Select(eventDropdown);
	    wait.until(driver -> 
        !select.getFirstSelectedOption().getText().trim()
            .equalsIgnoreCase("What do you need for your upcoming event?")
    );
		
		return select.getFirstSelectedOption().getText().trim();
	}
	
	
	public String getSerachedEventCity()
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement eventCityDopdown= wait.until(ExpectedConditions.presenceOfElementLocated(searchEventCity));

		Select select=  new Select(eventCityDopdown);
		return select.getFirstSelectedOption().getText().trim();
	}
	
	
	public String getSearchedEventDate()
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));		
		WebElement eventDate= wait.until(ExpectedConditions.presenceOfElementLocated(searchDate));
		
		String rawData= eventDate.getAttribute("value").trim();
		
		//convert yyyy-MM-dd to dd/MM/yy
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

	    LocalDate date = LocalDate.parse(rawData, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); // → 20/09/2025
		
	}
	
	public void updateSearchpagefields(String updateEventField, String updateEventCity, String updateEventDate) throws InterruptedException
	{
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    Thread.sleep(10);
		    // Update Event Dropdown
		    WebElement eventDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(searchEventName));
		    Select eventSelect = new Select(eventDropdown);
		    eventSelect.selectByVisibleText(updateEventField);

		    // Update City Dropdown
		    //WebElement cityDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(searchEventCity));
		    //Select citySelect = new Select(cityDropdown);
		    //citySelect.selectByVisibleText(updateEventCity);

		    // Update Date Field
		    WebElement dateField = wait.until(ExpectedConditions.presenceOfElementLocated(searchDate));
		    dateField.clear();
		    dateField.sendKeys(updateEventDate);
		    dateField.sendKeys(Keys.TAB); // trigger validation if needed
		}

	public void verfiyProfilePic()
	{
		/*WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pic= wait.until(ExpectedConditions.visibilityOfElementLocated(searchProfilePic));
		
		if (pic.isDisplayed()) {
		System.out.println("Profile pics are displayed");
		}
		else
		{
		System.out.println("Profile pics are not displayed");
		}*/
		
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement pic = wait.until(ExpectedConditions.visibilityOfElementLocated(searchProfilePic));

		    Boolean imageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript(
		        "return arguments[0].complete && arguments[0].naturalWidth > 0", pic);

		    if (imageLoaded) {
		        System.out.println("Profile picture loaded and displayed correctly.");
		    } else {
		        System.out.println("Profile picture is broken or not loaded.");
		    
		}

		
	}
	

}

