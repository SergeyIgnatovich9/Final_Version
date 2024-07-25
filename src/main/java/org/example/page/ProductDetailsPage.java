package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.example.helpers.PageUtil;

import java.util.List;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//*[@class='swatch-option text']")
    private List<WebElement> size;

    @FindBy(xpath = "//*[@class='swatch-option color']")
    private List<WebElement> color;

    @FindBy(css = ".product-social-links .towishlist")
    private WebElement addToWishListButton;

    @FindBy(xpath = "//*[contains(text(),'Add to Cart')]")
    private WebElement addToCartButton;

    @FindBy(css = ".message-success")
    private WebElement successfullyAddedToWishMessage;

    public void addToWishList() {
        PageUtil.clickRandomElement(size);
        PageUtil.clickRandomElement(color);
        addToWishListButton.click();
    }

    public void addProdToCart() {
        PageUtil.clickRandomElement(size);
        PageUtil.clickRandomElement(color);
        addToCartButton.click();
    }

    public boolean isSuccessfullyAddedToWishMessage() {
        return successfullyAddedToWishMessage.isDisplayed();
    }
}