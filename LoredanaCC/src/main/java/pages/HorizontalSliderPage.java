package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HorizontalSliderPage {

    WebDriver driver;
    @FindBy(id = "email")
    private WebElement emailTextField;
    @FindBy(xpath = "//button[@id='form_submit']")
    private WebElement retrivePasswordBtn;
    @FindBy(xpath = "//div[@class='sliderContainer']//input")
    private WebElement slider;
    @FindBy(xpath = "//span[@id='range']")
    private WebElement sliderValue;

    HorizontalSliderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void sendKeys(int value) {
        while (Double.parseDouble(sliderValue.getText()) < value) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getValue() {
        return sliderValue.getText();
    }
}
