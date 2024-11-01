package com.saucelab.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cartpage extends BasePage{

    public Cartpage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn_action.checkout_button")
    WebElement checkOutBttn;

    @FindBy(css=".btn_secondary.cart_button")
    WebElement removeBttn;


    public void verifyCheckOutBttn(){

        waitForElementToBeClickable(checkOutBttn);

        Assert.assertTrue(checkOutBttn.isEnabled());
    }

    public void removeItem(){
        waitForElementToBeClickable(removeBttn);
        removeBttn.click();


    }

}
