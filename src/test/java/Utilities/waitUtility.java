package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitUtility 
{

	public static void waitForElementVisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));	
	}
	
	public static void waitForPageLoad(WebDriver driver ) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
	}
	
	public static void waitForElementClickable(WebDriver driver, WebElement element)
	{
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void checkError(WebDriver driver, WebElement errorElement)
	{
		new WebDriverWait(driver, Duration.ofSeconds(10))
	.until(ExpectedConditions.visibilityOf(errorElement))
	.getText().trim();
	}
	
}

