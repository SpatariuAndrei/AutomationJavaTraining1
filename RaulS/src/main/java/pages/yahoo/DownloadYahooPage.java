package pages.yahoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class DownloadYahooPage {

    private WebDriver driver;
    @FindBy(id = "messenger-download")
    private WebElement downloadButton;

    public DownloadYahooPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDownload() {
        downloadButton.click();
        String sourceLocation = downloadButton.getAttribute("href");
        String downloadsFilePath = System.getProperty("user.home");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P " + downloadsFilePath + "\\downloads --no-check-certificate "
                + sourceLocation;
        try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            exec.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
