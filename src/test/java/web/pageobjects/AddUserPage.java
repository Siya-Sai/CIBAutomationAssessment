package web.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage {

    private WebDriver driver;

    @FindBy(css = "input[name='FirstName']")
    private WebElement firstNameField;

    @FindBy(css = "input[name='LastName']")
    private WebElement lastNameField;

    @FindBy(css = "input[name='UserName']")
    private WebElement userNameField;

    @FindBy(css = "input[name='Password']")
    private WebElement passwordField;

    @FindBy(css = "input[type='radio'][value='15']")
    private WebElement companyAAAOption;

    @FindBy(css = "input[type='radio'][value='16']")
    private WebElement companyBBBOption;

    @FindBy(xpath = "//option[@value=\"2\"]")
    private WebElement roleDropDownMenu;
    @FindBy(xpath = "//option[@value=\"2\"]")
    private WebElement adminRoleOption;

    @FindBy(xpath = "//option[@value=\"1\"]")
    private WebElement customerRoleOption;

    @FindBy(css = "input[name='Email']")
    private WebElement emailField;

    @FindBy(css = "input[name='Mobilephone']")
    private WebElement cellPhoneField;

    @FindBy(xpath = "//button[normalize-space()=\"Save\"]")
    private WebElement saveButton;

    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Enter the first name in the First Name field and return this page object
    public AddUserPage enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    // Enter the last name in the Last Name field and return this page object
    public AddUserPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    // Enter the username in the Username field and return this page object
    public AddUserPage enterUserName(String userName) {
        userNameField.sendKeys(userName);
        return this;
    }

    // Enter the password in the Password field and return this page object
    public AddUserPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    // Select the company in the Company radio buttons and return this page object
    public AddUserPage selectCompany(String company) {
        if (company.equalsIgnoreCase("AAA")) {
            companyAAAOption.click();
        } else if (company.equalsIgnoreCase("BBB")) {
            companyBBBOption.click();
        } else {
            throw new IllegalArgumentException("Invalid company: " + company);
        }
        return this;
    }

    // Select the role in the Role radio buttons and return this page object
    public AddUserPage selectRole(String role) {
        roleDropDownMenu.click();
        if (role.equalsIgnoreCase("Admin")) {
            adminRoleOption.click();
        } else if (role.equalsIgnoreCase("Customer")) {
            customerRoleOption.click();
        } else {
            throw new IllegalArgumentException("Invalid role: " + role);
        }
        return this;
    }

    // Enter the email in the Email field and return this page object
    public AddUserPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    // Enter the cell phone in the Cell Phone field and return this page object
    public AddUserPage enterCellPhone(String cellPhone) {
        cellPhoneField.sendKeys(cellPhone);
        return this;
    }

    // Click the Save button and return the User List Table page object
    public UserListTablePage clickSaveButton() {
        saveButton.click();
        return new UserListTablePage(driver);
    }
}


