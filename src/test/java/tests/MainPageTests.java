package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SteamPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageTests extends TestBase {
    SteamPage steamPage = new SteamPage();
    String game = "Cyberpunk",
            player = "Qa automation";

    @Test
    void headerMenuContentTest() {
        steamPage.openPage();
        steamPage.headerMenuContent();
    }

    @Test
    void searchFieldTest() {
        steamPage.openPage();
        steamPage.searchFieldEnterKey(game);
        steamPage.searchFieldResult(game);
    }

    @Test
    void searchFieldAppearsInSupportMenuTest() {
        steamPage.openPage();
        steamPage.supportButtonClick();
        steamPage.gamesAndProgramsClick();
        steamPage.verifySearchSupportInputVisible();

    }


    @Test
    void friendsSearchTest() {
        steamPage.openPage();
        steamPage.communityButtonClick();
        steamPage.searchFriendsInputEnterKey(player);
        steamPage.verifyFriendsSearchResult(player);


    }

    @ParameterizedTest
    @CsvSource(value = {
            "Italiano, Installa Steam",
            "Deutsch, Steam installieren",
            "Русский, Установить Steam"
    })
    void correctLanguageDisplayTest2(String language, String expectedResult) {
        steamPage.openPage();
        steamPage.clickLanguageButton();
        steamPage.setLanguage(language);
        steamPage.verifyLanguageContentResult(expectedResult);

    }
}
