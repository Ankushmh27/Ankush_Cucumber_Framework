package com.hotelcrm.PageObject;

import com.hotelcrm.Utilities.utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class hotelCRM_OrganizationPage extends utility
{
    WebDriver driver;
    //Basic information
    @FindBy(xpath = "//span[.='Organizations']")
    WebElement organizationButton;

    @FindBy(xpath = "//a[.='Add']")
    WebElement addButton;

    @FindBy(id = "Name")
    WebElement name;

    @FindBy(id = "Logo_File")
    WebElement organizationLogo;

    @FindBy(xpath = "//span[@id='select2-ParentId-container']")
    WebElement selectAnParentOption;
    @FindBy(xpath = "//li[.='SUN DOWN']")
    WebElement selectSunDownOption;

    @FindBy(xpath = " //span[contains(@class,'select2 select2-container select2-container--default " +
            "select2-container--b')]//span[@class='select2-selection__rendered']")
    WebElement assignGroup;
    @FindBy(xpath = "//li[text()='Town motel Org group']")
    WebElement selectAssignGroupOption;

    @FindBy(id = "TagLine")
    WebElement tagLine;

    @FindBy(id = "Website")
    WebElement website;

    @FindBy(xpath = "//span[text()='Active']")
    WebElement status;
    @FindBy(xpath = "//li[@class='select2-results__option']")
    WebElement selectActiveStatus;

    @FindBy(xpath = "//li[text()='InActive']")
    WebElement selectInactiveStatus;
    @FindBy(xpath = "//span[@id='select2-TimezoneId-container']")
    WebElement timeZone;

    @FindBy(xpath = "//span[@title='India Standard Time']")
    WebElement selectIST;

    //Location information
    @FindBy(xpath = "//span[@id='select2-Location_CountryId-container']")
    WebElement country;

    @FindBy(xpath = "//li[text()='India']")
    WebElement selectCountry;
    @FindBy(xpath = "//span[contains(@class,'select2 select2-container select2-container--default s')]" +
            "//span[@class='select2-selection__placeholder']")
    WebElement state;

    public hotelCRM_OrganizationPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickonOrganization()
    {
        clickOn(organizationButton);
        clickOn(addButton);
    }

    public void fillBasicInfoDetails(String org_Name)
    {
        sendKey(name,org_Name);
        clickOn(organizationLogo);
        sendKey(organizationLogo,"/home/software3/Pictures/Screenshots/Screenshot from 2023-10-17 10-47-57.png");
        selectOption(selectAnParentOption, selectSunDownOption);    
    }
}
