package cc.goworks.work.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by ge on 13/05/2018.
 */
public enum UserStatus {
    AVAILABLE("可用", (byte)1),
    DISABLE("不可用", (byte)0),
    ;

    private final String name;
    private final byte value;

    UserStatus(String name, byte value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public byte getValue() {
        return value;
    }

    public UserStatus getByValue(Integer value) {
        Optional<UserStatus> activeEnum = Arrays.stream(UserStatus.values())
            .filter(x -> x.getValue() == value)
            .findFirst();

        return activeEnum.orElse(null);
    }
}
