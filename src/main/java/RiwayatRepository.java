import java.util.ArrayList;
import java.util.List;

/** Penyimpanan riwayat sementara di memori (pengganti basis data). */
public class RiwayatRepository {

    private final List<RiwayatAnalisis> daftar = new ArrayList<>();

    public void tambah(RiwayatAnalisis riwayat) { daftar.add(riwayat); }

    /** Hanya mengembalikan riwayat milik pengguna yang sedang login. */
    public List<RiwayatAnalisis> cariMilik(int idPemilik) {
        return daftar.stream()
                .filter(r -> r.getIdPemilik() == idPemilik)
                .toList();
    }

    public boolean hapus(int id) {
        return daftar.removeIf(r -> r.getId() == id);
    }
}
