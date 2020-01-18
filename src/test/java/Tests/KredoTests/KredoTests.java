package Tests.KredoTests;

import WebPages.DeliveryMainPage;
import WebPages.DeliverySearchResults;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public class KredoTests {
    @BeforeAll
    public static void setUp ()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\GIT\\selenide-gradle\\chromedriver.exe");
        Configuration.timeout=5000;
        Configuration.browser = "chrome";
    }

    @Test
    public void goToDeliveryClub_SetAddress_AddressFoundTest2(){
        // Arrange
        open("https://www.delivery-club.ru/");

        // Act
        String address = "Москва, Ленинградское шоссе, 39Ас2";
        new DeliveryMainPage().TypeAddress(address);

        // Assert
        DeliverySearchResults results = new DeliverySearchResults();
        System.out.println(results.GetInputAddress());
        results.deliveryAddressInput.shouldHave(exactText("Москва, Ленинградское шоссе, 39Ас2"));
    }
}
