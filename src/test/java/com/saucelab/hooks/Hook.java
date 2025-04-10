package com.saucelab.hooks;

import com.saucelab.commons.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Configuration;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Hook extends Browser {

    private static final Logger logger = Logger.getLogger(Hook.class);
    // Create a ThreadLocal buffer for scenario-specific log messages
    private ThreadLocal<StringBuilder> logBuffer = ThreadLocal.withInitial(StringBuilder::new);


    @Before
    public void setUp(Scenario scenario) {
        StringBuilder sb = logBuffer.get();
        sb.append("Scenario: ").append(scenario.getName()).append("\n");
        try {
            // Launch browser based on configuration parameter
            String browserName = new Configuration().getPropertiesParameter("browser");
            sb.append("Launching browser: ").append(browserName).append("\n");
            launchBrowser(browserName);
        } catch (IOException e) {
            sb.append("Error launching browser for scenario: ").append(scenario.getName()).append("\n");
            logger.error("Error launching browser for scenario: " + scenario.getName(), e);
            throw new RuntimeException("Failed to launch browser", e);
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        StringBuilder sb = logBuffer.get();
        // Attempt to capture a screenshot and attach it to the scenario log
        try {
            if (driver != null) {
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                byte[] fileContent = FileUtils.readFileToByteArray(src);
                scenario.attach(fileContent, "image/png", scenario.getName());
                sb.append("Screenshot attached for scenario: ").append(scenario.getName()).append("\n");
            }
        } catch (Exception e) {
            sb.append("Unable to capture screenshot for scenario: ").append(scenario.getName()).append("\n");
            logger.error("Unable to capture screenshot for scenario: " + scenario.getName(), e);
        } finally {
            // Ensure the browser is closed even if screenshot fails
            try {
                closeBrowser();
                sb.append("Browser closed for scenario: ").append(scenario.getName()).append("\n");
            } catch (Exception e) {
                sb.append("Error closing browser for scenario: ").append(scenario.getName()).append("\n");
                logger.error("Error closing browser for scenario: " + scenario.getName(), e);
            }
        }
        // Write the entire scenario log block at once
        logger.info(sb.toString());
        logBuffer.remove();
    }
}
