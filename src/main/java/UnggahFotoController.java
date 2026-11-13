/** Controller layar Unggah Foto dan Progres Analisis (S-05, S-06). */
public class UnggahFotoController {

    private final MesinAnalisis mesin;
    private final double ambangBawah;
    private final double ambangAtas;

    public UnggahFotoController(MesinAnalisis mesin,
            double ambangBawah, double ambangAtas) {
        this.mesin = mesin;
        this.ambangBawah = ambangBawah;
        this.ambangAtas = ambangAtas;
    }

    /** Pesan 2 sampai 5: alasan penolakan, atau null bila boleh dianalisis. */
    public String periksaBerkas(FotoUnggahan foto, KuotaHarian kuota) {
        String alasan = foto.validasi();
        if (alasan != null) {
            return alasan;
        }
        if (!kuota.cukup()) {
            return "Kuota analisis harian Anda sudah habis.";
        }
        return null;
    }

    /** Pesan 6 sampai 10: menjalankan analisis sambil melaporkan progres. */
    public HasilAnalisis mulaiAnalisis(FotoUnggahan foto, KuotaHarian kuota,
            ProgresListener listener) {
        String alasan = periksaBerkas(foto, kuota);
        if (alasan != null) {
            throw new IllegalArgumentException(alasan);
        }
        laporkan(listener, TahapAnalisis.VALIDASI);
        laporkan(listener, TahapAnalisis.PRAPROSES);
        laporkan(listener, TahapAnalisis.EKSTRAKSI);
        laporkan(listener, TahapAnalisis.KLASIFIKASI);
        double skor = mesin.klasifikasi(foto);
        kuota.gunakan();
        laporkan(listener, TahapAnalisis.VISUALISASI);
        LabelHasil label = LabelHasil.dariSkor(skor, ambangBawah, ambangAtas);
        return new HasilAnalisis(foto.getNamaBerkas(), skor, label);
    }

    /** DRY: satu method untuk semua pelaporan progres. */
    private void laporkan(ProgresListener listener, TahapAnalisis tahap) {
        listener.tampilkanProgres(tahap, tahap.getPersen());
    }
}
