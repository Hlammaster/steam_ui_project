package tests;

import org.junit.jupiter.api.Test;
import pages.CartPage;

public class CartTests extends TestBase {
    CartPage cartPage = new CartPage();
    String game = "Arx Fatalis",
            game2 = "Max Payne 3";

    @Test
    void addProductToCardTest() {
        cartPage.openPage().
                searchFieldEnterKey(game).
                addToCard().
                verifyGameAddToCard();

    }

    @Test
    public void blabla() {
        cartPage.openPage()
                .searchFieldEnterKey(game2)
                .addToCard()
                .verifyGameAddToCard()
                .removeButtonClick()
                .verifyGameRemoveFromCart();

    }
}