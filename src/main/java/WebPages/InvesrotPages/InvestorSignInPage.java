package WebPages.InvesrotPages;

import WebPages.BorrowerPages.BorrowerSignInPage;
import WebPages.BorrowerPages.BorrowerSmsSignInPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class InvestorSignInPage {
    private SelenideElement LoginEdit = $(byId("login"));
    private SelenideElement PasswordEdit = $(byId("password"));
    private SelenideElement LoginButton = $("[class*=js-login-button]");

    public InvestorSignInPage awaitIsOnPage(){
        LoginButton.shouldBe(Condition.visible);
        return this;
    }

    public InvestorHomePage signIn(String login, String password){
        LoginEdit.sendKeys(login);
        PasswordEdit.sendKeys(password);
        LoginButton.click();

        return new InvestorHomePage().awaitIsOnPage();
    }
}
