package solidPrinciples.interfaceSegregation.badSolutions.identity;

public class AccountManager implements Account {
    @Override
    public boolean getRequireUniqueEmail() {
        return false;
    }

    @Override
    public void setRequireUniqueEmail(boolean value) {

    }

    @Override
    public int getMinRequiredPasswordLength() {
        return 0;
    }

    @Override
    public void setMinRequiredPasswordLength(int length) {

    }

    @Override
    public int getMaxRequiredPasswordLength() {
        return 0;
    }

    @Override
    public int setMaxRequiredPasswordLength(int length) {
        return 0;
    }

    @Override
    public void register(String username, String password) {

    }

    @Override
    public void login(String username, String password) {

    }

    @Override
    public void changePassword(String oldPass, String newPass) {

    }

    @Override
    public Iterable<User> getAllUsersOnline() {
        return null;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByName(String name) {
        return null;
    }
}
