package actividad1;

public enum ContainerStatus {
    EMPTY("vacio"),
    IN_USE("en uso"),
    DONE("terminado");

    private final String value;


    ContainerStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
