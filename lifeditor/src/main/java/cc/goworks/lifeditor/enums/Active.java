package cc.goworks.lifeditor.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by ge on 31/12/2017.
 */
public enum Active {
    INACTIVE((byte)0, "失效"),
    ACTIVE((byte)1, "生效"),
    ;

    private final byte value;
    private final String name;

    public byte getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    Active(byte value, String name) {
        this.value = value;
        this.name = name;
    }

    public Active getByValue(byte value) {
        Optional<Active> activeEnum = Arrays.stream(Active.values())
            .filter(x -> x.getValue() == value)
            .findFirst();

        return activeEnum.orElse(null);
    }
}
