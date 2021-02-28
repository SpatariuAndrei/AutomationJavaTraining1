package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By clickSlider = By.cssSelector(".sliderContainer input");
    private By rangeText = By.id("range");


    public HorizontalSliderPage (WebDriver driver){
        this.driver = driver;


    }
    public void clickHorizontalSlider(){
        driver.findElement(clickSlider).sendKeys(Keys.ARROW_RIGHT);

    }
    public String getRangeText(){
       return driver.findElement(rangeText).getText();


    }

  }



