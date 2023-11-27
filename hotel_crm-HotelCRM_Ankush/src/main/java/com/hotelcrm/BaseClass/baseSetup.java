package com.hotelcrm.BaseClass;

import java.io.IOException;
import java.time.Duration;
import com.hotelcrm.Utilities.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class baseSetup 
{
	protected static WebDriver driver;
	
	@BeforeTest
	@Parameters("browser")
	public static void setupBrowser(String browser) throws IOException
	{
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("This Browser is not found in your system");
		}
		driver.get(utility.configReader("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
	}

	@AfterTest
	public static void tearDown() throws IOException
	{
		driver.close();
		driver.quit();
	}

	public static void launchBrowser() throws IOException
	{
		String browser=utility.configReader("browser");

		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else {
			System.out.println("browser not found!");
		}
		driver.get(utility.configReader("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(6000));
	}

	public static void closeBrowser() throws IOException
	{
		driver.close();
		driver.quit();
	}
}
