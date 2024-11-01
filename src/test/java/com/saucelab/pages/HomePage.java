package com.saucelab.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id= "login-button")
    WebElement loginButt;

    @FindBy(css = "h3[data-test='error']")
    WebElement errorMsg;


    public void navigateToHomePage(){
        BasePage.launchUrl();
    }

    public void enterUserName(String name){
        usernameField.clear();
        usernameField.sendKeys(name);

    }

    public void enterPassword(String password){

        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public ProductsPage clickOnLogin(){

        BasePage.waitForElementToBeClickable(loginButt);
        loginButt.click();

        return new ProductsPage(driver);
    }

    public void getPageTitle(){

        String errorTxt = errorMsg.getText();
        Assert.assertTrue(errorTxt.contentEquals
                ("Epic sadface: Username and password do not match any user in this service"));
        System.out.println("    - Error msg  " + errorTxt);

    }



}
