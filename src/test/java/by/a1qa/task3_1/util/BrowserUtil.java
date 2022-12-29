package by.a1qa.task3_1.util;

import by.a1qa.task3_1.driver.Driver;

public class BrowserUtil {


    public static void goToURL(String url){
        CustomLogger.info("BrowserUtil.goToURL(): " + url);
        Driver.getDriver().navigate().to(url);
    }

    public static void closeBrowser(){
        CustomLogger.info("BrowserUtil.closeBrowser()");
        Driver.getDriver().quit();
    }

    public static void closeCurrentTab(){
        CustomLogger.info("BrowserUtil.closeCurrentTab()");
        Driver.getDriver().close();
    }

    public static String getCurrentTabHandle(){
        CustomLogger.info("BrowserUtil.getWindowHandle()");
        return Driver.getDriver().getWindowHandle();
    }

    public static int getTabCount(){
        return Driver.getDriver().getWindowHandles().size();
    }

    public static boolean switchToOtherTab(String currentTabHandle){
        if(Driver.getDriver().getWindowHandles().size() < 2){
            CustomLogger.error("BrowserUtil.switchToNewTab() : false");
            return false;
        }
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if(!currentTabHandle.contentEquals(windowHandle)) {
                CustomLogger.info("BrowserUtil.switchToNewTab() : true");
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return true;
    }

    public static void switchToTab(String tabHandle){
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if(tabHandle.contentEquals(windowHandle)) {
                CustomLogger.info("BrowserUtil.switchToTab()");
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }
}
