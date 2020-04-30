package com.test.jbehave.pages;

import com.test.jbehave.utils.Driver;


public class PcGarageHomePage extends BasePageObject {

    public void open(String url) {
        Driver.driver.get(url);
    }

}
