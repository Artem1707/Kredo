package Models;

public class Investor extends  KredoUser{
    public Investor(String login, String password){
        super(login, password);

        Type = KredoUserType.Investor;
    }

    public String Login;

    public String Password;

    public KredoUserType Type;

    @Override
    public String getLastSmsKey() {
        return "11111";
    }
}
