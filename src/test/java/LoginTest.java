import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.example.page.LoginPage;
import org.example.report.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Description("Login and navigation to Welcome screen")
    @TmsLink("ID-002")
    @Test
    public void signInTest() {
        LoginPage loginPage = homePage.clickSignInLink();
        loginPage.fillInLoginFields();
        loginPage.clickSingInButton();
        Assert.assertFalse(homePage.isSuccessfullyLoggedInMessageDisplayed(),
                "Deliberately broken test for reporting demonstration");
    }
}
