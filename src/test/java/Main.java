
public class Main {

    public static void main(String[] args) {
        LoginTest login = new LoginTest();
        login.loginWithValidCredentialsTest();
        login.loginWithInvalidEmail();
        login.loginWithInvalidPasswordTest();
        login.loginWithoutCredentialsTest();
    }

}
