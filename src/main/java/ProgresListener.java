/** Callback agar UI dapat memperbarui progres (visibility of system status). */
@FunctionalInterface
public interface ProgresListener {
    void tampilkanProgres(TahapAnalisis tahap, int persen);
}
