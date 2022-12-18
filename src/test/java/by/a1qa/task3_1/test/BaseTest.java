package by.a1qa.task3_1.test;

import by.a1qa.task3_1.driver.Driver;
import by.a1qa.task3_1.util.ConfigManager;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private final String HOMEPAGE_URL = ConfigManager.getBrowserName();

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp(){
        Driver.getInstance();
    }

//    @AfterMethod(alwaysRun = true)
//    public void browserTearDown(){
//        BrowserUtil.closeBrowser();
//    }

}
