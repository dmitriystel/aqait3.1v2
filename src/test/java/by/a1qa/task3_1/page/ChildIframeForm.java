package by.a1qa.task3_1.page;

import by.a1qa.task3_1.element.Label;
import org.openqa.selenium.By;

public class ChildIframeForm extends BaseFrame{


    private static By childIframeLocator = By.xpath("//body/iframe");
    private static By childIFrameLabelLocator = By.xpath("//p[contains(text(), 'Child Iframe')]");
    private static Label childIframeLabel = new Label(childIFrameLabelLocator, "Child Iframe");

    public ChildIframeForm() {
        super(childIframeLabel, childIframeLocator, "Child Frame Page");
    }

}
