package ga.goanywhere.model;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public interface RegistrationManager {
    Long createUser(String username, String password, String email,
                    String firstName, String lastName, String sex)
            throws  NoSuchAlgorithmException;
}
