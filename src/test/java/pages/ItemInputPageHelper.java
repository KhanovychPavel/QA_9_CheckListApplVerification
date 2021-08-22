package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemInputPageHelper extends PageBase {
    @FindBy(id = "com.flt.checklist:id/add_item_edit")
    WebElement addItemEditField;
    @FindBy(id = "com.flt.checklist:id/add_item")
    WebElement addItemButton;
    @FindBy(id = "com.flt.checklist:id/item_name")
    WebElement itemNameField;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    WebElement returnButton;

    public ItemInputPageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(addItemEditField, 5);
    }

    public void itemAdding(String itemName) {
        waitUntilElementIsClickable(addItemEditField, 5);
        editField(addItemEditField, itemName);
        waitUntilElementIsClickable(addItemButton, 5);
        addItemButton.click();
        waitUntilElementIsVisible(itemNameField, 5);
    }

    public void returnToCheckListPage() {
        waitUntilElementIsClickable(returnButton, 5);
        returnButton.click();

    }
}
