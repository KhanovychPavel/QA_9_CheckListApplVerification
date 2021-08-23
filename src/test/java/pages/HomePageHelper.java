package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageHelper extends PageBase {
    @FindBy(xpath = "//android.widget.TextView[@content-desc='Add New Shopping List']")
    WebElement shoppingListButton;
    @FindBy(xpath = "//*[@resource-id = 'android:id/custom']/*[@class = 'android.widget.EditText']")
    WebElement addNewListField;
    @FindBy(id = "android:id/button1")
    WebElement okButton;
    @FindBy(id = "com.flt.checklist:id/list_title")
    WebElement firstListTitle;
    @FindBy(id = "com.flt.checklist:id/text_layout")
    List<WebElement> listTitles;

    public HomePageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(shoppingListButton, 10);
    }

    public void addShoppingList(String listName) {
        shoppingListButton.click();
        waitUntilElementIsClickable(addNewListField, 20);
        editField(addNewListField, listName);
        waitUntilElementIsClickable(okButton, 5);
        okButton.click();
    }

    public int getListSize() {
        return listTitles.size();
    }

    public String getFirstListText() {
        return firstListTitle.getText();
    }
}
