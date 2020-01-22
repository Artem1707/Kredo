package Tests.KredoTests;

import Common.TestsBase;
import WebPages.LandingPage;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;

public class KredoTests extends TestsBase {

    @Test
    public void goToLandigPage_PressGoAsInvestorButton_AutorizationFormShown(){
        // Arrange
        LandingPage landingPage = GoToClientPortal();

        // Act
        landingPage.SigIn();

        // Assert
        Assert.check(landingPage.SelectSignInDialogShown().equals(true);
    }

    private LandingPage GoToClientPortal(){
        open(ClientPortalUrl);
        LandingPage landingPage = new LandingPage();
        landingPage.AwaitIsOnPage();
        return landingPage;
    }
}
