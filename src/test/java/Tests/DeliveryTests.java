package Tests;

import Common.TestsBase;
import WebPages.DeliveryMainPage;
import WebPages.DeliverySearchResults;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.open;

@Disabled
public class DeliveryTests extends TestsBase {
    @Test
    public void goToDeliveryClub_SetAddress_AddressFoundTest(){
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
