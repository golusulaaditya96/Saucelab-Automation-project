package com.saucelab.hooks;

import com.saucelab.commons.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Configuration;

import java.io.IOException;

public class Hook extends Browser {

    @Before
    public void setUp()
    {
        try {
            launchBrowser(new Configuration().getPropertiesParameter("browser"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
