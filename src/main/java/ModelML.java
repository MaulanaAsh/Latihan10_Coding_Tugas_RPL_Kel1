/** Satu versi model ML pada tabel versi (S-12). */
public class ModelML {

    private final String versi;
    private final double accuracy;
    private final double precision;
    private final double recall;
    private final double f1;
    private final double aucRoc;
    private boolean aktif;

    public ModelML(String versi, double accuracy, double precision,
            double recall, double f1, double aucRoc) {
        this.versi = versi;
        this.accuracy = accuracy;
        this.precision = precision;
        this.recall = recall;
        this.f1 = f1;
        this.aucRoc = aucRoc;
        this.aktif = false;
    }

    public void aktifkan() { this.aktif = true; }

    public void nonaktifkan() { this.aktif = false; }

    public String getVersi() { return versi; }
    public boolean isAktif() { return aktif; }
    public double getAccuracy() { return accuracy; }
    public double getF1() { return f1; }
}
