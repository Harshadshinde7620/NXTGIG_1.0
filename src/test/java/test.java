import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

    public static WebDriver driver = null;

	public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

		//System.setProperty("WebDriver.chrome.driver", "");
		WebDriver driver= new ChromeDriver();
        
        driver.get("http://18.191.214.63:8090/");
        driver.manage().window().maximize();
        
        
        System.out.println(driver.getTitle());
        
        driver.findElement(By.xpath("//a[@class='menu__link']//button[@type='button'][normalize-space()='Join as Artist']")).click();
        
        System.out.println(driver.getTitle());
        
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
        WebElement drpdown= driver.findElement(By.xpath("//select[@id='artistRegistrationTalent']"));
		Select select= new Select(drpdown);
		select.selectByVisibleText("Characters, Impersonators & Entertainers");
		
        driver.findElement(By.xpath("//input[@id='artistRegistrationGig']")).sendKeys("Tampa");
        
    	driver.findElement(By.xpath("//button[normalize-space()='Start Getting Gigs']")).click();
    	
        System.out.println(driver.getTitle());


	}
	
}
