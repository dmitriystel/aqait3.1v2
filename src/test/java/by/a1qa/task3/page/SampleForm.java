package by.a1qa.task3.page;

import by.a1qa.task3.base.BaseForm;
import by.a1qa.task3.element.Button;
import by.a1qa.task3.element.Label;
import by.a1qa.task3.util.CustomLogger;
import org.openqa.selenium.By;

public class SampleForm  extends BaseForm {

    private static By samplePageLabelLocator = By.id("sampleHeading");
    private static Label samplePageLabel = new Label(samplePageLabelLocator, "Sample page label");

    public SampleForm() {
        super(samplePageLabel, "Sample page");
    }

    public String getPageLabelText(){
        CustomLogger.info(this.getFormName() + " : getPageLabelText()");
        return this.getElement().getText();
    }
}