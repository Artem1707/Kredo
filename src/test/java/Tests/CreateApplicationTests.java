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

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CreateApplicationTests extends TestsBase {

    @Test
    public void simpleTest_UniApi(){
        // arrange
        UniApplicationsApi uniApi = apiFactory.getUniAppApi();

        ApplicationList apps = uniApi.getApplications();

        Integer borrowerId = apps.entities.get(0).borrowerId;
    }
}


