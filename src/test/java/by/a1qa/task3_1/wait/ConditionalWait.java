package by.a1qa.task3_1.wait;

import by.a1qa.task3_1.driver.Driver;
import by.a1qa.task3_1.element.BaseElement;
import by.a1qa.task3_1.util.ConfigManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConditionalWait {

    private static int seconds = ConfigManager.getWaitDurationInSeconds();
    private static Duration duration = Duration.ofSeconds(seconds);

    public static void waitToBeClickable(BaseElement element){
        new WebDriverWait(Driver.getDriver(), duration)
                .until(ExpectedConditions.elementToBeClickable(element.getLocator()));
    }

    public static void waitElementDisappears(BaseElement element){
        new WebDriverWait(Driver.getDriver(), duration).until(ExpectedConditions
                .invisibilityOfElementLocated(element.getLocator()));
    }

    public static Alert waitUntilAlertIsPresent(){
        return new WebDriverWait(Driver.getDriver(), duration)
                .until((ExpectedConditions.alertIsPresent()));

    }
}
