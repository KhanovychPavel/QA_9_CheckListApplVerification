package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePageHelper;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public AppiumDriver driver;

    HomePageHelper homePage;

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidQA");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("appPackage", "com.flt.checklist");
        capabilities.setCapability("appActivity", "com.flt.checklist.MainActivity");
        capabilities.setCapability("automationName", "Uiautomator2");
        capabilities.setCapability("app",
                "C:/Users/user/IdeaProjects/QA_9_CheckListApplVerification/app/easy_checkllist.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        homePage = PageFactory.initElements(driver, HomePageHelper.class);

        homePage.rotateToPortrait();
        homePage.waitUntilPageIsLoaded();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
