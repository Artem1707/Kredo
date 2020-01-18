import Api.DogApi;
import Models.DogImage;
import WebPages.DeliveryMainPage;
import WebPages.DeliverySearchResults;
import com.codeborne.selenide.Configuration;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

public class TempTests {

    @BeforeAll
    public static void setUp ()
    {
        System.setProperty("webdriver.chrome.driver", "D:\\GIT\\KredoTests\\chromedriver.exe");
        Configuration.timeout=5000;
        Configuration.browser = "chrome";
    }

    @Test
    public void goToDeliveryClub_SetAddress_AddressFoundTest(){
        // Arrange
        open("https://www.delivery-club.ru/");

        // Act
        String address = "Москва, Ленинградское шоссе, 39Ас1";
        new DeliveryMainPage().TypeAddress(address);

        // Assert
        DeliverySearchResults results = new DeliverySearchResults();
        System.out.println(results.GetInputAddress());
        results.deliveryAddressInput.shouldHave(exactText("Москва, Ленинградское шоссе, 39Ас2"));
    }

    @Test
    public void sampleApiTest() throws IOException {
        DogApi obj = new DogApi();
        DogImage dog = obj.getDogs();

        System.out.println("DogImage: " + dog.Status + "   " + dog.Message);
        Assert.check(dog.Status.equals("success"));
    }
}
