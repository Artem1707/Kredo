package Helpers;

import Api.ApiBase;
import WebPages.AdminSignInPage;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ApiFactory {
    public ApiFactory(String baseUrl){
        _baseUrl = baseUrl;
    }

    public <T extends ApiBase> T getApi(Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        T anyApi = (T)ApiList.get(clazz.getName());

        if (anyApi == null){
            anyApi = createApi(clazz);
        }

        // set token
        String token = getJwtToken();
        anyApi.setToken(token);

        return anyApi;
    }

    public void dispose() throws IOException {
        for (Map.Entry<String, ApiBase> api : ApiList.entrySet()) {
            api.getValue().dispose();
        }
    }

    private  <T extends  ApiBase> T createApi(Class<T> clazz)
            throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        T anyApi = null;

        Constructor ctor = clazz.getDeclaredConstructor(String.class);
        anyApi = (T)ctor.newInstance(_baseUrl);

        ApiList.put(clazz.getName(), anyApi);
        return anyApi;
    }

    private String getJwtToken(){
        if (_jwtToken == null)
            _jwtToken = createJwtToken();

        return _jwtToken;
    }

    private String createJwtToken(){
        // start new driver
        WebDriver driver = createWebDriver();

        // open(admin.kredomoney.ru)
        driver.get("https://" + "admin." + ClientPortalUrl);

        String token = new AdminSignInPage(driver)
                .awaitIsOnPage()
                .signIn(ConfigReader.getPrivateProperty("kredo.admin_login"),
                        ConfigReader.getPrivateProperty("kredo.admin_pass"));

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

    private String _jwtToken;
    private Map<String, ApiBase> ApiList = new HashMap<String, ApiBase>();
    private static String ChromeDriverPath = ConfigReader.getCommonProperty("chrome.driver");
    private String _baseUrl;

    public static String ClientPortalUrl = ConfigReader.getCommonProperty("kredo.clientPortal.url");

}
