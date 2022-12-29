package by.a1qa.task3_1.test;

import by.a1qa.task3_1.page.AlertsFrameWindowsForm;
import by.a1qa.task3_1.page.MainPage;
import by.a1qa.task3_1.page.SampleForm;
import by.a1qa.task3_1.util.CustomLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandlesTest extends BaseTest{

    @Test
    public void testHandles(){

        CustomLogger.info("Start if an handles test");

        MainPage mainPage = new MainPage()
                .openMainPage();    // 1

        CustomLogger.info("Step 1. Assert if the main page is open.");
        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't open.");

        SampleForm sampleForm = mainPage
                .clickAlertsFrameWindowsBtn()  // 2
                .browserWindowsButtonClick();

        CustomLogger.info("Step 2. Page with Browser Windows form is open.");
        Assert.assertTrue(sampleForm.isBrowserWindowsLabelOpen(),
                "Page with Browser Windows form is not open!");

    }
}
