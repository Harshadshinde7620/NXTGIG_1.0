package stepDefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hooks {

	public static WebDriver driver = null;
    
    @Before // This will run before every Scenario
    public void browserSetup() {
    System.out.println("I am inside the application");

    // Setup ChromeDriver using WebDriverManager (important for Selenium 4+)
    WebDriverManager.chromedriver().setup();
    
    driver= new ChromeDriver();
    
    driver.get("http://18.191.214.63:8090/");
    
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    
    }
	
	
    @After
    public void teardown()
    {
        System.out.println("I am inside the teardown");
        if (driver != null) {
           // driver.quit(); // closes all browser windows and ends session
        }
    
    }
}
