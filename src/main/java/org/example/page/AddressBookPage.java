package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends BasePage {

    @FindBy(css = ".actions-toolbar .action")
    private WebElement addNewAddressButton;

    public AddNewAddressPage clickAddNewAddressButton() {
        addNewAddressButton.click();
        return new AddNewAddressPage();
    }
}