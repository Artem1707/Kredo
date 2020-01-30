package WebPages.InvesrotPages;

        import WebPages.BorrowerPages.ProfileMyDataPage;
        import com.codeborne.selenide.Condition;
        import com.codeborne.selenide.SelenideElement;

        import static com.codeborne.selenide.Selenide.$;

public class InvestorHomePage {
    private SelenideElement MyProfileTitle = $("[class*='Title__title']");
    private SelenideElement AddBalanceButton = $("[class*='Button__profile-primary-investor']");

    public ProfileMyDataPage awaitIsOnPage(){
        MyProfileTitle.waitUntil(Condition.visible, 30 * 1000);
        AddBalanceButton.waitUntil(Condition.visible, 30 * 1000);
        return this;
    }

}
