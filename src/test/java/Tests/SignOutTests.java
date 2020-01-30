package Tests;

import Common.TestsBase;
import WebPages.BorrowerPages.ProfileMyDataPage;
import WebPages.LandingPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverProvider;
import com.codeborne.selenide.WebDriverRunner;
import com.sun.tools.javac.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Sleeper;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getAndCheckWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Disabled
public class SignOutTests extends TestsBase {

    @Test
    public void signOut_Borrower_fullWindowsSize_Success(){
        signInAsBorrower()
                .signOutFromNavBar();
    }

    @Test
    public void signOut_Borrower_smallWindowSize_Success(){
        // arrange
        ProfileMyDataPage profilePage = signInAsBorrower();
        getWebDriver().manage().window().setSize(new Dimension(200,600));

        // act
        profilePage.UserMenu.shouldBe(Condition.visible);

        // assert
        profilePage
                .openUserMenu()
                .signOutFromUserMenu();
    }

    private ProfileMyDataPage signInAsBorrower(){
        ProfileMyDataPage profilePage = goToClientPortal()
                .signIn()
                .signInAsBorrower()
                .signIn(Borrower.Login, Borrower.Password)
                .typeSmsCode(Borrower.getLastSmsKey());

        return profilePage.awaitIsOnPage();
    }
}


