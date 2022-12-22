package by.a1qa.task3_1.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito"); // todo in config file
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        return driver;
    }
}
