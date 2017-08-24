package pages;

import generics.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductListing extends PageBaseClass {

    public ProductListing(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id ="main")
    private WebElement mainSection;

    @FindBy(id ="productSortHeader")
    private WebElement sortingHeader;

    @FindBy(className = "productList")
    private WebElement productListingSection;

    @FindBy(id="endecaNavigation")
    WebElement leftNavigation;

    @FindBy(linkText = "Bedroom")
    WebElement bedroomLink;


    public ProductPage selectSpecificProduct(String option)
    {
        actions.gotoSection(leftNavigation);
        actions.clickOn(bedroomLink);
        actions.gotoSection(mainSection);
        actions.selectFromDropDown(sortingHeader,option);
        List<WebElement> productList = new PageActions(driver).getListFrom(productListingSection,By.tagName("li"));
        for (int i=0;i<=productList.size();i++)
        {
            productList.get(0).click();
            break;
        }

        return new ProductPage(driver);

    }

}
