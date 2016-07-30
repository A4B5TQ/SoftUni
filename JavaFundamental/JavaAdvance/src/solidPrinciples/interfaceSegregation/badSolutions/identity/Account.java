package solidPrinciples.interfaceSegregation.badSolutions.identity;

public interface Account {
    boolean getRequireUniqueEmail();
    void setRequireUniqueEmail(boolean value);

    int getMinRequiredPasswordLength();
    void setMinRequiredPasswordLength(int length);

    int getMaxRequiredPasswordLength();
    int setMaxRequiredPasswordLength(int length);

    void register(String username, String password);

    void login(String username, String password);

    void changePassword(String oldPass, String newPass);

    Iterable<User> getAllUsersOnline();

    Iterable<User> getAllUsers();

    User getUserByName(String name);
}
