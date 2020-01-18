package WebPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;


public class DeliveryMainPage {

    // Elements
    public SelenideElement deliveryAddressClicked = $(byCssSelector(".address-suggest__search-input"));
    SelenideElement deliveryAddress = $(byCssSelector(".address-input__location"));

    // Actions
    public void TypeAddress(String text) {
        deliveryAddress.click();
        deliveryAddressClicked.setValue(text);
        SelenideElement selenideElement = deliveryAddressClicked.pressEnter();
    }
}
