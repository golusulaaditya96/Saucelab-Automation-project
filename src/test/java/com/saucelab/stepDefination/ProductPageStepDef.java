package com.saucelab.stepDefination;

import com.saucelab.pages.BasePage;
import com.saucelab.pages.Cartpage;
import com.saucelab.pages.HomePage;
import com.saucelab.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class ProductPageStepDef extends BasePage {

    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
    ProductsPage productsPage = PageFactory.initElements(driver, ProductsPage .class);
    Cartpage cartPage = PageFactory.initElements(driver, Cartpage .class);

    @Given("I log in as standard user using {string} and {string}")
    public void iLogInAsStandardUserUsingAnd(String name, String password) {

        homePage.navigateToHomePage();

        System.out.println("   - Entering userName");
        homePage.enterUserName(name);

        System.out.println("   - Entering password");
        homePage.enterPassword(password);

        System.out.println("   - clicking on login button");
        productsPage = homePage.clickOnLogin();
    }


    @When("I click on filter icon")
    public void iClickOnFilterIcon() {

        System.out.println("   - product sort button");
        productsPage.sortProductByNameDesc();
    }



    @Then("Item should be in descending order")
    public void itemShouldBeInDescendingOrder() {
        System.out.println("   - Inventory Red T-shirt");
        productsPage.verifyInverntoryOrder();

    }

    @And("product name is ordered in descending")
    public void productNameIsOrderedInDescending() throws Exception {
        System.out.println("   - product sort button");
        productsPage.selectNamesInDecOrder();
    }

    @And("I add item to cart")
    public void iAddItemToCart() throws InterruptedException {
        System.out.println("   - add to cart");
        productsPage.clickOnItem();


    }

    @And("I click on Shopping cart badge")
    public void iClickOnShoppingCartBadge() {
        System.out.println("   - cart ");
        cartPage = productsPage.clickOnCart();

    }


    @Then("I logout")
    public void iLogout() {
        System.out.println("   - logout ");
        productsPage.logout();

    }
}







