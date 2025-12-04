package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenshotUtility {

	public static void takescreenshot(WebDriver driver, String fileName)
	{
		//The following commands temporarily saves the screenshot
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//now we define the target folder to store the screenshot
        File targetFolder = new File("target/screenshots/");
        if (!targetFolder.exists()) {
        	targetFolder.mkdirs();// create folder if it doesn't exist
        }
		
        try
        {
        	FileUtils.copyFile(src, new File(targetFolder, fileName + ".png"));	
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	
}
