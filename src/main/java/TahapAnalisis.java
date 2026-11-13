/** Lima tahap analisis yang ditampilkan pada layar S-06. */
public enum TahapAnalisis {
    VALIDASI("Validasi berkas dan kuota", 20),

            PRAPROSES("Praproses citra", 40),
            EKSTRAKSI("Ekstraksi artefak: ELA, FFT, noise, EXIF", 60),
            KLASIFIKASI("Klasifikasi model ML", 80),
            VISUALISASI("Membuat visualisasi dan menyimpan hasil", 100);

    private final String deskripsi;
    private final int persen;

    TahapAnalisis(String deskripsi, int persen) {
        this.deskripsi = deskripsi;
        this.persen = persen;
    }

    public String getDeskripsi() { return deskripsi; }
    public int getPersen() { return persen; }
}
