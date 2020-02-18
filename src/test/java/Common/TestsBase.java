package Common;

import Helpers.ApiFactory;
import Helpers.ConfigReader;
import Helpers.KredoUserProvider;
import Models.KredoUser;
import Models.KredoUserType;
import WebPages.LandingPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public abstract class TestsBase {

    @BeforeAll
    public static void setUp ()
    {
        System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
        Configuration.timeout=5000;
        Configuration.browser = "chrome";
    }

    @AfterAll
    public static void afterAll(){
        apiFactory.dispose();
    }

    protected LandingPage goToClientPortal(){
        open("https://www." + ClientPortalUrl);
        LandingPage landingPage = new LandingPage();
        return landingPage.awaitIsOnPage();
    }


    public static String ClientPortalUrl = ConfigReader.GetCProperty("kredo.clientPortal.url");
    public static ApiFactory apiFactory = new ApiFactory(ClientPortalUrl);
    public KredoUser Admin = KredoUserProvider.GetUser(KredoUserType.Admin);
    public KredoUser Investor = KredoUserProvider.GetUser(KredoUserType.Investor);
    public KredoUser Borrower = KredoUserProvider.GetUser(KredoUserType.Borrower);

    private static String ChromeBrowserPath = ConfigReader.GetCProperty("chrome.path");
    private static String ChromeDriverPath = ConfigReader.GetCProperty("chrome.driver");
}
