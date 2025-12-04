package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class takeScreenshot {

public static String takeScreenshot(WebDriver driver, String screenshotName) {
	//Timestamp for unique file name		
	String timeStamp= new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	
	//Take Screenshot
	File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	//Path for screenshot
	String destPath= System.getenv("user.dir") + "/screenshots/" + screenshotName + "_" + timeStamp + ".png";
	
	try {
		FileUtils.copyFile(srcFile , new File(destPath));
		System.out.println("Screenshot saved at:" + destPath);
	} catch (IOException e){
		System.out.println("Failed to save screenshot: " + e.getMessage());
	}
	
	return destPath;
}
}
