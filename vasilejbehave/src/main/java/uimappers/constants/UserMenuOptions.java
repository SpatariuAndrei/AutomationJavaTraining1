package uimappers.constants;

public enum UserMenuOptions {
    COMENZILE_MELE("Comenzile mele"),
    CARDURILE_MELE("Cardurile mele"),
    FAVORITE("Favorite"),
    CARD_EMAG("Card eMag"),
    LISTA_SUPERMARKET("Lista Supermarket"),
    VOUCHERE_CARDURI_CADOU(" Vouchere & carduri cadou"),
    REVIEW_URILE_MELE("Review-urile mele"),
    GARANTIILE_MELE("GARANTIILE MELE"),
    RETUR("RETUR"),
    SERVICE("SERVICE"),
    DATE_PERSONALE("Date personale"),
    SETARI_SIGURANTA("Setari siguranta"),
    ABONARILE_MELE("Abonarile mele"),
    LOG_OUT("Log out");

    private String userMenuOption;

    UserMenuOptions(String userMenuOption) {
        this.userMenuOption = userMenuOption;
    }

    public String getUserMenuOptionValue() {
        return this.userMenuOption;
    }
}