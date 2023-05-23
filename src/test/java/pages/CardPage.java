package pages;

import com.codeborne.selenide.SelenideElement;
import components.ContentVerifyModal;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardPage {
    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();
    private SelenideElement
            searchInput = $("#store_nav_search_term"),
            firstGameInTheList = $(".responsive_search_name_combined"),
            addToCardButton = $("#btn_add_to_cart_302");

    public CardPage openPage() {
        open("https://store.steampowered.com/");

        return this;
    }

    public CardPage searchFieldEnterKey(String key) {
        searchInput.setValue(key).pressEnter();

        return this;
    }

    public CardPage addToCard() {
        firstGameInTheList.click();
        addToCardButton.click();

        return this;
    }

    public CardPage verifyGameAddToCard() {
        contentVerifyModal.verifyGameAddToCard();

        return this;
    }

}
