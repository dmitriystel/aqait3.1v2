package by.a1qa.task3_1.page;

import by.a1qa.task3_1.element.Button;
import by.a1qa.task3_1.element.Label;
import by.a1qa.task3_1.util.AlertUtil;
import by.a1qa.task3_1.util.CustomLogger;
import by.a1qa.task3_1.util.RandomStringGenerator;
import by.a1qa.task3_1.wait.ConditionalWait;
import org.openqa.selenium.By;

public class AlertsFrameWindowsForm extends BaseForm {
    // Alerts, Frame & Windows (locator and label) on Alerts, Frame & Windows form
    private static By alertsFrameAndWindowLabelLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Alerts')]");
    private static Label alertsFrameAndWindowLabel = new Label(alertsFrameAndWindowLabelLocator, "alertsFrameAndWindowLabel");
    // 3. "Click me" button(locator and button). Click Button to see alert.
    private By toSeeAlertBtnLocator = By.id("alertButton");
    private Button toSeeAlertBtn = new Button(toSeeAlertBtnLocator, "to see alert button");
    // 5. "Click me" button(locator and button). Click on "On button click, confirm box will appear" button
    private By confirmBoxBtnLocator = By.id("confirmButton");
    private Button confirmBoxBtn = new Button(confirmBoxBtnLocator, "confirm box will appear button");
    // 6. Text "You selected Ok" (locator and label) has appeared on page.
    private By confirmBoxResultLabelLocator = By.id("confirmResult");
    private Label confirmBoxResultLabel = new Label(confirmBoxResultLabelLocator, "Confirm box result after alert");


    // 7. "Click me" button(locator and button). Click on "On button click, prompt box will appear" button
    private By promptBoxBtnLocator = By.id("promtButton");
    private Button promptBoxBtn = new Button(promptBoxBtnLocator, "prompt box will appear button");



    // Alerts form after click Alerts btn
    private By alertFormLocator = By.id("javascriptAlertsWrapper");
    private Label alertForm = new Label(alertFormLocator, "alertFormLabel");



    // constructor to create an instance of the class
    public AlertsFrameWindowsForm() {
        super(alertsFrameAndWindowLabel, "alertsFrameAndWindowsPage");
    }

    // 3. open alert - "You clicked a button" is open
    public AlertsFrameWindowsForm openAlertYouClickedBtn(){
        scrollDown();
        ConditionalWait.waitToBeClickable(toSeeAlertBtn);
        toSeeAlertBtn.click();
        CustomLogger.info(this.getFormName() + " : openAlertYouClickedBtn() with text - " +  AlertUtil.getText());
        return this;
    }
    // 4/6/8. Close alert
    public AlertsFrameWindowsForm closeAlert(){
        CustomLogger.info(this.getFormName() + " : closeAlert()");
        AlertUtil.acceptAlert();
        return this;
    }
    // 5. Open alert -  "Do you confirm action?"
    public AlertsFrameWindowsForm openAlertDoYouConfirmActionBtn(){
        ConditionalWait.waitToBeClickable(confirmBoxBtn);
        confirmBoxBtn.click();
        CustomLogger.info(this.getFormName() + " : openAlertDoYouConfirmActionBtn() with text - " +  AlertUtil.getText());
        return this;
    }
    // 6. Text "You selected Ok" (locator and label) has appeared on page.
    public String getConfirmBoxResultLabelText(){
        scrollDown();
        ConditionalWait.waitToBeClickable(confirmBoxResultLabel);
        confirmBoxResultLabel.isDisplayed();
        CustomLogger.info(this.getFormName() + " : getConfirmBoxResultLabelText() with text - " +  AlertUtil.getText());
        return confirmBoxResultLabel.getText();
    }



    // 7. Open alert -  "Please enter your name"
    public AlertsFrameWindowsForm openAlertPleaseEnterYourNameBtn(){
        ConditionalWait.waitToBeClickable(promptBoxBtn);
        promptBoxBtn.click();
        CustomLogger.info("Step 7. Alerts form has appeared on page with text - " +  AlertUtil.getText());
        return this;
    }
    // 8. Enter randomly generated text
    public AlertsFrameWindowsForm enterRandomlyGeneratedText(){
        String randomString = RandomStringGenerator.getRandomString();
        AlertUtil.sendKeys(randomString);
        return this;
    }

//    public boolean isAlertFormAppeared() { return alertForm.isDisplayed();}

    public String getAlertText() {return AlertUtil.getText();}

    public boolean isAlertPresent(){ return AlertUtil.isDialogPresent(); }






}
