package Tests.LandingPageTests;

import Common.TestsBase;
import Helpers.KredoUserProvider;
import Models.KredoUser;
import Models.KredoUserType;
import WebPages.BorrowerPages.ProfileMyDataPage;
import WebPages.LandingPage;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SignInTests extends TestsBase {

    @Test
    public void signIn_asBorrower_Success(){
        // Arrange
        String login = Borrower.Login;
        String pass = Borrower.Password;

        // Act
        ProfileMyDataPage profilePage = goToClientPortal()
                .sigIn()
                .signInAsBorrower()
                .signIn(login, pass)
                .typeSmsCode(Borrower.GetLastSmsKey());

        // Assert
        profilePage.awaitIsOnPage();
    }
}
