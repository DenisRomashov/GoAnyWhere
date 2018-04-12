package ga.goanywhere.model;

import java.math.BigInteger;

public interface RegistrationManager {
    BigInteger createUser(String username, String password);
    BigInteger createUser(String username, String password, String email);
}
