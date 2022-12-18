package by.a1qa.task3_1.util;

import by.a1qa.task3_1.driver.Driver;

public class BrowserUtil {

    public static void goToURL(String url){
        Driver.getDriver().navigate().to(url);
    }

    public static void closeBrowser(){
        Driver.getDriver().quit();
    }
}
