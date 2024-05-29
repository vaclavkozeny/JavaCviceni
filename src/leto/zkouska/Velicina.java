package src.leto.zkouska;

public class Velicina {
    private final byte id;
    private final String name;

    public Velicina(byte id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public byte getId() {
        return id;
    }
}
