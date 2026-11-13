import java.util.ArrayList;
import java.util.List;

/** Penyimpanan akun sementara di memori (pengganti basis data). */
public class DaftarPengguna {

    private final List<Pengguna> daftar = new ArrayList<>();

    public void simpan(Pengguna pengguna) { daftar.add(pengguna); }

    public Pengguna cariByEmail(String email) {
        return daftar.stream()
                .filter(p -> p.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }

    public boolean emailTerdaftar(String email) {
        return cariByEmail(email) != null;
    }

    public int jumlahPengguna() { return daftar.size(); }
}
