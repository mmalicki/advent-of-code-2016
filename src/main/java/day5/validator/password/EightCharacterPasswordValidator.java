package day5.validator.password;

/**
 * @author mmalicki
 */
public class EightCharacterPasswordValidator implements PasswordValidator {
    @Override
    public boolean isValid(final String password) {
        //TODO: dlugosc powinna byc jako argument z zewnatrz, a nie hardcoded
        return password.length() == 8;
    }
}
