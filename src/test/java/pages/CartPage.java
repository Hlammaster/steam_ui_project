package pages;

import com.codeborne.selenide.SelenideElement;
import components.ContentVerifyModal;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {
    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();
    private SelenideElement
            searchInput = $("#store_nav_search_term"),
            firstGameInTheList = $(".responsive_search_name_combined"),
            addToCardButton = $(".btn_green_steamui"),
            removeButton = $(".remove_link");

    public CartPage openPage() {
        open("https://store.steampowered.com/");

        return this;
    }

    public CartPage searchFieldEnterKey(String key) {
        searchInput.setValue(key).pressEnter();

        return this;
    }

    public CartPage addToCard() {
        firstGameInTheList.click();
        addToCardButton.click();

        return this;
    }

    public CartPage verifyGameAddToCard() {
        contentVerifyModal.verifyGameAddToCart();

        return this;
    }

    public CartPage removeButtonClick() {
        removeButton.click();

        return this;
    }

    public CartPage verifyGameRemoveFromCart() {
        contentVerifyModal.verifyGameRemoveFromCart();

        return this;
    }

}
