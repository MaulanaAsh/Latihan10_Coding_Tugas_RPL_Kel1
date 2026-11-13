/** Controller untuk registrasi dan login (S-01, S-02). */
public class AutentikasiController {

    private static final String GALAT_LOGIN =
            "E-mail atau password tidak sesuai. Periksa kembali data Anda.";
    private static final String POLA_EMAIL = "^[\\w.+-]+@[\\w-]+\\.[\\w.]+$";

    private final DaftarPengguna daftarPengguna;

    public AutentikasiController(DaftarPengguna daftarPengguna) {
        this.daftarPengguna = daftarPengguna;
    }

    /** Pesan 2 sampai 6 pada sequence: registrasi akun baru. */
    public String registrasi(String nama, String email,
            String password, boolean setuju) {
        String galat = validasiRegistrasi(nama, email, password, setuju);
        if (galat != null) {
            return galat;
        }
        int idBaru = daftarPengguna.jumlahPengguna() + 1;
        daftarPengguna.simpan(new Pengguna(idBaru, nama, email, password));
        return "Registrasi berhasil. Silakan masuk.";
    }

    /** Mengembalikan pesan galat, atau null bila semua isian valid. */
    private String validasiRegistrasi(String nama, String email,
            String password, boolean setuju) {
        if (nama == null || nama.isBlank()) {
            return "Nama wajib diisi.";
        }
        if (email == null || !email.matches(POLA_EMAIL)) {
            return "Format e-mail tidak valid.";
        }
        if (daftarPengguna.emailTerdaftar(email)) {
            return "E-mail sudah terdaftar.";
        }
        if (!passwordKuat(password)) {
            return "Password minimal 8 karakter, kombinasi huruf dan angka.";
        }
        if (!setuju) {
            return "Anda harus menyetujui Syarat Penggunaan "
                    + "dan Kebijakan Privasi.";
        }
        return null;
    }

    private boolean passwordKuat(String password) {
        return password != null
                && password.length() >= 8
                && password.matches(".*[A-Za-z].*")
                && password.matches(".*\\d.*");
    }

    /** Pesan 8 sampai 11 pada sequence: login dengan pesan galat generik. */
    public HasilLogin login(String email, String password) {
        Pengguna pengguna = daftarPengguna.cariByEmail(email);
        if (pengguna == null || !pengguna.isAktif() || pengguna.isTerkunci()) {
            return new HasilLogin(false, GALAT_LOGIN, null);
        }
        if (!pengguna.verifikasiPassword(password)) {
            pengguna.catatGagal();
            return new HasilLogin(false, GALAT_LOGIN, null);
        }
        pengguna.resetPercobaan();
        String layarTujuan = tentukanLayarTujuan(pengguna);
        return new HasilLogin(true, "Login berhasil.", layarTujuan);
    }

    private String tentukanLayarTujuan(Pengguna pengguna) {
        return pengguna.getPeran() == Peran.ADMIN ? "S-10" : "S-04";
    }
}
