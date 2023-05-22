package components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ContentVerifyModal {
    public void verifyHeaderMenuContent(){
        $(".supernav_container").shouldHave(Condition.text("МАГАЗИН"), Condition.text("СООБЩЕСТВО"),
                Condition.text("О STEAM"), Condition.text("ПОДДЕРЖКА"));
    }
    public void verifySearchFieldResult(){
        $("#search_resultsRows").shouldHave(Condition.text("Cyberpunk"));
    }
    public void verifySearchSupportInputVisible(){
        $("#help_search_support_input").shouldBe(Condition.visible);
    }
    public void verifyGameAddToCard(){
        $(".pageheader").shouldHave(Condition.text("Ваша корзина"));
        $(".cart_status_message").shouldHave(Condition.text("Ваш товар был добавлен!"));
    }
    public void verifyFriendsSearchResult(){
        $("#search_results").shouldHave(Condition.text("automation"));
    }
    public void verifyLanguageContentResult(String expectedResult){
        $(".header_installsteam_btn_content").shouldHave(Condition.text(expectedResult));
    }
}
