package Tests.LandingPageTests;

import Common.TestsBase;
import WebPages.LandingPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

public class LandingPageButtonTests extends TestsBase {

    @Test
    public void goToLandingPage_PressSignInButton_SignInFormShown(){
        // Arrange
        LandingPage landingPage = goToClientPortal();

        // Act & Assert
        landingPage
                .signIn()
            .SignInDialog
            .shouldBe(Condition.visible);
    }
}
