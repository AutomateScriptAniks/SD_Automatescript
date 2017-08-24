package pages;

import generics.PageActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBaseClass {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "loginID")
    WebElement loginUserId;

    @FindBy(id = "loginPassword")
    WebElement loginPassword;

    @FindBy(id = "loginPostcode")
    WebElement loginPostCode;

    @FindBy(id = "existingCustomerSubmitButton")
    WebElement loginButton;

    public HomePage loginIn(String loginId,String password,String postCode)
    {
        actions.enterText(loginUserId,loginId);
        actions.enterText(loginPassword,password);
        actions.enterText(loginPostCode,postCode);
        actions.clickOn(loginButton);

        return new HomePage(driver);
    }

}
