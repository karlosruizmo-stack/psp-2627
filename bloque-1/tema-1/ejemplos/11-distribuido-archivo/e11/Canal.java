package e11;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

/**
 * El archivo canal.txt es el mensaje entre dos procesos.
 * En un sistema de verdad esto sería Redis, una cola, SQL o una llamada a otro servicio.
 */
public final class Canal {

    public static final int TAREAS = 5;
    public static final long PAUSA_MS = 50;
    /** Los dos esperan esto antes de escribir su respuesta, para poder leer el intercambio. */
    public static final long ANTES_DE_CONTESTAR_MS = 5_000;
    public static final Path ARCHIVO = localizar();

    private Canal() {
    }

    public static void escribir(String mensaje) throws IOException {
        Files.createDirectories(ARCHIVO.getParent());
        // Cada proceso tiene su temporal. Si los dos usaran canal.txt.tmp,
        // uno lo renombra y el otro revienta: el archivo ya no está.
        Path temporal = ARCHIVO.resolveSibling("canal-" + ProcessHandle.current().pid() + ".tmp");
        Path cerrojo = ARCHIVO.resolveSibling("canal.lock");
        try (FileChannel canal = FileChannel.open(cerrojo, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
             FileLock candado = canal.lock()) {
            Files.writeString(temporal, mensaje + System.lineSeparator());
            publicar(temporal);
        } finally {
            Files.deleteIfExists(temporal);
        }
    }

    private static void publicar(Path temporal) throws IOException {
        try {
            Files.move(temporal, ARCHIVO, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        } catch (AtomicMoveNotSupportedException e) {
            Files.move(temporal, ARCHIVO, StandardCopyOption.REPLACE_EXISTING);
        } catch (NoSuchFileException e) {
            // En macOS el rename a veces falla si el otro proceso está leyendo canal.txt.
            if (Files.exists(temporal)) {
                Files.copy(temporal, ARCHIVO, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    public static String leer() throws IOException {
        if (!Files.exists(ARCHIVO)) {
            return "";
        }
        return Files.readString(ARCHIVO).trim();
    }

    private static Path localizar() {
        Path dir = Path.of(System.getProperty("user.dir")).toAbsolutePath();
        while (dir != null) {
            if (Files.isDirectory(dir.resolve("bloque-1/tema-1/ejemplos"))) {
                return dir.resolve("bloque-1/tema-1/ejemplos/11-distribuido-archivo/canal.txt");
            }
            dir = dir.getParent();
        }
        throw new IllegalStateException("Arranca el programa desde el repo psp-2627");
    }
}
