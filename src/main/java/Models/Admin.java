package Models;

public class Admin extends KredoUser{
    public Admin(String login, String password){
        super(login, password);

        Type = KredoUserType.Admin;
    }

    public String Login;

    public String Password;

    public KredoUserType Type;

    @Override
    public String getLastSmsKey() {
        return "11111";
    }
}
