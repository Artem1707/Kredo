package Models;

public class KredoUser {
    public KredoUser(String login, String password, KredoUserType type){
        Login = login;
        Password = password;
        Type = type;
    }

    public String Login;

    public String Password;

    public KredoUserType Type;

    public String GetLastSmsKey() {
        return "11111";
    }
}
