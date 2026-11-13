# Latihan 10 - Konstruksi dan Implementasi Perangkat Lunak

**Aplikasi Pendeteksi Foto Hasil AI Generatif Menggunakan Analisis Artefak Digital dan Machine Learning**

Tugas kelompok mata kuliah Rekayasa Perangkat Lunak, Universitas Indraprasta PGRI (UNINDRA), kelas X7B.
Dosen pengampu: Yuli Haryanto, M.Kom.

## Kelompok 1

| Nama | NIM |
|---|---|
| Maulana Ash Shiddiq | 202343500127 |
| Muhammad Luthfi Aulia | 202343502574 |
| Ahmad Syahrul Efendi | 202343500165 |
| Mochamad Rayhan Rizkillah | 202343500144 |

## Isi repositori

Seluruh kode ada di `src/main/java` (22 file Java: 19 file berisi kode yang dapat dieksekusi dan 3 interface kontrak).
Kode dibagi menjadi empat bagian menurut layar pada rancangan antarmuka (Tugas 9).

| Bagian | Layar | Penanggung jawab | Berkas |
|---|---|---|---|
| 1. Registrasi dan Login | S-01, S-02 | Maulana Ash Shiddiq | `AutentikasiController`, `Pengguna`, `DaftarPengguna`, `PasswordUtil`, `HasilLogin`, `Peran` |
| 2. Unggah Foto dan Progres Analisis | S-05, S-06 | Muhammad Luthfi Aulia | `UnggahFotoController`, `FotoUnggahan`, `KuotaHarian`, `TahapAnalisis`, `HasilAnalisis`, `LabelHasil` |
| 3. Riwayat Analisis dan Dialog Hapus | S-08, S-16 | Ahmad Syahrul Efendi | `RiwayatController`, `RiwayatRepository`, `RiwayatAnalisis` |
| 4. Manajemen Model ML | S-12 | Mochamad Rayhan Rizkillah | `ModelMLController`, `KonfigurasiSistem`, `ModelML`, `AuditLog` |
| Kontrak (interface) | - | Bersama | `ProgresListener`, `MesinAnalisis`, `PenyimpananBerkas` |

## Cara kompilasi

Diperlukan JDK 21 atau lebih baru. Dari folder utama repositori:

```
javac -d out src/main/java/*.java
```

Kode ini berupa kelas entitas dan controller (tanpa method `main`) karena kelas antarmuka (boundary) belum dibuat.
Penyimpanan berada di memori dan mesin analisis dihubungkan lewat interface `MesinAnalisis`.
Pengujian black box dan white box terhadap kode ini dikerjakan pada Tugas 12.
