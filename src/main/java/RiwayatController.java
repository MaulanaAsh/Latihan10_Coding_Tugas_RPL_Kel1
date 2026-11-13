import java.util.Comparator;
import java.util.List;

/** Controller layar Riwayat Analisis dan dialog konfirmasi hapus (S-08, S-16).
 */
public class RiwayatController {

    private final RiwayatRepository repository;
    private final PenyimpananBerkas penyimpanan;

    public RiwayatController(RiwayatRepository repository,
            PenyimpananBerkas penyimpanan) {
        this.repository = repository;
        this.penyimpanan = penyimpanan;
    }

    /** Pesan 2 dan 3: riwayat terbaru di atas; label dan kataKunci boleh null.
     */
    public List<RiwayatAnalisis> tampilkanRiwayat(
            int idPemilik, String kataKunci, LabelHasil label) {
        return repository.cariMilik(idPemilik).stream()
                .filter(r -> cocokNama(r, kataKunci))
                .filter(r -> label == null || r.getLabel() == label)
                .sorted(Comparator.comparing(RiwayatAnalisis::getTanggal)
                .reversed())
                .toList();
    }

    private boolean cocokNama(RiwayatAnalisis riwayat, String kataKunci) {
        if (kataKunci == null || kataKunci.isBlank()) {
            return true;
        }
        String nama = riwayat.getNamaBerkas().toLowerCase();
        return nama.contains(kataKunci.toLowerCase());
    }

    /** Pesan 5: teks dialog S-16. */

    public String mintaKonfirmasiHapus(int idRiwayat) {
        return "Hapus riwayat ini? Data hasil analisis beserta foto dan "
                + "visualisasi terkait akan dihapus permanen dan "
                + "tidak dapat dikembalikan.";
    }

    /** Pesan 7 sampai 10: hapus hanya bila pengguna menekan Ya, hapus. */
    public String hapusRiwayat(int idPemilik, int idRiwayat,
            boolean konfirmasi) {
        if (!konfirmasi) {
            return "Penghapusan dibatalkan.";
        }
        if (!milikPengguna(idPemilik, idRiwayat)) {
            return "Riwayat tidak ditemukan.";
        }
        penyimpanan.hapusFotoDanVisualisasi(idRiwayat);
        repository.hapus(idRiwayat);
        return "Riwayat berhasil dihapus.";
    }

    private boolean milikPengguna(int idPemilik, int idRiwayat) {
        return repository.cariMilik(idPemilik).stream()
                .anyMatch(r -> r.getId() == idRiwayat);
    }
}
