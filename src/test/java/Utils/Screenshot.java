package Utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BaseDriver.Basepage;

public class Screenshot extends Basepage{
	
	public void screenshot(String filename) throws Exception {

		Date dt = new Date();
		DateFormat dtformat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Sanityscreenshots" + dtformat.format(dt) + filename + ".jpg"));

	}

}
