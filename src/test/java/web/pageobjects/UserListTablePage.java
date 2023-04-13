package web.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserListTablePage {

    private WebDriver driver;

    @FindBy(xpath = "//button[normalize-space()=\"Add User\"]")
    private WebElement addUserButton;

    @FindBy(xpath = "//tbody")
    private WebElement userDataTable;

    public UserListTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitForPageToLoad();
    }

    // Click on the Add User button to open the Add User page
    public AddUserPage clickAddUserButton() {
        addUserButton.click();
        return new AddUserPage(driver);
    }

    // Check if a user with the specified username is in the table
    public boolean isUserInTable(String userName) {
        String xpath = String.format("//tr/td[3][contains(text(), '%s')]", userName);
        List<WebElement> elements = userDataTable.findElements(By.xpath(xpath));
        return !elements.isEmpty();
    }

    // Wait for the page to load by checking the title
    private void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Protractor practice"));
    }
}
