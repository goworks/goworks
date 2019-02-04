package cc.goworks.work.config;

import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * Created by wnow20 on 29/12/2017.
 */
@Component
public class EnvMap {
    private static Map<String, String> env = System.getenv();

    public static String MYSQL_USERNAME = getByKey("MYSQL_USERNAME");
    public static String MYSQL_PASSWORD = getByKey("MYSQL_PASSWORD");

    public static String getByKey(String key) {
        return env.get(key);
    }
}
