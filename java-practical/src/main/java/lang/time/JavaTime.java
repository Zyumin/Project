package lang.time;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2019-09-09 2:52 PM
 */
public class JavaTime {
    public static void main(String[] args) {


        LocalDateTime date = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);

        System.out.println(
                date.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));

        System.out.println(
                date.plusDays(1).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));


    }
}
