// pentru elementele de tip dropdown din navigation bar

package navBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DropdownMenu {

    protected WebDriver driver;
    private List<WebElement> itemList;
    protected WebElement items;
    private By dropdowns = By.className("dropdown");

    public DropdownMenu(WebElement items){
        this.items = items;
        itemList=items.findElements(By.tagName("li"));
    }

    public boolean isMenuListDisplayed(){
        return items.isDisplayed();
    }

    public int count(){
        return itemList.size();
    }




    //metoda dinamica pentru a selecta optiunea primita prin parametrul itemText
    public void clickMenuItem(String itemText){
        for(WebElement e:itemList){
            if (e.getText().equals(itemText)) {
                e.click();
                break;
            }
        }
    }

}
