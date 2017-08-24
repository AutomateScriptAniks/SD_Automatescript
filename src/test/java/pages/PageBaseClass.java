package pages;

import generics.PageActions;
import generics.Waits;
import org.openqa.selenium.WebDriver;

public abstract class PageBaseClass {

    protected WebDriver driver;
    protected PageActions actions;
    protected Waits wait;


    public PageBaseClass(WebDriver driver)
    {
        this.driver=driver;
        this.actions = new PageActions(driver);
        this.wait = new Waits(driver);
    }


}
