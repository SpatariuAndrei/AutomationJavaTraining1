package guru99;

import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.*;

public class DownloadFile {
    public static void main(String[] args) {

        String filePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", filePath);
        String baseUrl = "http://demo.guru99.com/test/yahoo.html";
        String downloadPath = "C:\\Users\\lcoroama\\Downloads";
        WebDriver driver = new ChromeDriver();

        driver.get(baseUrl);
        WebElement downloadButton = driver.findElement(By
                .id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P " + downloadPath +" --no-check-certificate " + sourceLocation;

        try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        } catch (InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
        driver.close();
    }

}