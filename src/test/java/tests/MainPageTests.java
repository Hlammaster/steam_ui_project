package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.SteamPage;

@Owner("Evgenii Goncharov")
@Epic("UI")
public class MainPageTests extends TestBase {
    SteamPage steamPage = new SteamPage();
    Faker faker = new Faker();

    String game = faker.esports().game(),
            player = faker.name().firstName();

    @DisplayName("Проверка содержимого хэдер меню")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void headerMenuContentTest() {
        steamPage.openPage()
                .headerMenuContent();
    }

    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка результа выдачи поиска")
    @Test
    void searchFieldTest() {
        steamPage.openPage()
                .searchFieldEnterKey(game)
                .searchFieldResult(game);
    }

    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка наличия поискового запроса при выборе категории в меню Поддержка")
    @Test
    void searchFieldAppearsInSupportMenuTest() {
        steamPage.openPage()
                .supportButtonClick()
                .gamesAndProgramsClick()
                .verifySearchSupportInputVisible();

    }

    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка результаты выдачи поиска по Игрокам")
    @Test
    void friendsSearchTest() {
        steamPage.openPage()
                .communityButtonClick()
                .searchFriendsInputEnterKey(player)
                .verifyFriendsSearchResult(player);


    }
@DisplayName("Проверка корректного отображения текста при смене языка")
    @Severity(SeverityLevel.CRITICAL)
    @ParameterizedTest
    @CsvSource(value = {
            "Italiano, Installa Steam",
            "Deutsch, Steam installieren",
            "Русский, Установить Steam"
    })
    void correctLanguageDisplayTest2(String language, String expectedResult) {
        steamPage.openPage()
                .clickLanguageButton()
                .setLanguage(language)
                .verifyLanguageContentResult(expectedResult);

    }
}
