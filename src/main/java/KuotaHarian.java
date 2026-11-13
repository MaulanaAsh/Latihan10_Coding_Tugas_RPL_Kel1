/** Kuota analisis harian; direset pukul 00.00 WIB. */
public class KuotaHarian {

    private final int batas;
    private int terpakai;

    public KuotaHarian(int batas, int terpakai) {
        this.batas = batas;
        this.terpakai = terpakai;
    }

    public boolean cukup() { return terpakai < batas; }

    public void gunakan() { terpakai++; }

    public int sisa() { return batas - terpakai; }
}
