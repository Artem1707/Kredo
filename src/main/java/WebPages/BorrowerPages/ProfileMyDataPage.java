package WebPages.BorrowerPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProfileMyDataPage {
    private SelenideElement MyProfileTitle = $("[class*='Title__title']");

    public ProfileMyDataPage awaitIsOnPage(){
        MyProfileTitle.shouldBe(Condition.visible);
        return this;
    }
}
