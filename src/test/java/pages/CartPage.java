package pages;

import com.codeborne.selenide.SelenideElement;
import components.ContentVerifyModal;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CartPage {
    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();
    private final SelenideElement
            searchInput = $("#store_nav_search_term"),
            firstGameInTheList = $(".responsive_search_name_combined"),
            addToCardButton = $(".btn_green_steamui"),
            removeButton = $(".remove_link");

    public CartPage openPage() {
        step("Открыть страницу 'https://store.steampowered.com/'", () ->
                open("https://store.steampowered.com/"));

        return this;
    }

    public CartPage searchFieldEnterKey(String game1) {
        step("Ввести в поле поиска " + game1, () ->
                searchInput.setValue(game1).pressEnter());

        return this;
    }

    public CartPage addToCard() {
        step("Добавить товар в корзину", () ->

                addToCardButton.click());

        return this;
    }

    public CartPage choseTheGame() {
        step("Выбрать игру из списка", () ->
                firstGameInTheList.click());


        return this;
    }

    public CartPage verifyGameAddToCard() {
        step("Проверить, что игра добавилась в корзину", () ->
                contentVerifyModal.verifyGameAddToCart());

        return this;
    }

    public CartPage removeButtonClick() {
        step("Нажать кнопку 'удалить'", () ->
                removeButton.click());

        return this;
    }

    public CartPage verifyGameRemoveFromCart() {
        step("Проверить, что игра удалилась из корзины", () ->
                contentVerifyModal.verifyGameRemoveFromCart());

        return this;
    }

}
