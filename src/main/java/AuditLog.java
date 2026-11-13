import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Audit log hanya-tambah: entri tidak dapat diubah atau dihapus. */
public class AuditLog {

    private final List<String> catatan = new ArrayList<>();

    public void catat(String pelaku, String aksi, String target) {
        catatan.add(LocalDateTime.now() + " | " + pelaku + " | " + aksi
                + " | " + target);
    }

    public List<String> getCatatan() {
        return Collections.unmodifiableList(catatan);
    }
}
