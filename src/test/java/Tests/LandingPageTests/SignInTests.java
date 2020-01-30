package Tests.LandingPageTests;

import Common.TestsBase;
import WebPages.BorrowerPages.ProfileMyDataPage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class SignInTests extends TestsBase {

    @Test
    public void signIn_asBorrower_Success(){
        // Arrange
        String login = Borrower.Login;
        String pass = Borrower.Password;

        // Act
        ProfileMyDataPage profilePage = goToClientPortal()
                .signIn()
                .signInAsBorrower()
                .signIn(login, pass)
                .typeSmsCode(Borrower.getLastSmsKey());

        // Assert
        profilePage.awaitIsOnPage();
    }

    @Test
    public void signUn_asBorrower_Success(){
        // Arrange
        String login = Borrower.Login;
        String pass = Borrower.Password;

        // Act
        ProfileMyDataPage profilePage = goToClientPortal()
                .signUp()
                .signUpAsBorrower()
                .signIn(login, pass)
                .typeSmsCode(Borrower.getLastSmsKey());

        // Assert
        profilePage.awaitIsOnPage();
    }


}
