package com.saucelab.stepDefination;

import com.saucelab.pages.BasePage;
import com.saucelab.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class HomePageStepDef extends BasePage {

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    @Given("I navigate to Sauce lab login page")
    public void i_navigate_to_sauce_lab_login_page() {
        homePage.navigateToHomePage();
      }

//    @Given("I navigate to Sauce lab login page")
//    public void i_navigate_to_sauce_lab_login_page() {
//
//        homePage.navigateToHomePage();
//    }

    @When("I enter a valid {string}")
    public void i_enter_a_valid(String string) {
    }

    @When("I click on Login")
    public void i_click_on_login() {
    }

    @Then("Sauce lab user logged in successfully")
    public void sauce_lab_user_logged_in_successfully() {
    }

}
