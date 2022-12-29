package by.a1qa.task3_1.test;

import by.a1qa.task3_1.model.User;
import by.a1qa.task3_1.page.AlertsFrameWindowsForm;
import by.a1qa.task3_1.page.ElementsForm;
import by.a1qa.task3_1.page.MainPage;
import by.a1qa.task3_1.util.CustomLogger;
import by.a1qa.task3_1.util.UserParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class TablesTest extends BaseTest{

    @DataProvider(name = "userProvider")
    public Object[][] dataProviderMethod() {
        final String userListPath = "src/test/resources/testData/users.json";
        List<User> users = UserParser.parseUserFromFileToList(userListPath);
        User firstUser = users.get(0);
        User secondUser = users.get(1);
        return new Object[][]{{firstUser}, {secondUser}};
    }

    @Test(dataProvider = "userProvider")
    public void testTables(User user){

        CustomLogger.info("Start if an tables test");

        MainPage mainPage = new MainPage()
                .openMainPage();    // 1

        CustomLogger.info("Step 1. Assert if the main page is open.");
        Assert.assertTrue(mainPage.isPageOpened(), "Main page isn't open.");

        ElementsForm elementsForm = mainPage
                .elementsButtonClick()
                .webTablesButtonClick();

        CustomLogger.info("Step 2. Assert if the web tables form is open.");
        Assert.assertTrue(elementsForm.isWebTablesLabelOpen(), "The web tables form is not open!");

        elementsForm.addNewRecordButtonClick();

        CustomLogger.info("Step 3. Assert if the registration form has appeared on the page.");
        Assert.assertTrue(elementsForm.isRegistrationFormLabelOpen(),
                "The registration form has not appeared on the page!");

        elementsForm.fillInRegistrationForm(user);
        elementsForm.submitButtonClick();

        CustomLogger.info("Step 4. Assert if the registration form has closed.");
        Assert.assertFalse(elementsForm.isRegistrationFormLabelOpen(), "The registration form has not closed!");

        CustomLogger.info("Step 5. Assert if data of user has appeared in a table.");
        Assert.assertTrue(elementsForm.isUserDataLabelOpen(user.getEmail()),
                "Data of user has not appeared in a table!");

        int numberOfRecordsBeforeDelete = elementsForm.getNumOfUserRecords();
        elementsForm.userDeleteButtonClick(user.getEmail());

        CustomLogger.info("Step 6. Assert if number of records in table has changed.");
        int numberOfRecordsAfterDelete = elementsForm.getNumOfUserRecords();
        Assert.assertTrue(numberOfRecordsBeforeDelete != numberOfRecordsAfterDelete,
                "Number of records in table has not changed!");


        CustomLogger.info("Step 7. Assert if data of user has been deleted from the table.");
        Assert.assertFalse(elementsForm.isUserDataLabelOpen(user.getEmail()),
                "Data of user has not been deleted from the table!");

        CustomLogger.info("End of a tables test");


    }








}
