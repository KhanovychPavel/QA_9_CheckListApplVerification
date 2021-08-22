package tests;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ItemInputPageHelper;

public class HomePageTests extends TestBase {
    ItemInputPageHelper inputPageHelper;

    @BeforeMethod
    public void initTests() {
        inputPageHelper = PageFactory.initElements(driver, ItemInputPageHelper.class);

    }

    @Test
    public void addNewListVerification () {
        int listSizeInitial = homePage.getListSize();

        homePage.addShoppingList("First list");
        inputPageHelper.waitUntilPageIsLoaded();

        driver.navigate().back();
        homePage.waitUntilPageIsLoaded();

        int listSizeActual = homePage.getListSize();

        homePage.rotateToLandScape();
        homePage.waitUntilPageIsLoaded();

        Assert.assertEquals("First list", homePage.getFirstListText());
        Assert.assertEquals(listSizeActual, listSizeInitial + 1);

    }

    @Test
    public void addNewCheckListAddItemToBackgroundVerification() {
        int listSizeInitial = homePage.getListSize();

        homePage.addShoppingList("New list");
        inputPageHelper.waitUntilPageIsLoaded();

        inputPageHelper.runToBackGround(5);
        inputPageHelper.waitUntilPageIsLoaded();

        inputPageHelper.itemAdding("Mob-06 item");
        inputPageHelper.returnToCheckListPage();

        homePage.waitUntilPageIsLoaded();
        int listSizeActual = homePage.getListSize();

        Assert.assertEquals(listSizeActual, listSizeInitial + 1);

    }

}
