package WebPages.BorrowerPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SignUpBorrowerModal {
    public SelenideElement SignUpDialog = $("class=ant-modal-content");
    private SelenideElement SignUpAsButton = $("[class*=ButtonSberAuth__button]");
    private SelenideElement SignUpInfo = $("[class*=Button__landing-transparent]");

    public SignUpBorrowerModal awaitIsOnPage(){
        SignUpDialog.shouldBe(Condition.visible);
        return this;
    }
    //для зарегистрированного пользователя
    public BorrowerSignInPage signUpAsBorrower(){
        SignUpAsButton.click();
        return new BorrowerSignInPage().awaitIsOnPage();
    }

}
