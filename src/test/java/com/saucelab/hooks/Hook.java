package com.saucelab.hooks;

import com.saucelab.commons.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Configuration;

import java.io.File;
import java.io.IOException;

public class Hook extends Browser {

    @Before
    public void setUp(Scenario scenario)
    {
        try {
            launchBrowser(new Configuration().getPropertiesParameter("browser"));
            System.out.println("    - SCENARIO NAME: " + scenario.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) {

        try {

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray((src));
            scenario.attach(fileContent, "image/png", scenario.getName());
            scenario.log("ScreenShot attached");

        } catch (Exception e){
            System.out.println("can't take screen shots");
        }

              closeBrowser();
    }




}



