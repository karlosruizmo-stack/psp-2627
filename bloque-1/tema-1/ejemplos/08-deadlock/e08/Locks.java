package e08;

/** Los dos Locks compartidos que provocan el deadlock. */
public final class Locks {
    public static final Object A = new Object();
    public static final Object B = new Object();

    private Locks() {
    }
}
