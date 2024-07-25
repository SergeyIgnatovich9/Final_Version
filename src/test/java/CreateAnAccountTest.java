import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.example.dto.UserAccount;
import org.example.page.AccountPage;
import org.example.page.CreateAnAccountPage;
import org.example.report.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CreateAnAccountTest extends BaseTest {

    private UserAccount randomUsersCreator;

    @BeforeMethod
    public void getData() {
        randomUsersCreator = new UserAccount().createFakeAccount();
    }

    @Description("Create account functionality")
    @TmsLink("ID-001")
    @Test
    public void createAnAccountTest() {
        CreateAnAccountPage createAnAccountPage = homePage.clickCreateAccountLink();
        createAnAccountPage.fillInCreateAccountFields(randomUsersCreator);
        AccountPage accountPage = createAnAccountPage.createAccountButtonClick();
        Assert.assertTrue(accountPage.isSuccessfullyAddedItemMessageDisplayed(),
                "Account has not been created");
    }
}