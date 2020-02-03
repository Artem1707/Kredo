package WebPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class AdminSignInPage extends PageBase {

    // Elements
    private SelenideElement LoginEdit = $(byId("username"));
    private SelenideElement PasswordEdit = $(byId("password"));
    private SelenideElement LoginButton = $(byId("kc-login"));
    private SelenideElement AfterSuccessLoginElement = $(byClassName(".anticon.anticon-logout"));

    // Actions
    public AdminSignInPage awaitIsOnPage() {
        LoginButton.shouldBe(Condition.visible);
        return this;
    }

    public String signIn(String login, String password){
        LoginEdit.sendKeys(login);
        PasswordEdit.sendKeys(password);
        LoginButton.click();

        // await successful login
        AfterSuccessLoginElement.shouldBe(Condition.visible);

        // get cookie
        Cookie token = getWebDriver().manage().getCookieNamed("_kredo_jwt_sso");
        return token.getValue();
    }
}
