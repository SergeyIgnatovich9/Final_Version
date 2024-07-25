package org.example.page;

import org.example.helpers.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.example.driver.DriverManager;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtil wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WaitUtil(driver);
    }

    public void hover(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

}




