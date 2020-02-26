package Tests;

import Api.UniApplicationsApi;
import Common.TestsBase;
import Helpers.ApiFactory;
import Models.ApiModels.ApplicationList;
import WebPages.BorrowerPages.ProfileMyDataPage;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreateApplicationTests extends TestsBase {

    @Test
    public void simpleTest_UniApi()
            throws InterruptedException, ExecutionException, IOException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        // arrange
        UniApplicationsApi uniApi = apiFactory.getApi(UniApplicationsApi.class);
                //apiFactory.getUniAppApi();

        ApplicationList apps = uniApi.getApplications();

        Integer borrowerId = apps.entities.get(0).borrowerId;
    }
}


