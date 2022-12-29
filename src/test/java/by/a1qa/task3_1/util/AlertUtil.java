package by.a1qa.task3_1.util;

import by.a1qa.task3_1.driver.Driver;
import by.a1qa.task3_1.wait.ConditionalWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertUtil {

    public static boolean isDialogPresent() {
        return (ExpectedConditions.alertIsPresent().apply(Driver.getDriver())) != null;
    }

    public static void acceptAlert(){
        Alert alert = ConditionalWait.waitUntilAlertIsPresent();
        alert.accept();
    }

    public static String getText() {
        Alert alert = ConditionalWait.waitUntilAlertIsPresent();
        return alert.getText();
    }

    public static void sendKeys(String keys) {
        Alert alert = ConditionalWait.waitUntilAlertIsPresent();
        alert.sendKeys(keys);
        System.out.println(alert.getText()); // delete
    }

}
