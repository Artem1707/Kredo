package WebPages.BorrowerPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class BorrowerSmsSignInPage {

    private SelenideElement SmsEdit = $(byId("smsCode"));
    private SelenideElement LoginButton = $(byCssSelector(".btn.btn-success"));

    public BorrowerSmsSignInPage awaitIsOnPage(){
        SmsEdit.shouldBe(Condition.visible);
        return this;
    }

    public ProfileMyDataPage typeSmsCode(String smsCode){
        SmsEdit.sendKeys(smsCode);
        LoginButton.click();

        return new ProfileMyDataPage().awaitIsOnPage();
    }
}
