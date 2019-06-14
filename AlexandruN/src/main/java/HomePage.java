import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    /**
     * All elements are identified by @FindBY annotation
     */
    private WebDriver driver;
    @FindBy(id = "emg-input-autosuggest")
    private  WebElement searchBar;

    @FindBy(id = "emg-category-menu-icon")
    private  WebElement searchButton;

    @FindBy(xpath = "/html/body/div[1]/header/div[3]/div/div")
    private  WebElement mainMenu;

    @FindBy(linkText = "/newsletter/2019_06_04_she_vcr_tb_y_1/?ref=hdr_promotiile-saptamanii")
    private  WebElement promotiileSaptamanii;

    @FindBy(className = "resealed-header-quick-link")
    private  WebElement resigilate;

    @FindBy(linkText = "Newsletter")
    private  WebElement newsletter;

    @FindBy(linkText = "/campaign/programul-rabla-pentru-electrocasnice-mari?ref=hdr_programul-rabla")
    private  WebElement programulRabla;
   /* @FindBy(className = "emg-fluid-sub-menu-wrapper")
    private WebElement mainMenu;*/

    //private List<WebElement> mainMenuList=mainMenu.findElements(By.className(""));
    @FindBy(xpath = ".//div[@class='emg-top-menu emg-fluid-top-menu main-megamenu-trigger']")
    private WebElement optiuneProduse;

    //private List<WebElement> megaMenu=optiuneProduse.findElements(By.className("megamenu-list-department js-megamenu-list-department"));
    @FindBy(linkText = "Electrocasnice & Climatizare")
    private WebElement electrocasnice;

    @FindBy(id="emg-mini-cart")
    private WebElement cosulMeu;

    @FindBy(id="emg-user-fav")
    private WebElement favotite;

    @FindBy(id="emg-user-menu")
    private WebElement contulMeu;


    @FindBy(linkText = "Comenzile mele")
    private WebElement comenzileMele;

    @FindBy(linkText="Cardurile mele")
    private WebElement cardurileMele;

    @FindBy(linkText="Favorite")
    private WebElement favorite;

    @FindBy(linkText="Card eMAG")
    private WebElement cardEmag;;

    @FindBy(linkText="Lista Supermarket")
    private WebElement listaSuperMarket;

    @FindBy(linkText="Vouchere & carduri cadou")
    private WebElement vouchere;

    @FindBy(linkText="Review-urile mele")
    private WebElement reviews;

    @FindBy(linkText="Garantiile mele")
    private WebElement guarantees;

    @FindBy(linkText="Retur")
    private WebElement returns;

    @FindBy(linkText="Service")
    private WebElement servicii;

    @FindBy(linkText="Date personale")
    private WebElement personalData;

    @FindBy(linkText="Setari siguranta")
    private WebElement security;

    @FindBy(linkText="Abonarile mele")
    private WebElement abonari;

    @FindBy(linkText="/user/logout?ref=ua_logout")
    private WebElement logOut;

    @FindBy(linkText = "Frigidere")
    private WebElement fridge;

    @FindBy(linkText = "Masini de spalat rufe")
    private WebElement masini;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getMaisni(){
        return masini;
    }
    public WebDriver getDriver() {
        return driver;
    }
    public WebElement getFridge() {
        return fridge;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }
    public WebElement getElectrocasnice() {
        return electrocasnice;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getMainMenu() {
        return mainMenu;
    }

    public WebElement getPromotiileSaptamanii() {
        return promotiileSaptamanii;
    }

    public WebElement getResigilate() {
        return resigilate;
    }

    public WebElement getNewsletter() {
        return newsletter;
    }

    public WebElement getProgramulRabla() {
        return programulRabla;
    }

    public WebElement getOptiuneProduse() {
        return optiuneProduse;
    }

   /* public List<WebElement> getMegaMenu() {
        return megaMenu;
    }*/

    public WebElement getCosulMeu() {
        return cosulMeu;
    }

    public WebElement getFavotite() {
        return favotite;
    }

    public WebElement getContulMeu() {
        return contulMeu;
    }

    public WebElement getComenzileMele() {
        return comenzileMele;
    }

    public WebElement getCardurileMele() {
        return cardurileMele;
    }

    public WebElement getFavorite() {
        return favorite;
    }

    public WebElement getCardEmag() {
        return cardEmag;
    }

    public WebElement getListaSuperMarket() {
        return listaSuperMarket;
    }

    public WebElement getVouchere() {
        return vouchere;
    }

    public WebElement getReviews() {
        return reviews;
    }

    public WebElement getGuarantees() {
        return guarantees;
    }

    public WebElement getReturns() {
        return returns;
    }

    public WebElement getServicii() {
        return servicii;
    }

    public WebElement getPersonalData() {
        return personalData;
    }

    public WebElement getSecurity() {
        return security;
    }

    public WebElement getAbonari() {
        return abonari;
    }

    public WebElement getLogOut() {
        return logOut;
    }
}
