package pages;


import generics.PageActions;
import generics.Waits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends PageBaseClass {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//ul[@class='itemOptions']")
    WebElement itemDetailsSection;

    @FindBy(xpath = "//span[@class='value']")
    WebElement itemNumberOnCart;

    @FindBy(className = "subItemPrice")
    WebElement warrantyPrice;


    public String getSubItemPriceOnCart()
    {
        wait.setSpecificWait(driver,(long)20)
                .until(ExpectedConditions.elementToBeClickable(warrantyPrice));

        return actions.gotoSection(warrantyPrice).getText();
    }

    public String getItemNumberInCart()
    {
       actions.gotoSection(itemDetailsSection);
       return actions.gotoSection(itemNumberOnCart).getText();
    }
}
