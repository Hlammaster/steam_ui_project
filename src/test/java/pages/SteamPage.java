package pages;

import com.codeborne.selenide.SelenideElement;
import components.ContentVerifyModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SteamPage {
    private final SelenideElement
            searchInput = $("#store_nav_search_term"),
            supportButton = $(".supernav_container").$(byText("SUPPORT")),
            gamesAndProgramsButton = $("[href='https://help.steampowered.com/en/wizard/HelpWithGame']"),
            communityButton = $(".supernav_container").$(byText("COMMUNITY")),
            searchPlayersInput = $("#SearchPlayers"),
            languageButton = $("#language_pulldown"),
            languageDropDownList = $("#language_dropdown");

    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();

    public SteamPage openPage() {
        step("Открыть страницу 'https://store.steampowered.com/'", () ->
                open("https://store.steampowered.com/"));

        return this;
    }

    public SteamPage headerMenuContent() {
        step("Проверить наличие подразделов в хедер меню", () ->
                contentVerifyModal.verifyHeaderMenuContent());

        return this;
    }

    public SteamPage searchFieldEnterKey(String key) {
        step("Ввести в поле поиска название игры " + key, () ->
                searchInput.setValue(key).pressEnter());

        return this;
    }

    public SteamPage searchFieldResult(String game) {
        step("Проверить, что в списке появлился " + game, () ->
                contentVerifyModal.verifySearchFieldResult(game));

        return this;
    }


    public SteamPage supportButtonClick() {
        step("Кликнуть кнопку 'Support'", () ->
                supportButton.click());

        return this;
    }

    public SteamPage gamesAndProgramsClick() {
        step("Нажать на вкладку Games,Programs", () ->
                gamesAndProgramsButton.click());

        return this;
    }

    public SteamPage verifySearchSupportInputVisible() {
        step("Проверить, что появилось поле поиска", () ->
                contentVerifyModal.verifySearchSupportInputVisible());

        return this;
    }


    public SteamPage communityButtonClick() {
        step("Кликнуть кнопку 'Community'", () ->
                communityButton.click());

        return this;
    }

    public SteamPage searchFriendsInputEnterKey(String player) {
        step("Ввести в поле поиска " + player, () ->
                searchPlayersInput.setValue(player).pressEnter());

        return this;
    }

    public SteamPage verifyFriendsSearchResult(String player) {
        step("Проверить, что в списке появился " + player, () ->
                contentVerifyModal.verifyFriendsSearchResult(player));

        return this;
    }

    public SteamPage clickLanguageButton() {
        step("Нажать кнопку 'Language'", () ->
                languageButton.click());

        return this;
    }

    public SteamPage setLanguage(String language) {
        step("Выбрать в списке " + language, () ->
                languageDropDownList.$(withText(language)).click());

        return this;
    }

    public SteamPage verifyLanguageContentResult(String expectedResult) {
        step("Проверить, что кнопка 'install Steam' изменилась на " + expectedResult, () ->
                contentVerifyModal.verifyLanguageContentResult(expectedResult));

        return this;
    }

}
