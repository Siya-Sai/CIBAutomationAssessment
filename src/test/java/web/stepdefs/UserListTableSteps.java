package web.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import web.pageobjects.AddUserPage;
import web.pageobjects.UserListTablePage;

import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class UserListTableSteps {

    private WebDriver driver;
    private UserListTablePage userListTablePage;
    private AddUserPage addUserPage;

    @Given("I am on the User List Table page")
    public void iAmOnTheUserListTablePage() {
        driver = new ChromeDriver();
        driver.get("http://www.way2automation.com/angularjs-protractor/webtables/");
        userListTablePage = new UserListTablePage(driver);
    }

    @When("I click Add User")
    public void iClickAddUser() {
        addUserPage = userListTablePage.clickAddUserButton();
    }

    @When("I enter user details:")
    public void iEnterUserDetails(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String firstName = data.get(0).get("First Name") + new Random().nextInt(10000);
        String userName = data.get(0).get("User Name") + new Random().nextInt(10000);
        addUserPage.enterFirstName(firstName)
                .enterLastName(data.get(0).get("Last Name"))
                .enterUserName(userName)
                .enterPassword(data.get(0).get("Password"))
                .selectCompany(data.get(0).get("Company"))
                .selectRole(data.get(0).get("Role"))
                .enterEmail(data.get(0).get("Email"))
                .enterCellPhone(data.get(0).get("CellPhone"))
                .clickSaveButton();

        // Verify that the user is added to the list
        assertTrue(userListTablePage.isUserInTable(userName));
    }

    @Then("the user should be added to the list")
    public void theUserShouldBeAddedToTheList() {
        // Do nothing, the verification is done in the previous step
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
