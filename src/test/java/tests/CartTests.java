package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
@Owner("Evgenii Goncharov")
@Epic("UI")
@Severity(SeverityLevel.CRITICAL)
public class CartTests extends TestBase {
    CartPage cartPage = new CartPage();
    String game = "Arx Fatalis",
            game2 = "Max Payne 3";
    @DisplayName("Добавление игры в корзину")
    @Test
    void addProductToCardTest() {
        cartPage.openPage().
                searchFieldEnterKey(game)
                .choseTheGame()
                .addToCard()
                .verifyGameAddToCard();

    }
    @DisplayName("Удаление игры из корзины")
    @Test
    public void removeProductFromCartTest() {
        cartPage.openPage()
                .searchFieldEnterKey(game2)
                .choseTheGame()
                .addToCard()
                .verifyGameAddToCard()
                .removeButtonClick()
                .verifyGameRemoveFromCart();

    }
}