package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {
private WebDriver driver;
private By inputKeysField = By.id("target");
private By resultText = By.id("result");




public KeyPressesPage  (WebDriver driver){
    this.driver = driver;

}
public void specialKeysInputField (String specialKeys){
    driver.findElement(inputKeysField).sendKeys(specialKeys);


}
public String getResult (){
    return driver.findElement(resultText).getText();


}
public void enterHashtag(){
    specialKeysInputField(Keys.chord(Keys.LEFT_SHIFT,"3"));


}


}

