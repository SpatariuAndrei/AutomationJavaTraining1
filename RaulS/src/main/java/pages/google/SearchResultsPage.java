package pages.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    private WebDriver driver;
    @FindBy(xpath = "//div[@class='a4bIc']//input[@name='q']")
    private WebElement searchBox;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getResult(){
        return searchBox.getAttribute("value");
    }

}
