import java.util.List;

/** Controller layar Manajemen Model ML (S-12); khusus Admin. */
public class ModelMLController {

    private static final String AKSES_DITOLAK =
            "403: halaman ini hanya untuk Admin.";

    private final List<ModelML> daftarModel;
    private final KonfigurasiSistem konfigurasi;
    private final AuditLog auditLog;

    public ModelMLController(List<ModelML> daftarModel,
            KonfigurasiSistem konfigurasi, AuditLog auditLog) {
        this.daftarModel = daftarModel;
        this.konfigurasi = konfigurasi;
        this.auditLog = auditLog;
    }

    /** Pesan 2 sampai 6: ubah ambang dan kuota. */
    public String ubahKonfigurasi(Pengguna pelaku, double bawah, double atas,
            int kuotaPengguna, int kuotaAnalis) {
        if (!adalahAdmin(pelaku)) {
            return AKSES_DITOLAK;
        }
        String galat = konfigurasi.ubah(bawah, atas, kuotaPengguna,
                kuotaAnalis);
        if (galat != null) {
            return galat;
        }
        auditLog.catat(pelaku.getNama(), "Ubah konfigurasi", "Konfigurasi");
        return "Konfigurasi berhasil disimpan.";
    }

    /** Aktivasi atau rollback: hanya satu versi model yang aktif. */
    public String aktifkanVersi(Pengguna pelaku, String versi) {
        if (!adalahAdmin(pelaku)) {
            return AKSES_DITOLAK;
        }
        ModelML target = cariVersi(versi);
        if (target == null) {
            return "Versi model tidak ditemukan.";
        }
        daftarModel.forEach(ModelML::nonaktifkan);
        target.aktifkan();
        auditLog.catat(pelaku.getNama(), "Aktifkan model", "ModelML " + versi);
        return "Model " + versi + " sekarang aktif.";
    }

    private boolean adalahAdmin(Pengguna pelaku) {
        return pelaku != null && pelaku.getPeran() == Peran.ADMIN;
    }

    private ModelML cariVersi(String versi) {
        return daftarModel.stream()
                .filter(m -> m.getVersi().equals(versi))
                .findFirst()
                .orElse(null);
    }
}
