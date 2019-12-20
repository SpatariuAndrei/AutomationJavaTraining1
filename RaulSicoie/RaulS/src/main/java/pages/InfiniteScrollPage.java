package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InfiniteScrollPage {

    private WebDriver driver;
    @FindBy(className = "jscroll-added")
    private List<WebElement> textBlocks;
    private int paragraphIndex;

    public int getParagraphIndex() {
        return paragraphIndex;
    }

    public void setParagraphIndex(int paragraphIndex) {
        this.paragraphIndex = paragraphIndex;
    }

    InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Scrolls until paragraph with index specified is in view
     *
     * @param index 1-based
     */
    public void scrollToParagraph(int index) {
        setParagraphIndex(index);
        String script = "window.scrollTo(0,document.body.scrollHeight)";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        while (getNumberOfParagraphsPresent() < index) {
            javascriptExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphsPresent() {
        return textBlocks.size();
    }


    public boolean isParagraphDisplayed() {
        String path = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[" + getParagraphIndex() + "]";
        WebElement paragraphPath = driver.findElement(By.xpath(path));
        return paragraphPath.isDisplayed();
    }
}
