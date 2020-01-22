package Helpers;

import Models.KredoUser;
import Models.KredoUserType;

public class KredoUserProvider {
    public static KredoUser GetUser(KredoUserType type) {
        switch (type){
            case Admin:
                return GetNewAdminUser();
            case Borrower:
                return GetNewBorrower();
            case Investor:
            default:
                return GetNewInvestor();
        }
    }

    private static KredoUser GetNewBorrower(){
        String login = ConfigReader.GetCProperty("kredo.borrower_login");
        String password = ConfigReader.GetCProperty("kredo.borrower_pass");

        return new KredoUser(login, password, KredoUserType.Borrower);
    }

    private static KredoUser GetNewInvestor(){
        String login = ConfigReader.GetCProperty("kredo.investor_login");
        String password = ConfigReader.GetCProperty("kredo.investor_pass");

        return new KredoUser(login, password, KredoUserType.Investor);
    }

    private static KredoUser GetNewAdminUser(){
        String login = ConfigReader.GetCProperty("kredo.admin_login");
        String password = ConfigReader.GetCProperty("kredo.admin_pass");

        return new KredoUser(login, password, KredoUserType.Admin);
    }
}
