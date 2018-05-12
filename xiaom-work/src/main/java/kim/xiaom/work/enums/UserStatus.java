package kim.xiaom.work.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by ge on 13/05/2018.
 */
public enum UserStatus {
    AVAILABLE("可用", 1),
    DISABLE("不可用", 0),
    ;

    private String name;
    private Integer value;

    UserStatus(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public UserStatus getByValue(Integer value) {
        Optional<UserStatus> activeEnum = Arrays.asList(UserStatus.values()).stream().filter(x -> x.getValue().equals(value)).findFirst();

        if (activeEnum.isPresent()) {
            return activeEnum.get();
        }

        return null;
    }
}
