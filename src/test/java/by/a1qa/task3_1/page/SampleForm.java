package by.a1qa.task3_1.page;

import by.a1qa.task3_1.element.Label;
import org.openqa.selenium.By;

public class SampleForm extends BaseForm {

    private static By samplePageLabelLocator = By.id("sampleHeading");
    private static Label samplePageLabel = new Label(samplePageLabelLocator, "Sample page label");

    public SampleForm() {
        super(samplePageLabel, "Sample page");
    }

    public String getPageLabelText(){
        return this.getElement().getText();
    }

//  4.2. Browser Windows form  (locator and label)
    private By browserWindowsLabelLocator = By.xpath("//div[contains(text(),'Browser')]/parent::div");
    private Label browserWindowsLabel = new Label(browserWindowsLabelLocator, "Browser Windows label");


// 4.2. Page with Browser Windows form is open
    public boolean isBrowserWindowsLabelOpen (){
        return browserWindowsLabel.isDisplayed();
    }

}