package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.example.helpers.PageUtil;

import java.util.List;

public class Index_Page extends BasePage {

    @FindBy(xpath = "//*[@class='product-item-link']")
    private List<WebElement> productItem;

    public ProductDetailsPage selectARandomProduct() {
        PageUtil.clickRandomElement(productItem);
        return new ProductDetailsPage();
    }
}