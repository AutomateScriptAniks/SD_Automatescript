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
    WebElement close;

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



    public String getItemNumber()
    {
        return new PageActions(driver).gotoSection(itemNumber).getText();
    }


    public void checkReviews()
    {
        actions.clickOn(review);
    }

    public List<WebElement> getProductOptionList()
    {
        List<WebElement> productOptionList= actions.getListFrom(productOptions,By.tagName("li"));
        return productOptionList;
    }

    public void selectProductOptions() throws InterruptedException {
        actions.clickOn(bedSizeDropDown);
        wait.setSpecificWait(driver,(long)10)
                .until(ExpectedConditions.elementToBeClickable(bedSize));
        actions.clickOn(bedSize);

        wait.setSpecificWait(driver,(long)10)
                .until(ExpectedConditions.elementToBeClickable(storageOptionDropDown));
        actions.clickOn(storageOptionDropDown);
        wait.setSpecificWait(driver,(long)10)
                .until(ExpectedConditions.elementToBeClickable(strorageOption));
        actions.clickOn(strorageOption);

        wait.setSpecificWait(driver,(long)10)
                .until(ExpectedConditions.elementToBeClickable(colorOption));
        actions.clickOn(colorOption);

        wait.setSpecificWait(driver,(long)10)
                .until(ExpectedConditions.elementToBeClickable(insuranceDropDown));
        actions.clickOn(insuranceDropDown);
        wait.setSpecificWait(driver,(long)10)
                .until(ExpectedConditions.elementToBeClickable(warranty));
        actions.clickOn(warranty);
    }

    public void creditMessaging() throws InterruptedException {
        Thread.sleep(2000);
        wait.setSpecificWait(driver,(long)10)
                .until(ExpectedConditions.elementToBeClickable(creditMessaging));
        actions.clickOn(creditMessaging);
        actions.gotoSection(creditMsgDialog);
        creditMsgDialog.findElement(By.cssSelector("a[class='ui-dialog-titlebar-close ui-corner-all']")).click();
    }

    public String paymentBed()
    {
        return actions.gotoSection(payment).getText();
    }

    public String getSubItemPrice()
    {
        wait.setSpecificWait(driver,(long)20)
                .until(ExpectedConditions.visibilityOf(warrantyPrice));

        return actions.gotoSection(warrantyPrice).getText();
    }

    public void addTOCart() throws InterruptedException {

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
