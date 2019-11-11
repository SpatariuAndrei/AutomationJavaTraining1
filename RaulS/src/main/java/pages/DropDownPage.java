package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage {

    private WebDriver driver;

    @FindBy(id="dropdown")
     private WebElement dropdown;

     DropDownPage(WebDriver driver) {
        this.driver = driver;
         PageFactory.initElements(driver,this);
    }

    public void selectFromDropDown(String option) {
        findDropDownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
       List<WebElement> selectedWebElements =  findDropDownElement().getAllSelectedOptions();
       return selectedWebElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public void addMultipleAttribute(){
         String script = "arguments[0].setAttribute('multiple','')";
        ((JavascriptExecutor)driver).executeScript(script, findDropDownElement());
    }

    private Select findDropDownElement() {
        return new Select(dropdown);
    }
}
