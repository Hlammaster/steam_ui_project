package pages;

import com.codeborne.selenide.SelenideElement;
import components.ContentVerifyModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPage {
    private final SelenideElement
            searchInput = $("#store_nav_search_term"),
            supportButton = $(".supernav_container").$(byText("SUPPORT")),
            gamesAndProgramsButton = $("[href='https://help.steampowered.com/en/wizard/HelpWithGame']"),
            communityButton = $(".supernav_container").$(byText("COMMUNITY")),
            searchPlayersInput = $("#SearchPlayers"),
            languageButton = $("#language_pulldown"),
            languageDropDownList = $("#language_dropdown");

    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();

    public MainPage openPage() {
        step("Открыть страницу 'https://store.steampowered.com/'", () ->
                open("https://store.steampowered.com/"));

        return this;
    }

    public MainPage headerMenuContent() {
        step("Проверить наличие подразделов в хедер меню", () ->
                contentVerifyModal.verifyHeaderMenuContent());

        return this;
    }

    public MainPage searchFieldEnterKey(String key) {
        step("Ввести в поле поиска название игры " + key, () ->
                searchInput.setValue(key).pressEnter());

        return this;
    }

    public MainPage searchFieldResult(String game) {
        step("Проверить, что в списке появлился " + game, () ->
                contentVerifyModal.verifySearchFieldResult(game));

        return this;
    }


    public MainPage supportButtonClick() {
        step("Кликнуть кнопку 'Support'", () ->
                supportButton.click());

        return this;
    }

    public MainPage gamesAndProgramsClick() {
        step("Нажать на вкладку Games,Programs", () ->
                gamesAndProgramsButton.click());

        return this;
    }

    public MainPage verifySearchSupportInputVisible() {
        step("Проверить, что появилось поле поиска", () ->
                contentVerifyModal.verifySearchSupportInputVisible());

        return this;
    }


    public MainPage communityButtonClick() {
        step("Кликнуть кнопку 'Community'", () ->
                communityButton.click());

        return this;
    }

    public MainPage searchFriendsInputEnterKey(String player) {
        step("Ввести в поле поиска " + player, () ->
                searchPlayersInput.setValue(player).pressEnter());

        return this;
    }

    public MainPage verifyFriendsSearchResult(String player) {
        step("Проверить, что в списке появился " + player, () ->
                contentVerifyModal.verifyFriendsSearchResult(player));

        return this;
    }

    public MainPage clickLanguageButton() {
        step("Нажать кнопку 'Language'", () ->
                languageButton.click());

        return this;
    }

    public MainPage setLanguage(String language) {
        step("Выбрать в списке " + language, () ->
                languageDropDownList.$(withText(language)).click());

        return this;
    }

    public MainPage verifyLanguageContentResult(String expectedResult) {
        step("Проверить, что кнопка 'install Steam' изменилась на " + expectedResult, () ->
                contentVerifyModal.verifyLanguageContentResult(expectedResult));

        return this;
    }

}
