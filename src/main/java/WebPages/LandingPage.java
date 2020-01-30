package WebPages;

import WebPages.PageBlocks.SignInModal;
import WebPages.BorrowerPages.SignUpBorrowerModal;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;


public class LandingPage extends PageBase {

    // Elements
    private SelenideElement SignInButton = $(byCssSelector(".ant-btn.ant-btn-primary"));
    private SelenideElement SignUpBorrowerButton = $("[class*=Button__landing-borrower]");

    // Actions
    public LandingPage awaitIsOnPage() {
        SignInButton.shouldBe(Condition.visible);
        return this;
    }

    public SignInModal signIn() {
        SignInButton.click();
        SignInModal dialog = new SignInModal();
        dialog.awaitIsOnPage();
        return dialog;
    }

    public SignUpBorrowerModal signUp() {
        SignUpBorrowerButton.click();
        SignUpBorrowerModal dialog = new SignUpBorrowerModal();
        dialog.awaitIsOnPage();
        return dialog;
    }
}
