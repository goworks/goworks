package cc.goworks.work.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by ge on 31/12/2017.
 */
public enum ActiveEnum {
    ACTIVE("有效", 1),
    INACTIVE("失效", 0),
    ;

    private String name;
    private Integer value;

    ActiveEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public ActiveEnum getByValue(Integer value) {
        Optional<ActiveEnum> activeEnum = Arrays.asList(ActiveEnum.values()).stream().filter(x -> x.getValue().equals(value)).findFirst();

        if (activeEnum.isPresent()) {
            return activeEnum.get();
        }

        return null;
    }
}
