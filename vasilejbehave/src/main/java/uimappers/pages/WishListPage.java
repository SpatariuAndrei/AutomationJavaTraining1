package uimappers.pages;

import uimappers.components.containers.WishlistContainer;

import static driverprovider.DriverInstance.getDriver;

public class WishListPage {
    
    private WishlistContainer wishlistContainer;


    public WishListPage() {
        wishlistContainer = new WishlistContainer();
    }

    public boolean verifyIfProductIsPresent(String product) {
        return  wishlistContainer.checkIfProductIsPresent(product);
    }

    public void removeAllProductsFromWishList(){
        wishlistContainer.removeProductsFromWhishList();
    }

    public int productsInWishList(){
       return wishlistContainer.wishlistSize();
    }

}
