package com.test.jbehave.pages;

import com.test.jbehave.base.Driver;
import com.test.jbehave.base.Page;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Page {

    private String HOME_URL = "https://emag.ro";

    @FindBy (id = "searchboxTrigger")
    WebElement searchBox;

    public void go() {
        Driver.driver.get(HOME_URL);
    }

    public SearchResult enterSearchQuery(String query){
        type(searchBox,query+ Keys.ENTER);
        return new SearchResult();
    }
}
