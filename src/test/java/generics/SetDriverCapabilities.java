package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import pages.PageBaseClass;
import utils.PropertyReader;

import java.io.File;

public class SetDriverCapabilities  {

    private WebDriver driver;

    public WebDriver setWebDriverCapabilites(String browser)
    {
        String chooseBrowser = browser.toLowerCase();

        if (chooseBrowser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",
                    new File(PropertyReader.readProperty("path.chromeDriver"))
                            .getAbsolutePath());
            driver = new ChromeDriver();

        }
        else if (chooseBrowser.equals("headless"))
        {
                driver = new SafariDriver();
        }
        else
        {
            throw new IllegalArgumentException("Invalid browser value!!");
        }

        return driver;
    }


}
