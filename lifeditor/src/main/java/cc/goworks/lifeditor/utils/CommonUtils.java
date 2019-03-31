package cc.goworks.lifeditor.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

import static java.time.LocalDateTime.parse;

/**
 * Created by ge on 01/01/2018.
 */
public class CommonUtils {
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
    public static Date currentTime() {
        return new Date();
    }

    public static Date toDate(LocalDateTime localDateTime) {
        OffsetDateTime odt = OffsetDateTime.now(ZoneId.systemDefault());
        return Date.from(localDateTime.toInstant(odt.getOffset()));
    }

}
