import org.openqa.selenium.WebDriver;
import org.example.driver.DriverManager;
import org.example.page.HomePage;
import org.example.report.AllureManager;
import org.example.report.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.time.Duration;

import static org.example.config.ConfigurationManager.configuration;

@Listeners(TestListener.class)

public class BaseTest {

    protected HomePage homePage;
    protected WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        AllureManager.setAllureEnvironmentInformation();
    }

    @BeforeMethod
    public void startBrowser() {
        driver = DriverManager.getDriver();
        driver.get(configuration().url());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        homePage = new HomePage();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverManager.tearDown();
    }
}
