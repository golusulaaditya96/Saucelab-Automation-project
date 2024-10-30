package com.saucelab.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/java/com/saucelab/featureFiles"},
        glue = {"src/test/java/com/saucelab/hooks", "src/test/java/com/saucelab/stepDefination"},
        publish = true
)
public class Runner {
}
