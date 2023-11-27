package com.hotelcrm.Utilities;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import com.hotelcrm.BaseClass.baseSetup;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class utility extends baseSetup
{
	public  WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
	public static SoftAssert softassert;

	public String getText(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		String text = element.getText();
		return text;
	}
	
	public static void sendKey(WebElement element, String value)
	{
		element.sendKeys(value);
	}
	
	public void click(WebElement element, WebDriver driver)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void selectDropDownByText(WebElement dropdown, String text)
	{
		wait.until(ExpectedConditions.visibilityOf(dropdown));
		Select select= new Select(dropdown);
		select.selectByVisibleText(text);
	}
	public void selectDropDownByValue(WebElement dropdown, String value)
	{
		wait.until(ExpectedConditions.visibilityOf(dropdown));
		Select select= new Select(dropdown);
		select.selectByValue(value);
	}
	
	public void alertAccept(WebDriver driver) throws Exception
	{
		Alert alert = driver.switchTo().alert();
		sleep(2000);
		alert.accept();
	}

	public static void clickOn(WebElement element)
	{
		element.click();
	}
	
	public static void actions(WebDriver driver, WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void ScrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView", element);
	}
	
	public static void selectOption(WebElement dropdown, WebElement optionToSelect)
	{
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", dropdown);
		jsExecutor.executeScript("arguments[0].click();", optionToSelect);
	}

	public static void assertEqual(String actual,String expected ,String message) throws InterruptedException
	{
		softassert = new SoftAssert();
		softassert.assertEquals(actual,expected,message);
		softassert.assertAll();
	}
	public static void assertTrue(boolean result) throws InterruptedException
	{
		softassert.assertTrue(result);
		softassert.assertAll();
	}
	
	public static void implicitWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	}

	public static void explicitWait(WebDriver driver, int time, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForElementPresent(WebDriver driver, int time, By element)
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(time));
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
		}
		catch(Exception e) {
			System.out.println("some error occurred while waiting for the element" + element.toString());
		}
	}
	
	public static void sleep(int timout) throws InterruptedException
	{
		Thread.sleep(timout);
	}
	
	public static String configReader(String key) throws IOException{
		Properties prop = new Properties();
		FileInputStream myFile;
		myFile = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/configurations.properties");
		prop.load(myFile);
        return prop.getProperty(key);
	}

	public static String getScreenShotPath(String TestName) throws IOException, AWTException
	{
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "/Screenshot/" + TestName + utility.timeStamp()
				+ ".png";
		File file = new File(destPath);
		FileUtils.copyFile(source, file);
		return destPath;
	}
	
	public static String timeStamp()
	{
		DateFormat dateFormat = new SimpleDateFormat("ddMMYY-HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}
}
