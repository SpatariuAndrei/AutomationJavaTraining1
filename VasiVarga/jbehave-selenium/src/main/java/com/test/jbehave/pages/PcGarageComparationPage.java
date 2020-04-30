package com.test.jbehave.pages;

import com.test.jbehave.utils.Driver;

public class PcGarageComparationPage extends BasePageObject {

    public boolean seeIfImOnTheRightPage(){
        return Driver.driver.getCurrentUrl().contains("https://www.pcgarage.ro/compara");
    }
}
