package cc.goworks.lifeditor.enums;

public enum StaffType {
    INTERN((byte)1, "实习"),
    POBATION((byte)2, "试用"),
    NORMAL((byte)3, "正式"),
    ;

    private final byte value;
    private final String name;

    public byte getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    StaffType(byte value, String name) {
        this.value = value;
        this.name = name;
    }
}
