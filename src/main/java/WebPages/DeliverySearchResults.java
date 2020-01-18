package WebPages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DeliverySearchResults {
    // Elements
    public ElementsCollection found = $$("#ires .g");
    public SelenideElement deliveryAddressInput = $(byCssSelector(".address-input__location"));

    // Actions
    public SelenideElement getResult(int index) {
        return found.get(index);
    }
    public String GetInputAddress() { return deliveryAddressInput.getValue();}

}
