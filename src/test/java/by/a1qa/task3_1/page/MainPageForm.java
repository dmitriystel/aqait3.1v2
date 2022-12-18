package by.a1qa.task3_1.page;

import by.a1qa.task3_1.element.Button;
import by.a1qa.task3_1.element.Label;
import by.a1qa.task3_1.util.BrowserUtil;
import by.a1qa.task3_1.util.ConfigManager;
import by.a1qa.task3_1.util.CustomLogger;
import by.a1qa.task3_1.wait.ConditionalWait;
import org.openqa.selenium.By;

public class MainPageForm extends BaseForm {
    // Selenium Certification Training Label (locator and button) on home page
    private static By seleniumCertificationTrainingLabelLocator = By.xpath("//img[contains(@class, 'banner')]");
    private static Label seleniumCertificationTrainingLabel = new Label(seleniumCertificationTrainingLabelLocator,
            "seleniumCertificationTrainingLabel");
    // Alerts, Frame & Windows button (locator and button) on home page
    private By alertsFrameAndWindowsBtnLocator = By.xpath("//h5[contains(text(), 'Alerts')]//parent::div");
    private Button alertsFrameAndWindowsBtn = new Button(alertsFrameAndWindowsBtnLocator,
            "Alerts, Frame & Windows button");
    // constructor to create an instance of the class
    public MainPageForm() {
        super(seleniumCertificationTrainingLabel, "mainPage");
    }
    // Alerts button () (locator and button) on Alerts, Frame & Windows page
    private By alertsBtnLocator = By.xpath("//span[contains(text(), 'Alerts')]//parent::li");
    private Button alertsBtn = new Button(alertsBtnLocator, "Alerts Button");

    // Alert form label
    private By alertFormLabelLocator = By.xpath("//div[contains(@id, 'Alerts')]");
    private Label alertFormLabel = new Label(alertFormLabelLocator, "alertFormLabel");


    // 1. Open main page
    public MainPageForm openPage() {
        BrowserUtil.goToURL(ConfigManager.getURL());
        isPageOpened();
        CustomLogger.info("Step 1. Main page is open.");
        return this;
    }
    // 2. Open alerts form
    public AlertsFrameWindowsForm openAlertsForm_ForAlerts(){
        scrollDown();
        ConditionalWait.waitToBeClickable(alertsFrameAndWindowsBtn);
        alertsFrameAndWindowsBtn.click();
        isPageOpened();
        ConditionalWait.waitToBeClickable(alertsBtn);
        scrollDown();
        alertsBtn.click();
        isAlertFormLabelOpen();
        CustomLogger.info("Step 2. Alerts form has appeared on page");
        return new AlertsFrameWindowsForm();
    }


    public boolean isAlertFormLabelOpen() { return alertFormLabel.isDisplayed(); }




}
