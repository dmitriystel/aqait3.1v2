package by.a1qa.task3_1.page;

import by.a1qa.task3_1.element.Button;
import by.a1qa.task3_1.element.Label;
import by.a1qa.task3_1.util.BrowserUtil;
import by.a1qa.task3_1.util.ConfigManager;
import by.a1qa.task3_1.util.CustomLogger;
import by.a1qa.task3_1.wait.ConditionalWait;
import org.openqa.selenium.By;

public class MainPage extends BaseForm {
    // Selenium Certification Training Label (locator and button), unique element for home page
    private static By seleniumCertificationTrainingLabelLocator = By.xpath("//img[contains(@class, 'banner')]");
    private static Label seleniumCertificationTrainingLabel = new Label(seleniumCertificationTrainingLabelLocator,
            "seleniumCertificationTrainingLabel");
    // Alerts, Frame & Windows button (locator and button) on home page
    private By alertsFrameAndWindowsBtnLocator = By.xpath("//h5[contains(text(), 'Alerts')]//parent::div");
    private Button alertsFrameAndWindowsBtn = new Button(alertsFrameAndWindowsBtnLocator,
            "Alerts, Frame & Windows button");
    // constructor to create an instance of the class
    public MainPage() {
        super(seleniumCertificationTrainingLabel, "mainPage");
    }


    // Alert form label
    private By alertFormLabelLocator = By.xpath("//div[contains(@id, 'Alerts')]");
    private Label alertFormLabel = new Label(alertFormLabelLocator, "alertFormLabel");

    // Alerts button () (locator and button) on Alerts, Frame & Windows page
    private By alertsBtnLocator = By.xpath("//span[contains(text(), 'Alerts')]//parent::li");
    private Button alertsBtn = new Button(alertsBtnLocator, "Alerts Button");

    // Nested Frames button (locator and label) on Alerts, Frame & Windows form
    private By nestedFramesButtonLocator = By.xpath("//span[contains(text(), 'Nested')]//parent::li");
    private Button nestedFramesButton = new Button(nestedFramesButtonLocator, "Nested Frames Button");


    // 3.2. Elements button In the menu (locator and btn)
    private By elementsButtonLocator = By.xpath("//h5[contains(text(), 'Elements')]//parent::div");
    private Button elementsButton = new Button(elementsButtonLocator, "Elements button");

//    4.2. Browser windows button (locator and btn)
    private By browserWindowsButtonLocator = By.xpath("//span[contains(text(), 'Browser')]//parent::li");
    private Button browserWindowsButton = new Button(browserWindowsButtonLocator, "Browser Windows button");




    // 2.2. In a menu click Nested Frames button
    public AlertsFrameWindowsForm nestedFramesButtonClick() {
        scrollDown();
        ConditionalWait.waitToBeClickable(nestedFramesButton);
        nestedFramesButton.click();
        return new AlertsFrameWindowsForm();
    }


    // 1. Open main page
    public MainPage openMainPage() {
        CustomLogger.info(this.getFormName() + " : openMainPage");
        BrowserUtil.goToURL(ConfigManager.getURL());
        isPageOpened();
        return this;
    }

    // 2. Click on Alerts, Frame & Windows button.
    public MainPage clickAlertsFrameWindowsBtn(){
        CustomLogger.info(this.getFormName() + " : clickAlertsFrameWindowsBtn()");
        scrollDown();
        ConditionalWait.waitToBeClickable(alertsFrameAndWindowsBtn);
        alertsFrameAndWindowsBtn.click();
        return this;
    }

    // 1.2
    public AlertsFrameWindowsForm openAlertsForm(){
        CustomLogger.info(this.getFormName() + " : openAlertsForm()");
        ConditionalWait.waitToBeClickable(alertsBtn);
        scrollDown();
        alertsBtn.click();
        isPageOpened();
        return new AlertsFrameWindowsForm();
    }

//    3.2 Click on Elements button In the menu
public ElementsForm elementsButtonClick(){
        scrollDown();
    CustomLogger.info(this.getFormName() + " : elementsButtonClick()");
    ConditionalWait.waitToBeClickable(elementsButton);
    elementsButton.click();
    return new ElementsForm();
}


// 4.2. In the menu click a Browser windows button
    public SampleForm browserWindowsButtonClick() {
        browserWindowsButton.click();
        return new SampleForm();
    }










}
