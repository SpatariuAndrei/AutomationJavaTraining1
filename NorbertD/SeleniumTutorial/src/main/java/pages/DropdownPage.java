package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFromDropdown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    public void selectMultipleFromDropdown(List<String> options){
        options.stream().forEach((o) -> findDropdownElement().selectByVisibleText(o));
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElement = findDropdownElement().getAllSelectedOptions();
        return selectedElement.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropdownElement(){
        return new Select(driver.findElement(dropdown));
    }

    public void setDropdownToMultipleSelect() {
        WebElement dropdownElement = driver.findElement(dropdown);
        String script = "arguments[0].setAttribute('multiple', '')";
        var jsExecutor = (JavascriptExecutor) driver;
        ((JavascriptExecutor)driver).executeScript(script, dropdownElement);
    }

}
