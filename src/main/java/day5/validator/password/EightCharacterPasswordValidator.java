package day5.validator.password;

/**
 * @author mmalicki
 */
public class EightCharacterPasswordValidator implements  PasswordValidator{
    @Override
    public boolean isValid(final String password) {
        return password.length() == 8;
    }
}
