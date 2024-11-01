package com.saucelab.stepDefination;


import com.saucelab.pages.BasePage;
import com.saucelab.pages.HomePage;
import com.saucelab.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class HomePageStepDef extends BasePage {

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage .class);

    @Given("I navigate to Sauce lab login page")
    public void i_navigate_to_sauce_lab_login_page() {
        homePage.navigateToHomePage();
    }


    @When("I enter a valid user {string}")
    public void i_enter_a_valid_user(String name) {
        System.out.println("   - Entering userName");
        homePage.enterUserName(name);
    }

    @When("I enter a valid password {string}")
    public void i_enter_a_valid_password(String password) {
        System.out.println("   - Entering password");
        homePage.enterPassword(password);
    }

    @When("I click on Login")
    public void i_click_on_login() {

        System.out.println("   - clicking on login button");
        productsPage = homePage.clickOnLogin();
    }

    @Then("product page is displayed")
    public void productPageIsDisplayed() {
        System.out.println("   - validating user credentials");
         productsPage.getPageTitle();
    }

    @When("I enter user name {string}")
    public void iEnterUserName(String user_name) {

        System.out.println("   - Entering userName");
        homePage.enterUserName(user_name);

    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        System.out.println("   - Entering password");
        homePage.enterPassword(password);

    }

    @Then("User not able to login")
    public void userNotAbleToLogin() {

        System.out.println("   - validating user credentials");
        homePage.getPageTitle();

    }


}
