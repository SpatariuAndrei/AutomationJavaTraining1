package pageTests;

import navBar.DropdownMenu;
import org.testng.Assert;
import org.testng.annotations.Test;
import setUpTest.SetUp;

public class TestHover extends SetUp {

    @Test
    public void TestHover(){

        var signUpPage = homePage.clickSkipButton();

        DropdownMenu switchToMenuItems = signUpPage.hoverOverMenuItem("SwitchTo");
        Assert.assertTrue(switchToMenuItems.isMenuListDisplayed());
        Assert.assertEquals(switchToMenuItems.count(),3);


        DropdownMenu widgetsMenuItems = signUpPage.hoverOverMenuItem("Widgets");
        Assert.assertTrue(widgetsMenuItems.isMenuListDisplayed());
        Assert.assertEquals(widgetsMenuItems.count(),4);

        DropdownMenu interactionsMenuItems = signUpPage.hoverOverMenuItem("Interactions");
        Assert.assertTrue(interactionsMenuItems.isMenuListDisplayed());
        Assert.assertEquals(interactionsMenuItems.count(),5);

        DropdownMenu videoMenuItems = signUpPage.hoverOverMenuItem("Video");
        Assert.assertTrue(videoMenuItems.isMenuListDisplayed());
        Assert.assertEquals(videoMenuItems.count(),2);


        DropdownMenu WYSIWYGmenuItems = signUpPage.hoverOverMenuItem("WYSIWYG");
        Assert.assertTrue(WYSIWYGmenuItems.isMenuListDisplayed());
        Assert.assertEquals(WYSIWYGmenuItems.count(),4);

        DropdownMenu moreMenuItems = signUpPage.hoverOverMenuItem("More");
        Assert.assertTrue(moreMenuItems.isMenuListDisplayed());
        Assert.assertEquals(moreMenuItems.count(),8);


        signUpPage.hoverOverMenuItem("SwitchTo").clickMenuItem("Alerts");


    }

}
