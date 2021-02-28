package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropDownList = By.id("dropdown");

    private Select findDropdownElement(){
        return new Select(driver.findElement(dropDownList));


    }

    public DropdownPage (WebDriver driver) {
        this.driver = driver;
    }

   public void clickFromDropDownList (String option) {

    findDropdownElement().selectByVisibleText(option);

   }
   public List<String> getSelectedOptions(){
        List<WebElement>selectedElements = findDropdownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());





   }

}
