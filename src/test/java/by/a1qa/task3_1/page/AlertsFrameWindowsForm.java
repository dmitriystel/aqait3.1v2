package by.a1qa.task3_1.page;

import by.a1qa.task3_1.element.Button;
import by.a1qa.task3_1.element.Label;
import by.a1qa.task3_1.util.AlertUtil;
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
    // 7. "Click me" button(locator and button). Click on "On button click, prompt box will appear" button
    private By promptBoxBtnLocator = By.id("promtButton");
    private Button promptBoxBtn = new Button(promptBoxBtnLocator, "prompt box will appear button");

    // constructor to create an instance of the class
    public AlertsFrameWindowsForm() {
        super(alertsFrameAndWindowLabel, "alertsFrameAndWindowsPage");
    }

    // 3. open alert - "You clicked a button" is open
    public AlertsFrameWindowsForm openAlertYouClickedBtn(){
        ConditionalWait.waitToBeClickable(toSeeAlertBtn);
        toSeeAlertBtn.click();
        return this;
    }
    // 4/6/8. Close alert
    public AlertsFrameWindowsForm closeAlert(){
     AlertUtil.acceptAlert();
        return this;
    }
    // 5. Open alert -  "Do you confirm action?"
    public AlertsFrameWindowsForm openAlertDoYouConfirmActionBtn(){
        ConditionalWait.waitToBeClickable(confirmBoxBtn);
        confirmBoxBtn.click();
        return this;
    }
    // 7. Open alert -  "Please enter your name"
    public AlertsFrameWindowsForm openAlertPleaseEnterYourNameBtn(){
        ConditionalWait.waitToBeClickable(promptBoxBtn);
        promptBoxBtn.click();
        return this;
    }
    // 8. Enter randomly generated text
    public AlertsFrameWindowsForm enterRandomlyGeneratedText(){
        String randomString = RandomStringGenerator.getRandomString();
        AlertUtil.sendKeys(randomString);
        return this;
    }

}
