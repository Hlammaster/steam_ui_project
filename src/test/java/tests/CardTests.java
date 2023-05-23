package tests;

import org.junit.jupiter.api.Test;
import pages.CardPage;
import pages.SteamPage;

public class CardTests extends TestBase {
    CardPage cardPage = new CardPage();
    String game = "Arx Fatalis";

    @Test
    void addProductToCardTest() {
        cardPage.openPage().
                searchFieldEnterKey(game).
                addToCard().
                verifyGameAddToCard();

    }
}
