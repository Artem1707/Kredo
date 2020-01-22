package Common;

import Api.DogApi;
import Helpers.ConfigReader;
import Helpers.KredoUserProvider;
import Models.DogImage;
import Models.KredoUser;
import Models.KredoUserType;
import WebPages.DeliveryMainPage;
import WebPages.DeliverySearchResults;
import com.codeborne.selenide.Configuration;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public abstract class TestsBase {

    @BeforeAll
    public static void setUp ()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\GIT\\KredoTests\\chromedriver.exe");
        Configuration.timeout=5000;
        Configuration.browser = "chrome";
    }

    public String ClientPortalUrl = ConfigReader.GetCProperty("kredo.clientPortal.url");
    public KredoUser Admin = KredoUserProvider.GetUser(KredoUserType.Admin);
    public KredoUser Investor = KredoUserProvider.GetUser(KredoUserType.Investor);
    public KredoUser Borrower = KredoUserProvider.GetUser(KredoUserType.Borrower);
}
