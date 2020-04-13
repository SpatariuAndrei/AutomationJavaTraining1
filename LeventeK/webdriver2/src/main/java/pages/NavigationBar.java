package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class NavigationBar {

    private WebDriver driver;
    private By navBar_Home = By.linkText("Home");
    private By navBar_WebTable = By.linkText("WebTable");
    private By navBar_SwitchTo = By.linkText("SwitchTo");
    private By navBar_SwitchTo_Alerts = By.linkText("Alerts");
    private By navBar_SwitchTo_Windows = By.linkText("Windows");
    private By navBar_SwitchTo_Frames = By.linkText("Frames");
    private By navBar_Widgets = By.linkText("Widgets");
    private By NavBar_Widgets_Accordion = By.linkText("Accordion");
    private By NavBar_Widgets_AutoComplete = By.linkText("AutoComplete");
    private By NavBar_Widgets_Datepicker = By.linkText("Datepicker");
    private By NavBar_Widgets_Slider =By.linkText("Slider");
    private By NavBar_Interactions = By.linkText("Interactions");
    private By NavBar_Interactions_DragAndDrop  = By.linkText("Drag and Drop");
    private By NavBar_Interactions_DragAndDrop_Static = By.linkText("Static");
    private By NavBar_Interactions_DragAndDrop_Dynamic = By.linkText("Dynamic");
    private By NavBar_Interactions_Selectable = By.linkText("Selectable");
    private By NavBar_Interactions_Resizable = By.linkText("Resizable");
    private By NavBar_Video = By.linkText("Video");
    private By NavBar_Video_Youtube = By.linkText("Youtube");
    private By NavBar_Video_Vimeo= By.linkText("Vimeo");
    private By NavBar_WYSIWYG = By.linkText("WYSIWYG");
    private By NavBar_WYSIWYG_TinyMCE = By.linkText("TinyMCE");
    private By NavBar_WYSIWYG_CKEditor = By.linkText("CKEditor");
    private By NavBar_WYSIWYG_SummerNote = By.linkText("SummerNote");
    private By NavBar_WYSIWYG_CodeMirror = By.linkText("CodeMirror");
    private By NavBar_More = By.linkText("More");
    private By NavBar_More_Charts = By.linkText("Charts");
    private By NavBar_More_DynamicData = By.linkText("Dynamic Data");
    private By NavBar_More_FileDownload = By.linkText("File Download");
    private By NavBar_More_FileUpload = By.linkText("File Upload");
    private By NavBar_More_JQueryProgressBar = By.linkText("JQuery ProgressBar");
    private By NavBar_More_Loader = By.linkText("Loader");
    private By NavBar_More_Modals = By.linkText("Modals");
    private By NavBar_More_ProgressBar = By.linkText("ProgressBar");
    private By NavBar_PracticeSite = By.linkText("Practice Site");



    public NavigationBar(WebDriver driver){
        this.driver = driver;
    }

    public By getNavBar_Home() {
        return navBar_Home;
    }

    public By getNavBar_WebTable() {
        return navBar_WebTable;
    }

    public By getNavBar_SwitchTo() {
        return navBar_SwitchTo;
    }

    public By getNavBar_SwitchTo_Alerts() {
        return navBar_SwitchTo_Alerts;
    }

    public By getNavBar_SwitchTo_Windows() {
        return navBar_SwitchTo_Windows;
    }

    public By getNavBar_SwitchTo_Frames() {
        return navBar_SwitchTo_Frames;
    }

    public By getNavBar_Widgets() {
        return navBar_Widgets;
    }

    public By getNavBar_Widgets_Accordion() {
        return NavBar_Widgets_Accordion;
    }

    public By getNavBar_Widgets_AutoComplete() {
        return NavBar_Widgets_AutoComplete;
    }

    public By getNavBar_Widgets_Datepicker() {
        return NavBar_Widgets_Datepicker;
    }

    public By getNavBar_Widgets_Slider() {
        return NavBar_Widgets_Slider;
    }

    public By getNavBar_Interactions() {
        return NavBar_Interactions;
    }

    public By getNavBar_Interactions_DragAndDrop() {
        return NavBar_Interactions_DragAndDrop;
    }

    public By getNavBar_Interactions_DragAndDrop_Static() {
        return NavBar_Interactions_DragAndDrop_Static;
    }

    public By getNavBar_Interactions_DragAndDrop_Dynamic() {
        return NavBar_Interactions_DragAndDrop_Dynamic;
    }

    public By getNavBar_Interactions_Selectable() {
        return NavBar_Interactions_Selectable;
    }

    public By getNavBar_Interactions_Resizable() {
        return NavBar_Interactions_Resizable;
    }

    public By getNavBar_Video() {
        return NavBar_Video;
    }

    public By getNavBar_Video_Youtube() {
        return NavBar_Video_Youtube;
    }

    public By getNavBar_Video_Vimeo() {
        return NavBar_Video_Vimeo;
    }

    public By getNavBar_WYSIWYG() {
        return NavBar_WYSIWYG;
    }

    public By getNavBar_WYSIWYG_TinyMCE() {
        return NavBar_WYSIWYG_TinyMCE;
    }

    public By getNavBar_WYSIWYG_CKEditor() {
        return NavBar_WYSIWYG_CKEditor;
    }

    public By getNavBar_WYSIWYG_SummerNote() {
        return NavBar_WYSIWYG_SummerNote;
    }

    public By getNavBar_WYSIWYG_CodeMirror() {
        return NavBar_WYSIWYG_CodeMirror;
    }

    public By getNavBar_More() {
        return NavBar_More;
    }

    public By getNavBar_More_Charts() {
        return NavBar_More_Charts;
    }

    public By getNavBar_More_DynamicData() {
        return NavBar_More_DynamicData;
    }

    public By getNavBar_More_FileDownload() {
        return NavBar_More_FileDownload;
    }

    public By getNavBar_More_FileUpload() {
        return NavBar_More_FileUpload;
    }

    public By getNavBar_More_JQueryProgressBar() {
        return NavBar_More_JQueryProgressBar;
    }

    public By getNavBar_More_Loader() {
        return NavBar_More_Loader;
    }

    public By getNavBar_More_Modals() {
        return NavBar_More_Modals;
    }

    public By getNavBar_More_ProgressBar() {
        return NavBar_More_ProgressBar;
    }

    public By getNavBar_PracticeSite() {
        return NavBar_PracticeSite;
    }

    public void hoverNavBar_Home(){
        WebElement navBar_HomeElement = driver.findElement(navBar_Home);

        Actions actions = new Actions(driver);
        actions.moveToElement(navBar_HomeElement).perform();
    }

    public void hoverNavBar_WebTable(){
        WebElement navBar_WebTableElement = driver.findElement(navBar_WebTable);
        Actions actions = new Actions(driver);
        actions.moveToElement(navBar_WebTableElement).perform();
    }

    public void hoverNavBar_SwitchTo(){
        WebElement navBar_SwitchToElement = driver.findElement(navBar_SwitchTo);
        Actions actions = new Actions(driver);
        actions.moveToElement(navBar_SwitchToElement).perform();
    }

    public void hoverNavBar_SwitchTo_Alerts(){
        WebElement navBar_SwitchTo_AlertsElement = driver.findElement(navBar_SwitchTo_Alerts);
        Actions actions = new Actions(driver);
        actions.moveToElement(navBar_SwitchTo_AlertsElement).perform();
    }

    public void hoverNavBar_SwitchTo_Windows(){
        WebElement webElement = driver.findElement(navBar_SwitchTo_Windows);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    public void hoverNavBar_SwitchTo_Frames(){
        WebElement webElement = driver.findElement(navBar_SwitchTo_Windows);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    public void hover(By element){
        WebElement webElement = driver.findElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    public WindowPage hoverAndClickWidowPage(By hoverElement, By clickElement){
        WebElement hoverWebElement = driver.findElement(hoverElement);
        WebElement clickWebElement = driver.findElement(clickElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverWebElement).click(clickWebElement).build().perform();
        return new WindowPage(driver);
    }

    public AlertsPage hoverAndClickAlertsPage(By hoverElement, By clickElement){
        WebElement hoverWebElement = driver.findElement(hoverElement);
        WebElement clickWebElement = driver.findElement(clickElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverWebElement).click(clickWebElement).build().perform();
        return new AlertsPage(driver);
    }

    public DADStaticPage hoverAndClickDADStatic(By hoverElement, By clickElement){
        WebElement hoverWebElement = driver.findElement(hoverElement);
        WebElement clickWebElement = driver.findElement(clickElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverWebElement).click(clickWebElement).build().perform();
        return new DADStaticPage(driver);
    }

    public DADDynamicPage hoverAndClickDADDynamic(By hoverElement, By clickElement){
        WebElement hoverWebElement = driver.findElement(hoverElement);
        WebElement clickWebElement = driver.findElement(clickElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverWebElement).click(clickWebElement).build().perform();
        return new DADDynamicPage(driver);
    }

    public DynamicDataPage hoverAndClickDynamicData(By hoverElement, By clickElement){
        WebElement hoverWebElement = driver.findElement(hoverElement);
        WebElement clickWebElement = driver.findElement(clickElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverWebElement).click(clickWebElement).build().perform();
        return new DynamicDataPage(driver);
    }

}
