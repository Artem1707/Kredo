package WebPages.BorrowerPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class BorrowerSignInPage {

    private SelenideElement LoginEdit = $(byId("inputLogin"));
    private SelenideElement PasswordEdit = $(byId("inputPassword"));
    private SelenideElement LoginButton = $(byCssSelector(".btn.btn-success"));

    public BorrowerSignInPage awaitIsOnPage(){
        LoginButton.shouldBe(Condition.visible);
        return this;
    }

    public BorrowerSmsSignInPage signIn(String login, String password){
        LoginEdit.sendKeys(login);
        PasswordEdit.sendKeys(password);
        LoginButton.click();

        return new BorrowerSmsSignInPage().awaitIsOnPage();
    }
}
