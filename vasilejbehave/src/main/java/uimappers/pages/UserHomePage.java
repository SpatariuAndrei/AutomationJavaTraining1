package uimappers.pages;

import uimappers.components.menu.UserMenu;

public class UserHomePage {
    private UserMenu userMenu;

    public UserHomePage() {
        userMenu = new UserMenu();
    }
    public String greetMessage(String userName) {
        return userMenu.getUserGreetMessage(userName);
    }
}
