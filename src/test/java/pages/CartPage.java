package pages;

import com.codeborne.selenide.SelenideElement;
import components.ContentVerifyModal;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CartPage {
    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();
    private SelenideElement
            searchInput = $("#store_nav_search_term"),
            firstGameInTheList = $(".responsive_search_name_combined"),
            addToCardButton = $(".btn_green_steamui"),
            removeButton = $(".remove_link");
@Step("Открыть сайт 'https://store.steampowered.com'")
    public CartPage openPage() {
        open("https://store.steampowered.com/");

        return this;
    }

    public CartPage searchFieldEnterKey(String key) {
        step("Ввести в поле поиска" + key, () ->
        searchInput.setValue(key).pressEnter());

        return this;
    }
@Step("Нажать добавить в корзину")
    public CartPage addToCard() {
        firstGameInTheList.click();
        addToCardButton.click();

        return this;
    }
@Step("Проверить, что игра добавилась в корзину")
    public CartPage verifyGameAddToCard() {
        contentVerifyModal.verifyGameAddToCart();

        return this;
    }
@Step("Нажать кнопку 'удалить'")
    public CartPage removeButtonClick() {
        removeButton.click();

        return this;
    }
@Step("Проверить, что игра удалилась из корзины")
    public CartPage verifyGameRemoveFromCart() {
        contentVerifyModal.verifyGameRemoveFromCart();

        return this;
    }

}
