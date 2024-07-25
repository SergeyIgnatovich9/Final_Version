package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(css = ".success")
    private WebElement successfullyAddedItemMessage;

    @FindBy(xpath = "//a[contains (text(), 'Address Book')]")
    private WebElement addressbookLink;

    public AddressBookPage clickAddressBookLink() {
        addressbookLink.click();
        return new AddressBookPage();
    }

    public boolean isSuccessfullyAddedItemMessageDisplayed() {
        return successfullyAddedItemMessage.isDisplayed();
    }
}