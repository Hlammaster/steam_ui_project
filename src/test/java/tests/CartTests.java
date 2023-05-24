package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;

@Owner("Evgenii Goncharov")
@Epic("UI")
@Severity(SeverityLevel.CRITICAL)
public class CartTests extends TestBase {
    CartPage cartPage = new CartPage();
    Faker faker = new Faker();
    String game = faker.esports().game();


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
                .searchFieldEnterKey(game)
                .choseTheGame()
                .addToCard()
                .verifyGameAddToCard()
                .removeButtonClick()
                .verifyGameRemoveFromCart();

    }
}