package WebPages.BorrowerPages;

import WebPages.LandingPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.graalvm.compiler.lir.LIRInstruction;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProfileMyDataPage {
    private SelenideElement MyProfileTitle = $("[class*='Title__title']");
    private SelenideElement MyProfileAvatar = $("[class*='UserPic__coverWithUrl']");
    private SelenideElement LogOutFromNavBar = $("[class*='Navbar__logOut']");
    public SelenideElement UserMenu = $("[class*='Navbar__burger']");
    private SelenideElement LogOutFromUserMenu = $("[class*=''MobileSidebar__logOut']");
    private SelenideElement MyProfileNameBlock = $("[class*='ProfileCard__infoTextBlock']");

    public ProfileMyDataPage awaitIsOnPage(){
        MyProfileTitle.waitUntil(Condition.visible, 30 * 1000);
        MyProfileNameBlock.waitUntil(Condition.visible, 30 * 1000);
        //MyProfileAvatar.waitUntil(Condition.visible, 30 * 1000);
        //MyProfileTitle.shouldBe(Condition.visible);
        //MyProfileAvatar.shouldBe(Condition.visible);
        return this;
    }

    public ProfileMyDataPage openUserMenu(){
        UserMenu.click();
        LogOutFromUserMenu.shouldBe(Condition.visible);
        return this;
    }

    public LandingPage signOutFromUserMenu(){
        LogOutFromUserMenu.click();
        return new LandingPage().awaitIsOnPage();
    }

    public LandingPage signOutFromNavBar(){
        LogOutFromNavBar.click();
        return new LandingPage().awaitIsOnPage();
    }
}
