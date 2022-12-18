package by.a1qa.task3_1.element;

import by.a1qa.task3_1.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BaseElement {
    private By locator;
    private String elementName;

    public BaseElement(By locator, String elementName){
        this.locator = locator;
        this.elementName = elementName;
    }

    public By getLocator() {
        return locator;
    }

    public String getElementName() {
        return elementName;
    }

    protected WebElement findElement(By locator){
        return Driver.getDriver().findElement(locator);
    }

    public boolean isDisplayed() {
        return !Driver.getDriver().findElements(locator).isEmpty();
    }
    public void click(){
        findElement(locator).click();
    }

    public String getText(){
        return findElement(locator).getText();
    }

}
