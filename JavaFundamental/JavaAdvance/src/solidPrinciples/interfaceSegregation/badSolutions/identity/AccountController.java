package solidPrinciples.interfaceSegregation.badSolutions.identity;

public class AccountController {
    private Account manager;

    public AccountController(Account manager){
        this.manager = manager;
    }

    public void changePassword(String oldPass, String newPass){
        this.manager.changePassword(oldPass, newPass);
    }
}
