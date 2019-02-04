package cc.goworks.work.enums;

public enum Gender {
    FEMALE((byte)0, ""),
    MALE((byte)1, ""),
    ;

    private final byte value;
    private final String name;

    public byte getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    Gender(byte value, String name) {
        this.value = value;
        this.name = name;
    }
}
