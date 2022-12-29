package by.a1qa.task3_1.page;

import by.a1qa.task3_1.element.Button;
import by.a1qa.task3_1.element.Label;
import org.openqa.selenium.By;

public class IframeForm {

    // for label //div[contains(text(), 'Nested Frames')]


    // Alerts, Frame & Windows (locator and label) on Alerts, Frame & Windows form
    private static By alertsFrameAndWindowLabelLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Alerts')]");
    private static Label alertsFrameAndWindowLabel = new Label(alertsFrameAndWindowLabelLocator, "alertsFrameAndWindowLabel");



    // Nested Frames button (locator and label) on Alerts, Frame & Windows form
    private By nestedFramesButtonLocator = By.xpath("//span[contains(text(), 'Nested')]//parent::li");
    private Button nestedFramesButton = new Button(nestedFramesButtonLocator, "Nested Frames Button");
}
