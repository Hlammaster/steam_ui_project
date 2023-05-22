package pages;

import com.codeborne.selenide.Condition;
import components.ContentVerifyModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SteamPage {
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
        $("#store_nav_search_term").setValue(key).pressEnter();

        return this;
    }
    public SteamPage searchFieldResult(){
        contentVerifyModal.verifySearchFieldResult();

        return this;
    }
    public SteamPage supportButtonClick(){
        $(".supernav_container").$(byText("ПОДДЕРЖКА")).click();

        return this;
    }
    public SteamPage gamesAndProgramsClick(){
        $("[href='https://help.steampowered.com/ru/wizard/HelpWithGame']").click();

        return this;
    }
    public SteamPage verifySearchSupportInputVisible(){
        contentVerifyModal.verifySearchSupportInputVisible();

        return this;
    }

    public SteamPage addToCard(){
        $(".responsive_search_name_combined").click();
        $("#btn_add_to_cart_302").click();

        return this;
    }
    public SteamPage verifyGameAddToCard(){
        contentVerifyModal.verifyGameAddToCard();

        return this;
    }
    public SteamPage communityButtonClick(){
        $(".supernav_container").$(byText("СООБЩЕСТВО")).click();

        return this;
    }
    public SteamPage searchFriendsInputEnterKey(){
        $("#SearchPlayers").setValue("Qa automation").pressEnter();

        return this;
    }
    public SteamPage verifyFriendsSearchResult(){
        contentVerifyModal.verifyFriendsSearchResult();

        return this;
    }
    public SteamPage clickLanguageButton(){
        $("#language_pulldown").click();

        return this;
    }
    public SteamPage setLanguage(String language){
        $("#language_dropdown").$(withText(language)).click();

        return this;
    }
    public SteamPage verifyLanguageContentResult(String expectedResult){
        contentVerifyModal.verifyLanguageContentResult(expectedResult);

        return this;
    }

}
