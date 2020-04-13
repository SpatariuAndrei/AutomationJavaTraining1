package pages;

import dataObjects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class DynamicDataPage {

    private WebDriver driver;
    private By generateButton;
    private By idOfObject = By.id("loading");
    private List<User> userList = new ArrayList<>();

    public DynamicDataPage(WebDriver driver){
        this.driver = driver;
        generateButton = By.xpath("//*[@id=\"save\"]");
    }

    private Image getImage(URL imageURL) throws IOException {
        return ImageIO.read(imageURL);
    }


    public void generateUser() throws IOException {
        driver.findElement(generateButton).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"loading\"]/img"))));

        while(true){
            if(element.getAttribute("src").contains("at_spinner.gif"))
            break;
        }

        String imageSRC = driver.findElement(By.xpath("//*[@id=\"loading\"]/img")).getAttribute("src");
        URL imageURL = new URL(imageSRC);

        String name = driver.findElement(idOfObject).getAttribute("innerText");
        Image userImg = getImage(imageURL);

        userList.add(new User(name,userImg));
    }
}
