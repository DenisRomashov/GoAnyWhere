package ga.goanywhere.model;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public interface RegistrationManager {
    BigInteger createUser(@NotNull String username, @NotNull String password)
            throws NoSuchAlgorithmException;
    BigInteger createUser(@NotNull String username, @NotNull String password,
                          @NotNull String email)
            throws NoSuchAlgorithmException;
    BigInteger createUser(@NotNull String username, @NotNull String password,
                          @NotNull String email, @NotNull String firstName,
                          @NotNull String lastName, @NotNull String sex)
            throws  NoSuchAlgorithmException;
}
