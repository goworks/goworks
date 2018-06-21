package kim.xiaom.work.utils;

import java.util.Date;
import java.util.UUID;

/**
 * Created by ge on 01/01/2018.
 */
public class XiaomUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    public static Date currentTime() {
        return new Date();
    }
}
