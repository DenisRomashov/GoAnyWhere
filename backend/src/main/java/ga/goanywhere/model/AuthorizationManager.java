package ga.goanywhere.model;

import java.math.BigInteger;

public interface AuthorizationManager {
    BigInteger logIn(String username, String password);
}
