package Models;

public class Borrower extends  KredoUser{
    public Borrower(String login, String password){
        super(login, password);

        Type = KredoUserType.Borrower;
    }

    public String Login;

    public String Password;

    public KredoUserType Type;

    @Override
    public String getLastSmsKey() {
        return "11111";
    }
}
