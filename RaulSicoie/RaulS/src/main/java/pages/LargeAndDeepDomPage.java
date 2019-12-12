package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LargeAndDeepDomPage {

    private WebDriver driver;
    @FindBy(id = "large-table")
    private WebElement table;

    LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void scrollToTable(){
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, table);
    }

    public boolean isTableVisible(){
        return table.isDisplayed();
    }
}
