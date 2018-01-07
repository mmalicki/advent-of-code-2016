package day12.instruction;

public enum Register {
    REG_A("a"),
    REG_B("b"),
    REG_C("c"),
    REG_D("d");

    private final String name;

    Register(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
