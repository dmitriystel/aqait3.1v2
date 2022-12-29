package by.a1qa.task3_1.test;

import by.a1qa.task3_1.page.*;
import by.a1qa.task3_1.util.CustomLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest  extends BaseTest{

    @Test
    public void testIframe(){

        CustomLogger.info("Start if an iframe test");

        MainPage mainPage = new MainPage()
                .openMainPage();    // 1

        CustomLogger.info("Step 1. Assert if the main page is open.");
        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't open.");

        AlertsFrameWindowsForm alertsPage = mainPage
                .clickAlertsFrameWindowsBtn()  // 2
                .nestedFramesButtonClick();

        CustomLogger.info("Step 3. Assert if messages \"Parent frame\" and \"Child Iframe\" are present on the page");
        ParentFrameForm parentFramePage = new ParentFrameForm();
        parentFramePage.switchToThisFrame();
        Assert.assertTrue(parentFramePage.getParentFrameLabelText().equals("Parent frame"),
                "There is no messages \"Parent frame\" present on the page");
        parentFramePage.switchToChildFrame();
        Assert.assertTrue(parentFramePage.getChildIframeLabelText().equals("Child Iframe"),
                "There is no messages \"Child Iframe\" present on the page");
        parentFramePage.leaveChildFrame();

        alertsPage.framesButtonClick();

        CustomLogger.info("Step 4. Assert if frames form is open");
        Assert.assertTrue(alertsPage.isFramesLabelOpen(), "Frames form is not open!");

        CustomLogger.info("Step 5. Assert if message from upper frame equals to the message from lower frame");
        UpperFrameForm upperFramePage = new UpperFrameForm();
        upperFramePage.switchToThisFrame();
        String upperFrameMessage = upperFramePage.getUpperFrameLabelText();
        upperFramePage.leaveFrame();

        LowerFrameForm lowerFramePage = new LowerFrameForm();
        lowerFramePage.switchToThisFrame();
        String lowerFrameMessage = lowerFramePage.getLowerFrameLabelText();
        lowerFramePage.leaveFrame();
        Assert.assertEquals(upperFrameMessage, lowerFrameMessage,
                "Message from upper frame is not equal to the message from lower frame!");

        CustomLogger.info("End of an Iframe test");











    }
}
