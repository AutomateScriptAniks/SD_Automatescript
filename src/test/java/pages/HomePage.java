package pages;

import generics.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends PageBaseClass {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "navHome")
    WebElement topNavHome;

    @FindBy(linkText = "Beds")
    WebElement topNavColBeds;

    @FindBy(linkText = "My Account")
    WebElement myAccountButton;


    public ProductListing chooseProduct()
    {
        actions.mouseHover(topNavHome);
        actions.clickOn(topNavColBeds);

        return new ProductListing(driver);
    }

    public LoginPage goToMyAccount()
    {
        actions.clickOn(myAccountButton);

        return new LoginPage(driver);
    }

}
