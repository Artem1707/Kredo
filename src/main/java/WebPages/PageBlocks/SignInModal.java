package WebPages.PageBlocks;

import WebPages.BorrowerPages.BorrowerSignInPage;
import WebPages.InvesrotPages.InvestorSignInPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class SignInModal {
    public SelenideElement SignInDialog = $(byClassName("ant-modal-body"));
    private SelenideElement SignInAsBorrowerButton = $("[class*='landing-borrower'][class*='UserTypeAuth']");
    private SelenideElement SignInAsInvestorButton = $("[class*=Button__landing-investor]");

    public SignInModal awaitIsOnPage(){
        SignInDialog.shouldBe(Condition.visible);
        return this;
    }

    public BorrowerSignInPage signInAsBorrower(){
        SignInAsBorrowerButton.click();
        return new BorrowerSignInPage().awaitIsOnPage();
    }

    public InvestorSignInPage signInAsInvestor(){
        SignInAsInvestorButton.click();
        return new InvestorSignInPage().awaitIsOnPage();
    }
}
