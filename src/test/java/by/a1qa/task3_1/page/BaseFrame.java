package by.a1qa.task3_1.page;

import by.a1qa.task3_1.element.BaseElement;
import by.a1qa.task3_1.util.FrameUtil;
import org.openqa.selenium.By;

public class BaseFrame extends BaseForm{

    By frameLocator;

    public BaseFrame(BaseElement element, By frameLocator, String formName) {
        super(element, formName);
        this.frameLocator = frameLocator;
    }

    public void switchToThisFrame(){
        FrameUtil.switchToFrame(frameLocator);
    }

    public void leaveFrame(){
        FrameUtil.leaveFrame();
    }
}
