package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageBase {
    WebDriver driver;

    public void waitUntilElementIsClickable(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsVisible(WebElement element, int time) {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editField(WebElement field, String value) {
        field.click();
        field.sendKeys(value);
    }

    public void rotateToLandScape() {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.rotate(ScreenOrientation.LANDSCAPE);
    }


    public void rotateToPortrait() {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.rotate(ScreenOrientation.PORTRAIT);
    }

    public void runToBackGround(int time) {
        AppiumDriver appiumDriver = (AppiumDriver) driver;
        appiumDriver.runAppInBackground(Duration.ofSeconds(time));
    }
}
