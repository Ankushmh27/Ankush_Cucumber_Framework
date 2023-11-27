package com.hotelcrm.Stepdefination;

import com.hotelcrm.BaseClass.baseSetup;
import com.hotelcrm.PageObject.hotelCRM_LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.awt.*;
import java.io.IOException;
import static com.hotelcrm.Utilities.utility.assertEqual;
import static com.hotelcrm.Utilities.utility.sleep;

public class hotelCRM_LoginSteps extends baseSetup
{
	hotelCRM_LoginPage login;
	
	@Given("Super admin open the hotel crm application")
	public void openApplication() throws IOException
	{
		System.out.println("Super admin open the application");
	}
	
	@When("Super admin enters the {string} and {string}")
	public void superAdminEntersUsernameAndPassword(String username, String password) throws InterruptedException, IOException, AWTException
	{
		login = new hotelCRM_LoginPage(driver);
		login.enter_Username_and_Password(username,password);
		sleep(500);
	}
	
	@And("Super admin click on the login button")
	public void loginApplication() throws InterruptedException, IOException, AWTException {
		login.rememberMe();
		sleep(500);

		login.clickOnLoginButton();
		sleep(1000);
	}
	
	@Then("Super admin Verify Page Title and logout from the application")
	public void logoutApplication() throws InterruptedException, IOException, AWTException
	{
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "Dashboard | Patel Processing";
		assertEqual(actualPageTitle,expectedPageTitle,"Super admin not able to login the application or PageTitle not matched!");

		login.clickOnLogoutButton();
		sleep(700);

		String actualPageTitleAfterLogout= driver.getTitle();
		String expectedTitleAfterLogout = "Login | Patel Processing";
		assertEqual(actualPageTitleAfterLogout,expectedTitleAfterLogout,"Super admin not able to logout the application or PageTitle not matched!");
	}
	
	@Then("Verify the error message on screen")
	public void verifyErrorMessage() throws InterruptedException, IOException, AWTException
	{
		login.verifyErrorMessage();
		sleep(1000);
	}
}
