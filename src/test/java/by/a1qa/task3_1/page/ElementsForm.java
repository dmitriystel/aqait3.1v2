package by.a1qa.task3_1.page;

import by.a1qa.task3_1.driver.Driver;
import by.a1qa.task3_1.element.Button;
import by.a1qa.task3_1.element.Input;
import by.a1qa.task3_1.element.Label;
import by.a1qa.task3_1.model.User;
import by.a1qa.task3_1.wait.ConditionalWait;
import org.openqa.selenium.By;



public class ElementsForm extends BaseForm{

    private String userDataDynamicLocator = "//div[contains(text(),'%s')]";
    private String userDeleteButtonDynamicLocator = userDataDynamicLocator
            + "//parent::div//span[contains(@id, 'delete-record')]";

//    Elements button In the menu (locator and label)
    private static By elementsLabelLocator = By.xpath("//div[@class = 'main-header' and contains(text(), 'Elements')]");
    private static Label elementsLabel = new Label(elementsLabelLocator, "elementsLabel");

    public ElementsForm() {
        super(elementsLabel, "Elements page");
    }

//    3.2 Web Tables button (locator and button)
    private By webTablesButtonLocator = By.xpath("//span[contains(text(), 'Web')]//parent::li");
    private Button webTablesButton = new Button(webTablesButtonLocator, "Web Tables button");

    // web Tables Label (locator and label)
    private By webTablesLabelLocator = By.xpath("//div[contains(@class, 'web-tables')]");
    private Label webTablesLabel = new Label(webTablesLabelLocator, "Web Tables Label");

//     3.3. Add button (locator and button)
    private By addNewRecordButtonLocator = By.id("addNewRecordButton");
    private Button addNewRecordButton = new Button(addNewRecordButtonLocator, "add new record button");




//    3.3. Registration Form (locator and label)
    private By registrationFormLabelLocator = By.xpath("//div[contains(@class, 'modal-dialog')]");
    private Label registrationFormLabel = new Label(registrationFormLabelLocator, "registration form label");

    // submit (locator and button)
    private By submitButtonLocator = By.id("submit");
    private Button submitButton = new Button(submitButtonLocator, "Submit button");


//    3.4. first name (input locator)
    private By firstNameInputLocator = By.id("firstName");
    private Input firstNameInput = new Input(firstNameInputLocator, "First name input field");

    //    3.4. last name (input locator)
    private By lastNameInputLocator = By.id("lastName");
    private Input lastNameInput = new Input(lastNameInputLocator, "Last name input field");

    //    3.4. email (input locator)
    private By userEmailInputLocator = By.id("userEmail");
    private Input userEmailInput = new Input(userEmailInputLocator, "User email input field");

    //    3.4. age (input locator)
    private By ageInputLocator = By.id("age");
    private Input ageInput = new Input(ageInputLocator, "Age input field");

    //    3.4. age (input locator)
    private By salaryInputLocator = By.id("salary");
    private Input salaryInput = new Input(salaryInputLocator, "Salary input field");

    // 3.4. department
    private By departmentInputLocator = By.id("department");
    private Input departmentInput = new Input(departmentInputLocator, "Department input field");




    //    3.2. click a Web Tables button
    public ElementsForm webTablesButtonClick(){
    webTablesButton.click();
    return this;
}


    public boolean isWebTablesLabelOpen(){
        return webTablesLabel.isDisplayed();
    }


//    3.3. click add button

    public ElementsForm addNewRecordButtonClick(){
        addNewRecordButton.click();
        return this;
    }


// 3.3. submit Registration Form
    public void submitButtonClick(){
        submitButton.click();
        ConditionalWait.waitElementDisappears(registrationFormLabel);
    }

    public boolean isRegistrationFormLabelOpen(){
        return  registrationFormLabel.isDisplayed();
    }


// 3.4. Enter data for User № from the table and then click Submit button
    public void fillInRegistrationForm(User user){
        firstNameInput.sendText(user.getFirstName());
        lastNameInput.sendText(user.getLastName());
        userEmailInput.sendText(user.getEmail());
        ageInput.sendText(user.getAge());
        salaryInput.sendText(user.getSalary());
        departmentInput.sendText(user.getDepartment());
    }



    public boolean isUserDataLabelOpen(String userData) {
        return new Label(By.xpath(String.format(userDataDynamicLocator, userData)),
                "User data dynamic label : " + userData).isDisplayed();
    }

    public int getNumOfUserRecords(){
        return Driver.getDriver().findElements(By.xpath(String.format(userDataDynamicLocator, "@"))).size();
    }

    public void userDeleteButtonClick(String userData){
        Button userDeleteButton = new Button(By.xpath(String.format(userDeleteButtonDynamicLocator, userData)),
                "specific user delete button : " + userData);
        userDeleteButton.click();
        ConditionalWait.waitElementDisappears(userDeleteButton);
    }


}
