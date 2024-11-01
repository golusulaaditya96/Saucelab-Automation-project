package com.saucelab.stepDefination;

import com.saucelab.pages.BasePage;
import com.saucelab.pages.Cartpage;
import com.saucelab.pages.HomePage;
import com.saucelab.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;

public class CartPageStepDef extends BasePage {


    Cartpage cartpage = PageFactory.initElements(driver, Cartpage.class);

    @Then("I should see the items in my cart")
    public void iShouldSeeTheItemsInMyCart() {

        System.out.println("   - cart page displayed");
        cartpage.verifyCheckOutBttn();
    }

    @And("I remove an item")
    public void iRemoveAnItem() {
        System.out.println("   - rm item");
        cartpage.removeItem();


    }

    @Then("I have {int} item in my cart")
    public void iHaveItemInMyCart(int arg0) {
    }
}
