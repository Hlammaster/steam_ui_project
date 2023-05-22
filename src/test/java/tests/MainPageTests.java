package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void headerMenuContentTest() {
        open("https://store.steampowered.com/");
        $(".supernav_container").shouldHave(Condition.text("МАГАЗИН"), Condition.text("СООБЩЕСТВО"),
                Condition.text("О STEAM"), Condition.text("ПОДДЕРЖКА"));
    }

    @Test
    void searhFieldTest() {
        open("https://store.steampowered.com/");
        $("#store_nav_search_term").setValue("Cyberpunk").pressEnter();
        $("#search_resultsRows").shouldHave(Condition.text("Cyberpunk"));
    }

    @Test
    void searchFieldAppearsInSupportMenuTest() {
        open("https://store.steampowered.com/");
        $(".supernav_container").$(byText("ПОДДЕРЖКА")).click();
        $("[href='https://help.steampowered.com/ru/wizard/HelpWithGame']").click();
        $("#help_search_support_input").shouldBe(Condition.visible);

    }


    @Test
    void addProductToCardTest() {
        open("https://store.steampowered.com/");
        $("#store_nav_search_term").setValue("Arx Fatalis").pressEnter();
        $(".responsive_search_name_combined").click();
        $("#btn_add_to_cart_302").click();
        $(".pageheader").shouldHave(Condition.text("Ваша корзина"));
        $(".cart_status_message").shouldHave(Condition.text("Ваш товар был добавлен!"));

    }

    @Test
    void friendsSearchTest() {
        open("https://store.steampowered.com/");
        $(".supernav_container").$(byText("СООБЩЕСТВО")).click();
        $("#SearchPlayers").setValue("Qa automation").pressEnter();
        $("#search_results").shouldHave(Condition.text("automation"));


    }

    @ParameterizedTest
    @CsvSource(value = {
            "Italiano, Installa Steam",
            "English, Install Steam",
            "Русский, Установить Steam"
    })
    void correctLanguageDisplayTest2(String language, String expectedResult) {
        open("https://store.steampowered.com/");
        $("#language_pulldown").click();
        $("#language_dropdown").$(withText(language)).click();
        $(".header_installsteam_btn_content").shouldHave(Condition.text(expectedResult));

    }
}
