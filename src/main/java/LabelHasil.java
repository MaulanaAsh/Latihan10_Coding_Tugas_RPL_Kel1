/** Label hasil analisis; warna dan teks sama di seluruh aplikasi. */
public enum LabelHasil {
    KEMUNGKINAN_ASLI("Kemungkinan Asli"),
            TIDAK_PASTI("Tidak Pasti"),
            KEMUNGKINAN_AI("Kemungkinan AI");

    private final String teks;

    LabelHasil(String teks) { this.teks = teks; }

    public String getTeks() { return teks; }

    /** Menentukan label dari skor 0,0 sampai 1,0 menurut ambang klasifikasi. */
    public static LabelHasil dariSkor(double skor, double ambangBawah,
            double ambangAtas) {
        if (skor < ambangBawah) return KEMUNGKINAN_ASLI;
        if (skor > ambangAtas) return KEMUNGKINAN_AI;
        return TIDAK_PASTI;
    }
}
