package hover;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NavigationBar;
import pages.RegistrationPage;

public class HoverTests extends BaseTest {

    @Test
    public void testHoveringOverNavigationBarElements(){
        WebDriverWait explicitWait=new WebDriverWait(driver, 10);
        String email = "123whal@email.com";
        RegistrationPage registrationPage = homePage.clickSignUp(email);
        String ExpectedRegisterTitle = "Register";
        String ActualRegisterTitle = driver.getTitle();
        Assert.assertEquals(ExpectedRegisterTitle, ActualRegisterTitle);
        NavigationBar navigationBar = new NavigationBar(driver);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
        navigationBar.hoverNavBar_Home();
        navigationBar.hoverNavBar_WebTable();
        navigationBar.hoverNavBar_SwitchTo();
        navigationBar.hoverNavBar_SwitchTo_Alerts();
        navigationBar.hover(navigationBar.getNavBar_SwitchTo_Windows());
        navigationBar.hover(navigationBar.getNavBar_SwitchTo_Frames());
        navigationBar.hover(navigationBar.getNavBar_Widgets());
        navigationBar.hover(navigationBar.getNavBar_Widgets_Accordion());
        navigationBar.hover(navigationBar.getNavBar_Widgets_AutoComplete());
        navigationBar.hover(navigationBar.getNavBar_Widgets_Datepicker());
        navigationBar.hover(navigationBar.getNavBar_Widgets_Slider());
        navigationBar.hover(navigationBar.getNavBar_Interactions());
        navigationBar.hover(navigationBar.getNavBar_Interactions_DragAndDrop());
        navigationBar.hover(navigationBar.getNavBar_Interactions_DragAndDrop_Dynamic());
        navigationBar.hover(navigationBar.getNavBar_Interactions_DragAndDrop_Static());
        navigationBar.hover(navigationBar.getNavBar_Interactions_Selectable());
        navigationBar.hover(navigationBar.getNavBar_Interactions_Resizable());
        navigationBar.hover(navigationBar.getNavBar_Video());
        navigationBar.hover(navigationBar.getNavBar_Video_Youtube());
        navigationBar.hover(navigationBar.getNavBar_Video_Vimeo());
        navigationBar.hover(navigationBar.getNavBar_WYSIWYG());
        navigationBar.hover(navigationBar.getNavBar_WYSIWYG_TinyMCE());
        navigationBar.hover(navigationBar.getNavBar_WYSIWYG_CKEditor());
        navigationBar.hover(navigationBar.getNavBar_WYSIWYG_CodeMirror());
        navigationBar.hover(navigationBar.getNavBar_WYSIWYG_SummerNote());
        navigationBar.hover(navigationBar.getNavBar_More());
        navigationBar.hover(navigationBar.getNavBar_More_Charts());
        navigationBar.hover(navigationBar.getNavBar_More_DynamicData());
        navigationBar.hover(navigationBar.getNavBar_More_FileDownload());
        navigationBar.hover(navigationBar.getNavBar_More_FileUpload());
        navigationBar.hover(navigationBar.getNavBar_More_JQueryProgressBar());
        navigationBar.hover(navigationBar.getNavBar_More_Loader());
        navigationBar.hover(navigationBar.getNavBar_More_Modals());
        navigationBar.hover(navigationBar.getNavBar_More_ProgressBar());
        navigationBar.hover(navigationBar.getNavBar_PracticeSite());
    }



}
