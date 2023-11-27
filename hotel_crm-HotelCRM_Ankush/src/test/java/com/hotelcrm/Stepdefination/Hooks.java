package com.hotelcrm.Stepdefination;

import com.hotelcrm.Utilities.utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.awt.*;
import java.io.IOException;
import static com.hotelcrm.BaseClass.baseSetup.closeBrowser;
import static com.hotelcrm.BaseClass.baseSetup.launchBrowser;

public class Hooks
    {
        @Before
        public void beforeScenario() throws IOException
        {
            launchBrowser();
        }
        @After
        public void afterScenario(Scenario scenario) throws IOException, AWTException {
            if(scenario.isFailed()) {
                scenario.attach(utility.getScreenShotPath(scenario.getName()+"_screenshots"), "png",scenario.getName());
            }
            closeBrowser();
        }
    }

