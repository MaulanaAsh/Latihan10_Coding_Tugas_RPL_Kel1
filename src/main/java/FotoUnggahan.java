import java.util.Set;

/** Berkas foto yang diunggah pengguna (S-05). */
public class FotoUnggahan {

    private static final double MAKS_UKURAN_MB = 10.0;
    private static final int MIN_PIKSEL = 256;
    private static final Set<String> FORMAT_DIDUKUNG =
            Set.of("JPEG", "PNG", "WEBP");

    private final String namaBerkas;
    private final double ukuranMb;
    private final int lebar;
    private final int tinggi;
    private final String format;

    public FotoUnggahan(String namaBerkas, double ukuranMb,
            int lebar, int tinggi, String format) {
        this.namaBerkas = namaBerkas;
        this.ukuranMb = ukuranMb;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.format = format.toUpperCase();
    }

    /** Mengembalikan alasan penolakan, atau null bila berkas valid. */
    public String validasi() {
        if (!FORMAT_DIDUKUNG.contains(format)) {
            return "Format berkas harus JPEG, PNG, atau WebP.";
        }
        if (ukuranMb > MAKS_UKURAN_MB) {
            return "Ukuran berkas melebihi 10 MB. "
                    + "Pilih foto lain atau perkecil ukurannya.";
        }
        if (lebar < MIN_PIKSEL || tinggi < MIN_PIKSEL) {
            return "Resolusi minimal 256 x 256 piksel.";
        }
        return null;
    }

    public String getNamaBerkas() { return namaBerkas; }
    public double getUkuranMb() { return ukuranMb; }
    public String getFormat() { return format; }
}
