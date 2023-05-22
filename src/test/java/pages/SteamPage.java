package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import components.ContentVerifyModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SteamPage {
    private SelenideElement
            searchInput = $("#store_nav_search_term"),
            supportButton =  $(".supernav_container").$(byText("SUPPORT")),
            gamesAndProgramsButton = $("[href='https://help.steampowered.com/en/wizard/HelpWithGame']"),
            firstGameInTheList = $(".responsive_search_name_combined"),
            addToCardButton = $("#btn_add_to_cart_302"),
            communityButton =  $(".supernav_container").$(byText("COMMUNITY")),
            searchPlayersInput = $("#SearchPlayers"),
            languageButton = $("#language_pulldown"),
            languageDropDownList = $("#language_dropdown");

    ContentVerifyModal contentVerifyModal = new ContentVerifyModal();
    public SteamPage openPage(){
        open("https://store.steampowered.com/");

        return this;
    }

    public SteamPage headerMenuContent(){
        contentVerifyModal.verifyHeaderMenuContent();

        return this;
    }

    public SteamPage searchFieldEnterKey(String key){
        searchInput.setValue(key).pressEnter();

        return this;
    }
    public SteamPage searchFieldResult(){
        contentVerifyModal.verifySearchFieldResult();

        return this;
    }
    public SteamPage supportButtonClick(){
        supportButton.click();

        return this;
    }
    public SteamPage gamesAndProgramsClick(){
        gamesAndProgramsButton.click();

        return this;
    }
    public SteamPage verifySearchSupportInputVisible(){
        contentVerifyModal.verifySearchSupportInputVisible();

        return this;
    }

    public SteamPage addToCard(){
        firstGameInTheList.click();
        addToCardButton.click();

        return this;
    }
    public SteamPage verifyGameAddToCard(){
        contentVerifyModal.verifyGameAddToCard();

        return this;
    }
    public SteamPage communityButtonClick(){
        communityButton.click();

        return this;
    }
    public SteamPage searchFriendsInputEnterKey(String friend){
        searchPlayersInput.setValue(friend).pressEnter();

        return this;
    }
    public SteamPage verifyFriendsSearchResult(){
        contentVerifyModal.verifyFriendsSearchResult();

        return this;
    }
    public SteamPage clickLanguageButton(){
       languageButton.click();

        return this;
    }
    public SteamPage setLanguage(String language){
       languageDropDownList.$(withText(language)).click();

        return this;
    }
    public SteamPage verifyLanguageContentResult(String expectedResult){
        contentVerifyModal.verifyLanguageContentResult(expectedResult);

        return this;
    }

}
