import org.apache.commons.lang3.time.FastDateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) {
        //首先定义格式
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        //按格式进行转换
        String strDate2 = "2017-10-27";
        try {
            Date sd = sdf2.parse(strDate2);
            System.out.println(sd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
