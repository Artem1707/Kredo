package Helpers;

import Api.UniApplicationsApi;
import WebPages.AdminSignInPage;

public class ApiFactory {

    public UniApplicationsApi getUniApplicationsApi(){
        // start new driver
        // TODO

        // open(admin.kredomoney.ru)
        // TODO

        String token = new AdminSignInPage()
                .awaitIsOnPage()
                .signIn(ConfigReader.GetCProperty("kredo.admin_login"),
                        ConfigReader.GetCProperty("kredo.admin_pass"));

        // close driver
        // TODO

        // create api
        UniApplicationsApi api = new UniApplicationsApi(token);
        return api;
    }
}
