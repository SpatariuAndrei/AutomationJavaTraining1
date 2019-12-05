package uimappers.pages;

import uimappers.components.menu.TopHorizontalMenu;
import uimappers.components.menu.UserMenu;
import utilities.SharedData;

public class UserHomePage {
    private SharedData sharedData;

    private TopHorizontalMenu topHorizontalMenu;
    private UserMenu userMenu;

    public UserHomePage(SharedData sharedData) {
        this.sharedData = sharedData;
        topHorizontalMenu = new TopHorizontalMenu(sharedData);
        userMenu = new UserMenu(sharedData);
    }
    public String greetMessage(String userName) {
        return userMenu.getUserGreetMessage(userName);
    }
}
