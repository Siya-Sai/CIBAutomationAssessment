package web.helpers;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {
    public static WebDriver driver;

    @Before
    public void setWebDriver() throws Exception {

        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = "chrome";
        }
        switch (browser) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "Browsers/chromedriver");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("['start-maximized']");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "Browsers/geckodriver");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
            }
            default -> throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
        }

    }
}
