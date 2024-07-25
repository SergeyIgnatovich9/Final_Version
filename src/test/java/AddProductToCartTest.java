import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.example.page.CartPage;
import org.example.page.LoginPage;
import org.example.report.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.example.helpers.Const.*;

@Listeners(TestListener.class)
public class AddProductToCartTest extends BaseTest {

    @Description("Add products to cart + values check")
    @TmsLink("ID-005")
    @Test
    public void addProductToCartTest() {
        LoginPage loginPage = homePage.clickSignInLink();
        loginPage.fillInLoginFields();
        loginPage.clickSingInButton();
        homePage.getHeader()
                .choseCategoryMenu(WOMEN_CATEGORY, BOTTOMS_SUB_CATEGORY, PANTS_SUB_CATEGORY)
                .selectARandomProduct()
                .addProdToCart();
        homePage.getHeader()
                .choseCategoryMenu(MAN_CATEGORY, TOPS_SUB_CATEGORY, JACKETS_SUB_CATEGORY)
                .selectARandomProduct()
                .addProdToCart();
        homePage.getHeader()
                .choseCategoryMenu(WOMEN_CATEGORY, TOPS_SUB_CATEGORY, JACKETS_SUB_CATEGORY)
                .selectARandomProduct()
                .addProdToCart();
        CartPage cartPage = homePage.getHeader().clickCartButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cartPage.isCartPageTitleDisplayed(), "Cart page not found");
        softAssert.assertTrue(cartPage.checkOrderTotals(),
                "Total sum of the order does not correspond to sum of subtotals");
        softAssert.assertAll();
    }
}
