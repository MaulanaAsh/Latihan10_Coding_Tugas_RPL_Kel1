/** Ambang klasifikasi dan kuota harian (S-12). */
public class KonfigurasiSistem {

    private double ambangBawah = 0.30;
    private double ambangAtas = 0.70;
    private int kuotaPengguna = 20;

    private int kuotaAnalis = 200;

    /** Mengubah konfigurasi; mengembalikan galat, atau null bila berhasil. */
    public String ubah(double bawah, double atas, int kuotaP, int kuotaA) {
        String galat = validasi(bawah, atas, kuotaP, kuotaA);
        if (galat != null) {
            return galat;
        }
        this.ambangBawah = bawah;
        this.ambangAtas = atas;
        this.kuotaPengguna = kuotaP;
        this.kuotaAnalis = kuotaA;
        return null;
    }

    private String validasi(double bawah, double atas, int kuotaP, int kuotaA) {
        if (bawah < 0 || atas > 1) {
            return "Ambang harus berada pada rentang 0 sampai 1.";
        }
        if (bawah >= atas) {
            return "Ambang bawah harus lebih kecil dari ambang atas. "
                    + "Perubahan ditolak.";
        }
        if (kuotaP <= 0 || kuotaA <= 0) {
            return "Kuota harus lebih besar dari nol.";
        }
        return null;
    }

    public double getAmbangBawah() { return ambangBawah; }
    public double getAmbangAtas() { return ambangAtas; }
    public int getKuotaPengguna() { return kuotaPengguna; }
    public int getKuotaAnalis() { return kuotaAnalis; }
}
