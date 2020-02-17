package Helpers;

import Api.UniApplicationsApi;
import WebPages.AdminSignInPage;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApiFactory {

    public UniApplicationsApi createIfNotExistUniApi(){
        // get token
        String token = createJwtToken();

        // create api
        if (uniApplicationApi == null){
            uniApplicationApi = new UniApplicationsApi(token);
        }
        else {
            uniApplicationApi.setToken(token);
        }

        return uniApplicationApi;
    }

    public void dispose(){
        if (uniApplicationApi != null){
            uniApplicationApi.dispose();
        }
    }

    private String createJwtToken(){
        // start new driver
        WebDriver driver = createWebDriver();

        // open(admin.kredomoney.ru)
        driver.get("https://" + "admin." + ClientPortalUrl);

        String token = new AdminSignInPage(driver)
                .awaitIsOnPage()
                .signIn(ConfigReader.GetCProperty("kredo.admin_login"),
                        ConfigReader.GetCProperty("kredo.admin_pass"));

        // close driver
        driver.close();

        return token;
    }

    private WebDriver createWebDriver(){
        Configuration.timeout=5000;
        Configuration.browser = "chrome";
        System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
        WebDriver driver = new ChromeDriver();

        return driver;
    }

    private static UniApplicationsApi uniApplicationApi;
    private static String ChromeDriverPath = ConfigReader.GetCProperty("chrome.driver");
    public static String ClientPortalUrl = ConfigReader.GetCProperty("kredo.clientPortal.url");
}
