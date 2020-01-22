package WebPages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;


public abstract class PageBase {

    public abstract Boolean AwaitIsOnPage();
}
