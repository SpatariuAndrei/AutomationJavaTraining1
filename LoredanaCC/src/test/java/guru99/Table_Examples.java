package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table_Examples {

    public static void main(String[] args) throws ParseException {
     // getSpecificCell();
      //noOfRowsAndCols();
        maxFromColumn();
    }

    public static void noOfRowsAndCols() throws ParseException{
                 String baseUrl = "http://demo.guru99.com/test/newtours/";
                 String filePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", filePath);
                 WebDriver wd= new ChromeDriver();
                wd.get("http://demo.guru99.com/test/web-table-element.php");
                //No.of Columns
                List  col = wd.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
                System.out.println("No of cols are : " +col.size());
                //No.of rows
                List  rows = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
                System.out.println("No of rows are : " + rows.size());
                wd.close();
        }

    public static void getSpecificCell() {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String filePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", filePath);
        WebDriver driver = new ChromeDriver();
        driver.get(baseUrl);
        String innerText = driver.findElement(By.xpath("//table/tbody/tr/td[2]"
                + "//table/tbody/tr[4]/td/"
                + "table/tbody/tr/td[2]/"
                + "table/tbody/tr[2]/td[1]/"
                + "table[2]/tbody/tr[3]/td[2]/font"))
                .getText();
        System.out.println(innerText);
        driver.quit();
    }

    public static void maxFromColumn() throws ParseException {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String filePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", filePath);
        WebDriver wd = new ChromeDriver();
        wd.get("http://demo.guru99.com/test/web-table-element.php");
        String max;
        double m=0,r=0;

        //No. of Columns
        List  col = wd.findElements(By.xpath(".//*[@id='leftcontainer']/table/thead/tr/th"));
        System.out.println("Total No of columns are : " +col.size());
        //No.of rows
        List  rows = wd.findElements(By.xpath (".//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("Total No of rows are : " + rows.size());
        for (int i =1;i<rows.size();i++)
        {
            max= wd.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[" + (i+1)+ "]/td[4]")).getText();
            NumberFormat f =NumberFormat.getNumberInstance();
            Number num = f.parse(max);
            max = num.toString();
            m = Double.parseDouble(max);
            if(m>r)
            {
                r=m;
            }
        }
        System.out.println("Maximum current price is : "+ r);
    }
}
