package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import pages.ItemInputPageHelper;

public class ItemInputPageTests extends TestBase {
    ItemInputPageHelper itemInputPage;

    @BeforeMethod
    public void initTest() {
        itemInputPage = PageFactory.initElements(driver, ItemInputPageHelper.class);

        homePage.waitUntilPageIsLoaded();
        homePage.addShoppingList("First list");
        itemInputPage.waitUntilPageIsLoaded();
    }
}
