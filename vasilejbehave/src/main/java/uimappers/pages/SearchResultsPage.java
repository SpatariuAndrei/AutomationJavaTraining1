package uimappers.pages;

import uimappers.components.grid.SearchResultGrid;
import uimappers.components.menu.TopHorizontalMenu;
import uimappers.components.menu.UserMenu;
import uimappers.utils.WebDriverUtilities;

import javax.crypto.SealedObject;

public class SearchResultsPage {
    private TopHorizontalMenu topHorizontalMenu;
    private SearchResultGrid resultGrid;
    private UserMenu userMenu;
    private WebDriverUtilities driverUtilities;

    public SearchResultsPage(){
        topHorizontalMenu = new TopHorizontalMenu();
        driverUtilities = new WebDriverUtilities();
        resultGrid = new SearchResultGrid();
    }

    public void addSearchResultsToFavorites(String product) {
        resultGrid.clickFavoritesIcon(product);
    }

    public WishListPage navigateToFavorites() {
      return  topHorizontalMenu.openFavoritesPage();
    }
}
