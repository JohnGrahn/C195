package Main;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class timeUtil {

    /**
     * Converts time to UTC
     * @param storeDateTime
     * @return
     */
    public static String convertUTC (String storeDateTime) {
        Timestamp timestamp = Timestamp.valueOf(String.valueOf(storeDateTime));
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(ZoneId.systemDefault().toString()));
        ZonedDateTime utcZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        LocalDateTime localDateTimeOut = utcZonedDateTime.toLocalDateTime();
        String utcTime = localDateTimeOut.format(DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss"));
        return utcTime;
    }
}
