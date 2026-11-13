import java.time.LocalDate;

/** Satu baris riwayat analisis pada layar S-08. */
public class RiwayatAnalisis {

    private final int id;
    private final int idPemilik;
    private final String namaBerkas;
    private final LocalDate tanggal;
    private final LabelHasil label;
    private final double skor;

    public RiwayatAnalisis(int id, int idPemilik, String namaBerkas,
            LocalDate tanggal, LabelHasil label, double skor) {
        this.id = id;
        this.idPemilik = idPemilik;
        this.namaBerkas = namaBerkas;
        this.tanggal = tanggal;
        this.label = label;
        this.skor = skor;
    }

    public int getId() { return id; }
    public int getIdPemilik() { return idPemilik; }
    public String getNamaBerkas() { return namaBerkas; }
    public LocalDate getTanggal() { return tanggal; }
    public LabelHasil getLabel() { return label; }
    public double getSkor() { return skor; }
}
