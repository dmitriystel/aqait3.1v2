package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.AlertUtil;
import by.a1qa.task3.util.CustomLogger;
import by.a1qa.task3.util.ConditionalWait;
import org.openqa.selenium.By;

public class AlertsForm extends BaseForm {

    private static By alertsLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Alerts')]");
    private static Label alertsLabel = new Label(alertsLocator, "alertsFrameAndWindowLabel");

    private By toSeeAlertBtnLocator = By.id("alertButton");
    private Button toSeeAlertBtn = new Button(toSeeAlertBtnLocator, "to see alert button");

    private By confirmBoxBtnLocator = By.id("confirmButton");
    private Button confirmBoxBtn = new Button(confirmBoxBtnLocator, "confirm box will appear button");

    private By confirmBoxResultLabelLocator = By.id("confirmResult");
    private Label confirmBoxResultLabel
            = new Label(confirmBoxResultLabelLocator, "Confirm box result after alert");

    private By promptBoxBtnLocator = By.id("promtButton");
    private Button promptBoxBtn = new Button(promptBoxBtnLocator, "prompt box will appear button");

    private By promptBoxResultLabelLocator = By.id("promptResult");
    private Label promptBoxResultLabel
            = new Label(promptBoxResultLabelLocator, "Prompt box result after alert");

    public AlertsForm() {
        super(alertsLabel, "alertsForm");
    }

    public AlertsForm openAlertYouClickedBtn(){
        CustomLogger.info(this.getFormName() + " : openAlertYouClickedBtn()");
        toSeeAlertBtn.click();
        return this;
    }

    public String getAlertText() {
        CustomLogger.info(this.getFormName() + " : getAlertText()");
        return AlertUtil.getText();
    }

    public AlertsForm closeAlert(){
        CustomLogger.info(this.getFormName() + " : closeAlert()");
        AlertUtil.acceptAlert();
        return this;
    }

    public boolean isAlertPresent(){
        CustomLogger.info(this.getFormName() + " : isAlertPresent()");
        return AlertUtil.isDialogPresent();
    }

    public AlertsForm openAlertDoYouConfirmActionBtn(){
        CustomLogger.info(this.getFormName() + " : openAlertDoYouConfirmActionBtn()");
        confirmBoxBtn.click();
        return this;
    }

    public String getConfirmBoxResultLabelText(){
        CustomLogger.info(this.getFormName() + " : getConfirmBoxResultLabelText()");
        return confirmBoxResultLabel.getText();
    }

    public AlertsForm openAlertPleaseEnterYourNameBtn(){
        CustomLogger.info(this.getFormName() + " : openAlertPleaseEnterYourNameBtn()" );
        promptBoxBtn.click();
        return this;
    }

    public AlertsForm alertSendText(String text) {
        CustomLogger.info(this.getFormName() + " : alertSendText(String text)" );
        AlertUtil.sendKeys(text);
        return this;
    }

    public String getPromptBoxResultLabelText() {
        CustomLogger.info(this.getFormName() + " : getPromptBoxResultLabelText()" );
        return promptBoxResultLabel.getText();
    }
}
