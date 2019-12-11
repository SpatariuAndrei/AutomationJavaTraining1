package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.Keys.*;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By rangeValue = By.id("range");
    @FindBy(xpath = "//div[@class='sliderContainer']//input")
    private WebElement slider;

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterKey(Keys key) {
        slider.sendKeys(key);
    }

    public void moveSlider(float desiredValue) {
        if (Float.parseFloat(getValue()) < desiredValue) {
            //Or you can use the next line instead of enterKey method
            // slider.sendKeys(ARROW_RIGHT);
            enterKey(ARROW_RIGHT);
            moveSlider(desiredValue);
        }
        if (Float.parseFloat(getValue()) > desiredValue) {
            enterKey(ARROW_LEFT);
            moveSlider(desiredValue);
        }
    }

    public String getValue() {
        return driver.findElement(rangeValue).getText();
    }
}
