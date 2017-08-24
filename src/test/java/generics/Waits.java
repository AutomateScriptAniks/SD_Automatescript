package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageBaseClass;

import java.util.concurrent.TimeUnit;

public class Waits  {

    private WebDriver driver;
    private WebDriverWait specificWait;

    public Waits(WebDriver driver) {
        this.driver=driver;
    }

    public void setUniversalImplicitWait(Long duration, TimeUnit unit)
    {
        driver.manage().timeouts().implicitlyWait(duration, unit);
    }

    public WebDriverWait setSpecificWait(WebDriver driver,Long time)
    {
        specificWait = new WebDriverWait(driver,time);
        return specificWait;
    }
}
