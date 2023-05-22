package components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ContentVerifyModal {
    public void verifyHeaderMenuContent(){
        $(".supernav_container").shouldHave(Condition.text("STORE"), Condition.text("COMMUNITY"),
                Condition.text("ABOUT"), Condition.text("SUPPORT"));
    }
    public void verifySearchFieldResult(){
        $("#search_resultsRows").shouldHave(Condition.text("Cyberpunk"));
    }
    public void verifySearchSupportInputVisible(){
        $("#help_search_support_input").shouldBe(Condition.visible);
    }
    public void verifyGameAddToCard(){
        $(".pageheader").shouldHave(Condition.text("YOUR SHOPPING CART"));
        $(".cart_status_message").shouldHave(Condition.text("Your item has been added!"));
    }
    public void verifyFriendsSearchResult(){
        $("#search_results").shouldHave(Condition.text("automation"));
    }
    public void verifyLanguageContentResult(String expectedResult){
        $(".header_installsteam_btn_content").shouldHave(Condition.text(expectedResult));
    }
}
