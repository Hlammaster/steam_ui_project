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

public class MainPageTests {
    SteamPage steamPage = new SteamPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void headerMenuContentTest() {
        steamPage.openPage();
        steamPage.headerMenuContent();
    }

    @Test
    void searchFieldTest() {
        steamPage.openPage();
        steamPage.searchFieldEnterKey("Cyberpunk");
        steamPage.searchFieldResult();
    }

    @Test
    void searchFieldAppearsInSupportMenuTest() {
        steamPage.openPage();
        steamPage.supportButtonClick();
        steamPage.gamesAndProgramsClick();
        steamPage.verifySearchSupportInputVisible();

    }


    @Test
    void addProductToCardTest() {
        steamPage.openPage();
        steamPage.searchFieldEnterKey("Arx Fatalis");
        steamPage.addToCard();
        steamPage.verifyGameAddToCard();

    }

    @Test
    void friendsSearchTest() {
        steamPage.openPage();
        steamPage.communityButtonClick();
        steamPage.searchFriendsInputEnterKey();
        steamPage.verifyFriendsSearchResult();


    }

    @ParameterizedTest
    @CsvSource(value = {
            "Italiano, Installa Steam",
            "English, Install Steam",
            "Русский, Установить Steam"
    })
    void correctLanguageDisplayTest2(String language, String expectedResult) {
        steamPage.openPage();
        steamPage.clickLanguageButton();
        steamPage.setLanguage(language);
        steamPage.verifyLanguageContentResult(expectedResult);

    }
}
