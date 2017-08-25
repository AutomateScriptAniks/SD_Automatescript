package generics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.PageBaseClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageActions {
    private WebDriver driver;
    private Select dropDown;
    private Actions action;
    private JavascriptExecutor jse;

    public PageActions(WebDriver driver) {
       this.driver=driver;
       this.action=new Actions(driver);
    }

    public void navigateToUrl(String url)
    {
        driver.get(url);
    }

    public void mouseHover(WebElement element)
    {
        action.moveToElement(element).build().perform();
    }

    public void clickOn(WebElement element)
    {
        element.click();
    }

    public void enterText(WebElement element,String text)
    {
        element.sendKeys(text);
    }

    public void clearText(WebElement element)
    {
        element.clear();
    }

    public WebElement gotoSection(WebElement element)
    {
        return element;
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public void selectFromDropDown(WebElement element,String option)
    {
        dropDown = new Select(element);
        dropDown.selectByVisibleText(option);
    }

    public List<WebElement> getListFrom(WebElement from, By locator)
    {
        List<WebElement> elements = from.findElements(locator);
        return elements;
    }

    public void switchToFrameByName(String name)
    {
        driver.switchTo().frame(name);
    }

    public void actionToMakeElementVisible(WebDriver driver,WebElement element) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);

    }

    public void scrollUp(WebDriver driver) {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,-400);");

    }

    public void forcefullyClickInSection(WebDriver driver,WebElement element,By by)
    {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element.findElement(by));
    }

    public void forcefullyClick(WebDriver driver,WebElement element)
    {
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
    }

}
