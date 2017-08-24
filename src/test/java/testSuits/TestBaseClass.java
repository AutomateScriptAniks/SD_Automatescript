package testSuits;
import generics.SetDriverCapabilities;
import generics.Waits;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.HomePage;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

public abstract class TestBaseClass {

    protected WebDriver driver;

   @Parameters("browser")
    @BeforeMethod
    public void init(String browser)
    {
        driver = new SetDriverCapabilities().setWebDriverCapabilites(browser);
        driver.manage().deleteAllCookies();
        new Waits(driver).setUniversalImplicitWait((long) 10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}