package pages;

import com.codeborne.selenide.SelenideElement;
import components.ContentVerifyModal;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SteamPage {
    private SelenideElement
            searchInput = $("#store_nav_search_term"),
            supportButton = $(".supernav_container").$(byText("SUPPORT")),
            gamesAndProgramsButton = $("[href='https://help.steampowered.com/en/wizard/HelpWithGame']"),
            communityButton = $(".supernav_container").$(byText("COMMUNITY")),
            searchPlayersInput = $("#SearchPlayers"),
            languageButton = $("#language_pulldown"),
            languageDropDownList = $("#language_dropdown");

    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();
@Step("Открыть сайт 'https://store.steampowered.com'")
    public SteamPage openPage() {
        open("https://store.steampowered.com/");

        return this;
    }
@Step("Проверить наличие подразделов в хедерменю")
    public SteamPage headerMenuContent() {
        contentVerifyModal.verifyHeaderMenuContent();

        return this;
    }
@Step("Ввести в поле поиска название игры")
    public SteamPage searchFieldEnterKey(String key) {
        searchInput.setValue(key).pressEnter();

        return this;
    }
@Step()
    public SteamPage searchFieldResult() {
        contentVerifyModal.verifySearchFieldResult();

        return this;
    }

    @Step("Кликнуть кнопку 'Support'")
    public SteamPage supportButtonClick() {
        supportButton.click();

        return this;
    }
@Step("Нажать на вкладку Games,Programs")
    public SteamPage gamesAndProgramsClick() {
        gamesAndProgramsButton.click();

        return this;
    }
@Step("Проверить, что появилось поле поиска")
    public SteamPage verifySearchSupportInputVisible() {
        contentVerifyModal.verifySearchSupportInputVisible();

        return this;
    }


    @Step("Кликнуть кнопку 'Community'")
    public SteamPage communityButtonClick() {
        communityButton.click();

        return this;
    }

    public SteamPage searchFriendsInputEnterKey(String friend) {
    step("Ввести в поле поиска" + friend, () ->
        searchPlayersInput.setValue(friend).pressEnter());

        return this;
    }

    public SteamPage verifyFriendsSearchResult(String player) {
    step("Проверить, что в списке появился" + player, () ->
        contentVerifyModal.verifyFriendsSearchResult());

        return this;
    }
@Step("Нажать кнопку 'Language'")
    public SteamPage clickLanguageButton() {
        languageButton.click();

        return this;
    }

    public SteamPage setLanguage(String language) {
        step("Выбрать в списке" + language, () ->
        languageDropDownList.$(withText(language)).click());

        return this;
    }
    public SteamPage verifyLanguageContentResult(String expectedResult) {
        step("Проверить, что 'install Steam' изменилась на" + expectedResult, () ->
        contentVerifyModal.verifyLanguageContentResult(expectedResult));

        return this;
    }

}
