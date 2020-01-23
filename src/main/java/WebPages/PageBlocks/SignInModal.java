package WebPages.PageBlocks;

import WebPages.BorrowerPages.BorrowerSignInPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class SignInModal {
    public SelenideElement SignInDialog = $(byClassName("ant-modal-body"));
    private SelenideElement SignInAsBorrowerButton = $("[class*='landing-borrower'][class*='UserTypeAuth']");

    public SignInModal awaitIsOnPage(){
        SignInDialog.shouldBe(Condition.visible);
        return this;
    }

    public BorrowerSignInPage signInAsBorrower(){
        SignInAsBorrowerButton.click();
        return new BorrowerSignInPage().awaitIsOnPage();
    }
}
