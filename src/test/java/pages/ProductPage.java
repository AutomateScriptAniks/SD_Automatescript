package pages;


import generics.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends PageBaseClass {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(className="addedToBasketCatNo")
    WebElement itemNumber;

    @FindBy(className = "bvReviewsNumber")
    WebElement review;


    @FindBy(xpath= "//label[@for='STORAGE OPTION-4 Drawers']")
    WebElement strorageOption;

    @FindBy(id= "sku17110179")
    WebElement warranty;

    @FindBy(xpath= "//label[@for='BED SIZE-Double']")
    WebElement bedSize;

    @FindBy(xpath="//img[@rel='SANDSTONE' and @alt='SANDSTONE']")
    WebElement colorOption;

    @FindBy(id="addToBasketButton")
    WebElement addToBasket;

    @FindBy(linkText = "Go to basket")
    WebElement goToBasketButton;

    @FindBy(className = "productOptionsList")
    WebElement productOptions;

    @FindBy(xpath =  "//a[@class='sTCDialogBtn' and text()='Spread the cost']")
    WebElement creditMessaging;

    @FindBy(css="div[class='ui-dialog ui-widget ui-widget-content ui-corner-all creditFlatLW']")
    WebElement creditMsgDialog;

    @FindBy(css="a[class='ui-dialog-titlebar-close ui-corner-all']")
    WebElement closeNone;

    @FindBy(className = "paymentTotal")
    WebElement payment;

    @FindBy(className = "subItemPrice")
    WebElement warrantyPrice;

    @FindBy(xpath = "//span[@class='original' and text()='Bed size']")
    WebElement bedSizeDropDown;

    @FindBy(xpath = "//span[@class='original' and text()='Storage option']")
    WebElement storageOptionDropDown;

    @FindBy(xpath = "//span[@class='original' and @rel='Furniture Insurance']")
    WebElement insuranceDropDown;

    @FindBy(id = "sTCListOne")
    WebElement creditMessagingBeforeProduct;

    @FindBy(className = "totalPriceFigure")
    WebElement updatedPrice;

    @FindBy(xpath = "//span[contains(@class,'fullCashPrice')]")
    WebElement updatedPriceOnCreditMessagingDialog;



    public String getItemNumber()
    {
        return new PageActions(driver).gotoSection(itemNumber).getText();
    }


    public void checkReviews()
    {
        actions.clickOn(review);
    }

    public void selectProductOptions() throws InterruptedException {
        actions.scrollUp(driver);
        actions.forcefullyClick(driver,bedSizeDropDown);
        wait.setSpecificWait(driver,(long)10)
                .until(ExpectedConditions.elementToBeClickable(bedSize));
        actions.actionToMakeElementVisible(driver,bedSize);
        actions.clickOn(bedSize);
        actions.forcefullyClick(driver,storageOptionDropDown);
        wait.setSpecificWait(driver,(long)10)
                .until(ExpectedConditions.elementToBeClickable(strorageOption));
        actions.clickOn(strorageOption);
        actions.clickOn(colorOption);
        actions.forcefullyClick(driver,insuranceDropDown);
        actions.forcefullyClick(driver,warranty);
    }

    public String goToCreditmessagingAfterSelectingProduct() throws InterruptedException {
        Thread.sleep(1000);
        actions.mouseHover(creditMessaging);
        actions.clickOn(creditMessaging);
        actions.gotoSection(creditMsgDialog);
        String productPrice = actions.gotoSection(updatedPrice).getText();
        WebElement close = creditMsgDialog.findElement(By.cssSelector("a[class='ui-dialog-titlebar-close ui-corner-all']"));
        actions.forcefullyClick(driver,close);
        return productPrice;
    }

    public String getUpdatedPrice()
    {
        return actions.gotoSection(updatedPrice).getText();
    }

    public String getSubItemPrice()
    {
        wait.setSpecificWait(driver,(long)20)
                .until(ExpectedConditions.visibilityOf(warrantyPrice));

        return actions.gotoSection(warrantyPrice).getText();
    }

    public void addTOCart() throws InterruptedException {
        actions.mouseHover(addToBasket);
        actions.clickOn(addToBasket);
    }

    public ShoppingCartPage confirmAddToBasket()
    {
     wait.setSpecificWait(driver,(long)20)
            .until(ExpectedConditions.elementToBeClickable(goToBasketButton));
            actions.clickOn(goToBasketButton);

        return new ShoppingCartPage(driver);
    }
}
