package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.example.dto.UserAccount;

public class CreateAnAccountPage extends BasePage {

    @FindBy(css = ".primary .action span")
    private WebElement createAccountButton;

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(css = ".confirmation .control input")
    private WebElement confirmPasswordField;

    public void fillInCreateAccountFields(UserAccount customer) {
        firstNameField.sendKeys(customer.getFirstName());
        lastNameField.sendKeys(customer.getLastName());
        emailField.sendKeys(customer.getEmail());
        passwordField.sendKeys(customer.getPassword());
        confirmPasswordField.sendKeys(customer.getPassword());
    }

    public AccountPage createAccountButtonClick() {
        createAccountButton.click();
        return new AccountPage();
    }
}
