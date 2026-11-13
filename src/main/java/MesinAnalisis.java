/** Kontrak mesin klasifikasi ML; mengembalikan skor 0,0 sampai 1,0. */
public interface MesinAnalisis {
    double klasifikasi(FotoUnggahan foto);
}
