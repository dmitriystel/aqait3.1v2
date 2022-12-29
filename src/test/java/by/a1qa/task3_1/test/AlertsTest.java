package by.a1qa.task3_1.test;

import by.a1qa.task3_1.page.AlertsFrameWindowsForm;
import by.a1qa.task3_1.page.MainPage;
import by.a1qa.task3_1.util.CustomLogger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest{

    @Test
    public void testAlerts(){

        CustomLogger.info("Start if an alerts test");

        MainPage mainPage = new MainPage()
                .openMainPage();    // 1

        CustomLogger.info("Step 1. Assert if the main page is open.");
        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't open.");

        AlertsFrameWindowsForm alertsPage = mainPage
                .clickAlertsFrameWindowsBtn()   // 2
                .openAlertsForm();

        CustomLogger.info("Step 2. Assert if the alerts form has appeared.");
        Assert.assertTrue(alertsPage.isPageOpened(), "Alerts form hasn't appeared on page.");

        alertsPage.openAlertYouClickedBtn();  // 3

        CustomLogger.info("Step 3. Assert if alert with text 'You clicked a button' is open.");
        Assert.assertEquals(alertsPage.getAlertText(), "You clicked a button",
                "Alert with text 'You clicked a button' isn't open.");

        alertsPage.closeAlert();    // 4

        CustomLogger.info("Step 4. Assert if alert is closed.");
        Assert.assertFalse(alertsPage.isAlertPresent(), "Alert isn't closed");

        alertsPage.openAlertDoYouConfirmActionBtn();    // 5

        CustomLogger.info("Step 5. Assert if alert with text 'Do you confirm actions?' is open.");
        Assert.assertEquals(alertsPage.getAlertText(), "Do you confirm action?",
                "Alert with text 'Do you confirm action?' isn't open.");

        alertsPage.closeAlert();    // 6

        CustomLogger.info("Step 6.1 Assert if alert is closed.");
        Assert.assertFalse(alertsPage.isAlertPresent(), "Alert isn't closed");

        CustomLogger.info("Step 6.2 Assert if 'You selected Ok' appeared on the page.");
        Assert.assertEquals(alertsPage.getConfirmBoxResultLabelText(), "You selected Ok",
                "Alert with text 'You selected Ok' did not appear.");

        alertsPage.openAlertPleaseEnterYourNameBtn();   // 7

        CustomLogger.info("Step 7. Assert if alert with 'Please enter your name' has appeared on the page.");
        Assert.assertEquals(alertsPage.getAlertText(), "Please enter your name",
                "Alert with text 'Please enter your name' did not appear.");



    }




}
