package WebPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class AdminSignInPage {
    public AdminSignInPage(WebDriver driver){
        _driver = driver;
    }

    WebDriver _driver;
    WebDriverWait wait;

    // Elements
    private WebElement LoginEdit;
    private WebElement PasswordEdit;
    private WebElement LoginButton;
    private WebElement AfterSuccessLoginElement;

    // Actions
    public AdminSignInPage awaitIsOnPage() {
        wait = new WebDriverWait(_driver, 30);
        LoginEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        return this;
    }

    public String signIn(String login, String password){
        PasswordEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        LoginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kc-login")));

        LoginEdit.sendKeys(login);
        PasswordEdit.sendKeys(password);
        LoginButton.click();

        // await successful login
        AfterSuccessLoginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".anticon.anticon-logout")));
        assert AfterSuccessLoginElement.isDisplayed();

        // get cookie
        Cookie token = _driver.manage().getCookieNamed("_kredo_jwt_sso");
        return token.getValue();
    }
}
