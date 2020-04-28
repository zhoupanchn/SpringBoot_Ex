import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by zhoupanchn on 2018/7/16.
 */
public class test {
    public static RestTemplate getRestTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        return new RestTemplate(requestFactory);
    }

    public static void main(String[] args) throws IOException {

        /*byte[]                buffer = null;
        FileInputStream       fis    = null;
        ByteArrayOutputStream bos    = null;
        try {
            File file = new File("F:/123.zip");
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int    n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            buffer = bos.toByteArray();
            byte[] csvByte = FileOper.unzip(buffer, "");

            System.out.println(new String(csvByte));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fis.close();
            bos.close();
        }*/
        /*SimpleDateFormat sdf        = new SimpleDateFormat("yyyy-MM-dd");
        String           dateNowStr = sdf.format(new Date());
        System.out.println("格式化后的日期：" + dateNowStr);*/


        /*Long     startDay = null;
        Calendar c2       = new GregorianCalendar();
        c2.set(Calendar.HOUR_OF_DAY, 23);
        c2.set(Calendar.MINUTE, 59);
        c2.set(Calendar.SECOND, 59);
        String           string = c2.getTime().toLocaleString();
        SimpleDateFormat sfd    = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sfd.parse(string);
            startDay = (date.getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(string);
        System.out.println(startDay);*/

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Long      startDay  = null;
        Date      date      = new Date();
        LocalDate inputDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        TemporalAdjuster FIRST_OF_WEEK = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.minusDays(localDate.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue()));

        System.out.println(date);
        LocalDate er = inputDate.with(FIRST_OF_WEEK);

        String format = fmt.format(er);
        System.out.println("riqi:" + format);


        TemporalAdjuster LAST_OF_WEEK = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
        String           string       = (inputDate.with(LAST_OF_WEEK)).toString() + " 23:59:59";
        SimpleDateFormat sfd          = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sfd.parse(string);
            startDay = (date.getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(startDay);


        /*Integer restQuota = 123;
        Integer  quota     = 2345;
        System.out.println(restQuota*3<quota);
        System.out.println(new Date());*/


       /* Long             dateTime     = null;
        Date             date         = new Date();
        LocalDate        inputDate    = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        TemporalAdjuster LAST_OF_WEEK = TemporalAdjusters.ofDateAdjuster(localDate -> localDate.plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
        String           weekDay      = (inputDate.with(LAST_OF_WEEK)).toString() + " 23:59:59";
        SimpleDateFormat sfd          = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dateTime = (sfd.parse(weekDay).getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dateTime);*/
    }
}