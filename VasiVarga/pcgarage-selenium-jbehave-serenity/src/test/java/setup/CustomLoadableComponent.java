package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import pageobjects.PcGarageLoginSignUpPage;
import utils.SharedData;

import java.util.concurrent.TimeUnit;

public abstract class CustomLoadableComponent <T extends CustomLoadableComponent<T>>{

    SharedData sharedData;

    @FindBy(linkText = "Contul meu")
    protected WebElement myAccountLink;

    @FindBy(id = "searchac")
    protected WebElement searchTextBox;

    @FindBy(id = "cookie_agree")
    protected WebElement acceptCookies;

    private static final int LOAD_TIMEOUT = 30;
    private static final int REFRESH_RATE = 2;

    @SuppressWarnings("unchecked")
    public T get() {
        try {
            isLoaded();
            return (T) this;
        } catch (Error e) {
            System.out.println("Error encountered during page load: " + e.getMessage());
            load();
        }

        isLoaded();

        return (T) this;
    }

    protected abstract void load();

    protected abstract void isLoaded() throws Error;



    protected void waitForPageToLoad(ExpectedCondition pageLoadCondition) {
        Wait wait = new FluentWait(sharedData.driver)
                .withTimeout(LOAD_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(REFRESH_RATE, TimeUnit.SECONDS);

        wait.until(pageLoadCondition);
    }

    public void type(WebElement input, String text) {
        input.sendKeys(text);
    }

    public WebElement find(By locator) {
        return sharedData.driver.findElement(locator);
    }

    public PcGarageLoginSignUpPage goToMyAccount(){
        myAccountLink.click();
        return new PcGarageLoginSignUpPage(sharedData);
    }
}
