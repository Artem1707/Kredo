package WebPages;

import WebPages.PageBlocks.SignInModal;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;


public class LandingPage extends PageBase {

    // Elements
    private SelenideElement SignInButton = $(byCssSelector(".ant-btn.ant-btn-primary"));

    // Actions
    public LandingPage awaitIsOnPage() {
        SignInButton.shouldBe(Condition.visible);
        return this;
    }

    public SignInModal sigIn() {
        SignInButton.click();
        SignInModal dialog = new SignInModal();
        dialog.awaitIsOnPage();
        return dialog;
    }
}
