package com.hotelcrm.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.io.IOException;
import com.hotelcrm.Utilities.utility;

public class hotelCRM_LoginPage extends utility
{
	WebDriver driver;
	@FindBy(id = "UserIdentity")
	WebElement username;
	@FindBy(id = "Password")
	WebElement password;

	@FindBy(xpath = "//a[@href='javascript:0']")
	WebElement show_password;
	@FindBy(id = "IsRemember")
	WebElement remember_Me;

	@FindBy(id = "btnLogin")
	WebElement login;
	
	@FindBy(xpath = "//ul[@class='nav navbar-nav align-items-center ms-auto']//div[@class='d-flex align-items-center']")
	WebElement clickOnProfileIcon;
	@FindBy(xpath = "//a[contains(.,'Logout')]")
	WebElement logoutButton;

	@FindBy(xpath = "//p[.='Username and password does not matched!']")
	WebElement error_message;

	public hotelCRM_LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enter_Username_and_Password(String Username, String Password)throws IOException, AWTException, InterruptedException
	{
		sendKey(username,Username);
		sleep(200);
		sendKey(password,Password);
	}
	
	public void rememberMe() throws IOException, AWTException, InterruptedException
	{
		clickOn(show_password);
		boolean remember_me = remember_Me.isEnabled();
		if(remember_me)
		{
			remember_Me.click();
		} else {
			getScreenShotPath("rememberMe");
			System.out.println("Remember Me functionality not working");
		}
	}
	
	public void clickOnLoginButton() throws IOException, AWTException, InterruptedException
	{
		boolean loginButton = login.isEnabled();
		if(loginButton)
		{
			clickOn(login);
		} else
		{
			getScreenShotPath("login_btn_not_clickable");
		}
	}
	
	public void clickOnLogoutButton() throws InterruptedException, IOException, AWTException
	{
		clickOnProfileIcon.click();
		sleep(400);

		logoutButton.click();
		String login_page_url ="https://qa.patelhms.com/login";
		String current_url= driver.getCurrentUrl();
		if(login_page_url.equalsIgnoreCase(current_url))
		{
			System.out.println("Super admin navigated to : "+ current_url);
		} else {
			getScreenShotPath("Logout");
			System.out.println("Super Admin not on Login Page");
		}
	}
	
	public Object verifyErrorMessage()
	{
		String error =error_message.getText();
		System.out.println("Error message displayed on login page : "+ error);
		return error;
	}
}
