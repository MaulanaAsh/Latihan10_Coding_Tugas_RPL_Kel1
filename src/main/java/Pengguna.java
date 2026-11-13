import java.time.LocalDateTime;

/** Entitas akun pengguna (class Pengguna pada class diagram). */
public class Pengguna {

    private static final int MAKS_GAGAL = 5;
    private static final long MENIT_KUNCI = 15;

    private final int id;
    private String nama;
    private final String email;
    private final String passwordHash;
    private Peran peran;
    private boolean aktif;
    private int percobaanGagal;
    private LocalDateTime terkunciSampai;

    public Pengguna(int id, String nama, String email, String passwordAsli) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.passwordHash = PasswordUtil.hash(passwordAsli);
        this.peran = Peran.PENGGUNA;
        this.aktif = true;
    }

    /** Memeriksa kecocokan password dengan hash tersimpan. */
    public boolean verifikasiPassword(String passwordAsli) {
        return passwordHash.equals(PasswordUtil.hash(passwordAsli));
    }

    /** True bila akun masih dalam masa kunci. */
    public boolean isTerkunci() {
        return terkunciSampai != null
                && LocalDateTime.now().isBefore(terkunciSampai);
    }

    /** Mencatat login gagal; akun dikunci 15 menit setelah 5 kali gagal. */
    public void catatGagal() {
        percobaanGagal++;
        if (percobaanGagal >= MAKS_GAGAL) {
            terkunciSampai = LocalDateTime.now().plusMinutes(MENIT_KUNCI);
            percobaanGagal = 0;
        }
    }

    /** Mengembalikan hitungan gagal ke nol setelah login berhasil. */
    public void resetPercobaan() {
        percobaanGagal = 0;
        terkunciSampai = null;
    }

    public int getId() { return id; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getEmail() { return email; }
    public Peran getPeran() { return peran; }
    public void setPeran(Peran peran) { this.peran = peran; }
    public boolean isAktif() { return aktif; }
    public void setAktif(boolean aktif) { this.aktif = aktif; }
}
