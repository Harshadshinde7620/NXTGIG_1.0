package Utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alertUtil {

	public static String getAlertText(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert= driver.switchTo().alert();
        String text = alert.getText().trim();
		return text;
	}
	
	public static void acceptAlert(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert= driver.switchTo().alert();
		alert.accept(); //This Clicks on OK Button
	}
	
	public static void declinAlert(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert= driver.switchTo().alert();
		alert.dismiss();//This click on cancle button
	}
}
