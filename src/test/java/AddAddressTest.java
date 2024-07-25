import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.example.page.*;
import org.example.report.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class AddAddressTest extends BaseTest {

    @Description("Add new address to user's profile")
    @TmsLink("ID-003")
    @Test
    public void addAddressTest() {
        LoginPage loginPage = homePage.clickSignInLink();
        loginPage.fillInLoginFields();
        loginPage.clickSingInButton();
        AddNewAddressPage addNewAddressPage = homePage.clickAccountLink().
                clickAddressBookLink().clickAddNewAddressButton();
        addNewAddressPage.fillInAddressFields();
        AccountPage accountPage = addNewAddressPage.saveNewAddressButtonClick();
        Assert.assertTrue(accountPage.isSuccessfullyAddedItemMessageDisplayed(),
                "New address has not been added");
    }
}
