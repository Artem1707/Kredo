package WebPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;


public class LandingPage extends PageBase {

    // Elements
    public SelenideElement SignInButton = $(byCssSelector(".ant-btn.ant-btn-primary"));
    public SelenideElement SignInDialog = $(byClassName("ant-modal-body"));

    // Actions
    @Override
    public Boolean AwaitIsOnPage() {
        return true; // TODO add timer and check
    }

    public void SigIn() {
        SignInButton.click();
    }

    public Boolean SelectSignInDialogShown(){
        return SignInDialog.isDisplayed();
    }
}
