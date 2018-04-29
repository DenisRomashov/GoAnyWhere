package ga.goanywhere.model;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public interface AuthorizationManager {
    BigInteger logIn(@NotNull String username, @NotNull String password)
            throws NoSuchAlgorithmException;
}
