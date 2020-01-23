package Models;

public abstract class KredoUser {
    public KredoUser(String login, String password){
        Login = login;
        Password = password;
    }

    public String Login;

    public String Password;

    public KredoUserType Type;

    public abstract String getLastSmsKey();
}
