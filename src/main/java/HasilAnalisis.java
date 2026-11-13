import java.time.LocalDateTime;

/** Hasil analisis yang ditampilkan pada layar S-07. */
public class HasilAnalisis {

    private final String namaBerkas;
    private final double skor;
    private final LabelHasil label;
    private final LocalDateTime waktu;

    public HasilAnalisis(String namaBerkas, double skor, LabelHasil label) {
        this.namaBerkas = namaBerkas;
        this.skor = skor;
        this.label = label;
        this.waktu = LocalDateTime.now();
    }

    public String getNamaBerkas() { return namaBerkas; }
    public double getSkor() { return skor; }
    public LabelHasil getLabel() { return label; }
    public LocalDateTime getWaktu() { return waktu; }
}
