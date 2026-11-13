/** Hasil proses login yang dikirim kembali ke LoginUI. */
public record HasilLogin(boolean berhasil, String pesan, String layarTujuan) { }
