package by.a1qa.task3_1.element;

import by.a1qa.task3_1.util.CustomLogger;
import org.openqa.selenium.By;

public class Input extends BaseElement{

    public Input(By uniqueLocator, String elementName) {
        super(uniqueLocator, elementName);
    }

    public void sendText(String text){
        CustomLogger.info(this.getElementName() + ".sendText(): " + text);
        findElement(this.getLocator()).sendKeys(text);
    }

}
