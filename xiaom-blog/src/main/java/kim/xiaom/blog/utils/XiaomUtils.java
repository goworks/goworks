package kim.xiaom.blog.utils;

import java.util.UUID;

/**
 * Created by ge on 01/01/2018.
 */
public class XiaomUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
