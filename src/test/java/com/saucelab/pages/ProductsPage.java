package com.saucelab.pages;

import org.hamcrest.Factory;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product_label")
    WebElement productPgTitle;

    @FindBy(css = ".product_sort_container")
    WebElement productSortButt;

    @FindBy(className = "product_sort_container")
    WebElement productNamesInDec;

    @FindBy(id = "item_3_title_link")
    WebElement redTshirt;

    @FindBy(xpath = "//*[@id=\"inventory_container\"]/div/div[2]/div[3]/button")
    WebElement addBackPack;

    @FindBy(css = "#shopping_cart_container > a")
    WebElement cartButtn;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    @FindBy(className ="bm-burger-button")
    WebElement humburgerLink;

    public void getPageTitle(){

        String titlePgName = productPgTitle.getText();
        Assert.assertTrue(titlePgName.contentEquals("Products"));
        System.out.println("    - Product Page title is: " + titlePgName);

    }

    public void sortProductByNameDesc(){
        waitForElementToBeClickable(productSortButt);
        productSortButt.click();

    }

    public  void selectNamesInDecOrder() throws Exception
    {

        Select select = new Select(productNamesInDec);
        select.selectByIndex(1);
    }

    public void verifyInverntoryOrder(){

        String inventoryName = redTshirt.getText();
        Assert.assertTrue(inventoryName.contentEquals("Test.allTheThings() T-Shirt (Red)"));
        System.out.println("    - Product Page title is: " + inventoryName);

    }

    public void clickOnItem() throws InterruptedException {

        waitForElementToBeClickable(addBackPack);git
        addBackPack.click();
    }

    public Cartpage clickOnCart(){

        waitForElementToBeClickable(cartButtn);
        cartButtn.click();
        return new Cartpage(driver);
    }

    public void logout(){
        waitForElementToBeClickable(humburgerLink);
        logout.click();
    }




}
