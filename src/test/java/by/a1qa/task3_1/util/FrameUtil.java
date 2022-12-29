package by.a1qa.task3_1.util;

import by.a1qa.task3_1.driver.Driver;
import org.openqa.selenium.By;

public class FrameUtil {

    public static void switchToFrame(By frameLocator){
        CustomLogger.info("FrameUtil.switchToFrame(): " + frameLocator);
        Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(frameLocator));
    }

    public static void leaveFrame(){
        CustomLogger.info("FrameUtil.leaveFrame()");
        Driver.getDriver().switchTo().defaultContent();
    }
}
