import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

/** Utilitas hash password. Untuk produksi disarankan memakai BCrypt. */
public final class PasswordUtil {

    private PasswordUtil() { }

    /** Mengubah password asli menjadi hash SHA-256 (heksadesimal). */
    public static String hash(String passwordAsli) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] masuk = passwordAsli.getBytes(StandardCharsets.UTF_8);
            byte[] hasil = sha.digest(masuk);
            return HexFormat.of().formatHex(hasil);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-256 tidak tersedia", e);
        }
    }
}
