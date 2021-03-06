package Helpers;

import Models.*;

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
        String login = ConfigReader.getPrivateProperty("kredo.borrower_login");
        String password = ConfigReader.getPrivateProperty("kredo.borrower_pass");

        return new Borrower(login, password);
    }

    private static KredoUser GetNewInvestor(){
        String login = ConfigReader.getPrivateProperty("kredo.investor_login");
        String password = ConfigReader.getPrivateProperty("kredo.investor_pass");

        return new Investor(login, password);
    }

    private static KredoUser GetNewAdminUser(){
        String login = ConfigReader.getPrivateProperty("kredo.admin_login");
        String password = ConfigReader.getPrivateProperty("kredo.admin_pass");

        return new Admin(login, password);
    }
}
