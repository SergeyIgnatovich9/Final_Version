package org.example.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private WebDriver driver;

    public WaitUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementLocated(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(element));
    }
}