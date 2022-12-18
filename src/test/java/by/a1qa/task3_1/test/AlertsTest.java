package by.a1qa.task3_1.test;

import by.a1qa.task3_1.page.AlertsFrameWindowsForm;
import by.a1qa.task3_1.page.MainPageForm;
import by.a1qa.task3_1.util.BrowserUtil;
import by.a1qa.task3_1.util.ConfigManager;
import org.testng.annotations.Test;

public class AlertsTest extends BaseTest{

    @Test
    public void testAlerts(){

        new MainPageForm()
                .openPage()
                .openAlertsForm_ForAlerts()
                .openAlertYouClickedBtn()
                .closeAlert()
                .openAlertDoYouConfirmActionBtn()
                .closeAlert()
                .openAlertPleaseEnterYourNameBtn()
                .enterRandomlyGeneratedText();
    }




}
