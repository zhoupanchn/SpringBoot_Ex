import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhoupanchn on 2019/4/18.
 */
public class CB {
    public static void main(String[] args) {
        /*int i = 0;
        int b = 5;
       *//* do {
            i += 1;
            System.out.println("AAAA");
        } while (i <= b);*//*
        //System.out.println("gjaslkjgljalkgjlkajlk");
        *//*String str="gjaslkjgljalkgjlkajlk";
        if(str.contains("ka")){
            System.out.println("A");
        }else {
            System.out.println("B");
        }*//*
        int c=1;
        for (int a = 0; a < b; a++) {
            c += 1;
            System.out.println(c);
        }*/
        /*String       p        = "";
        List<String> planCode = new ArrayList<>();
        List<String> strings  = Arrays.asList(p.split(","));
        if (strings != null && strings.size() > 0) {
            for (String string : strings) {
                String[] split = string.split("\\[");
                planCode.add(split[0]);
            }
        }
        String join = String.join(",", planCode);
        System.out.println(join);*/
        /*SimpleDateFormat sdf      = new SimpleDateFormat("yyyy-MM-dd");
        Calendar         calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        String        startDate   = sdf.format(new Date());
        String        endDate     = sdf.format(calendar.getTime());
        System.out.println(startDate);
        System.out.println(endDate);*/
        /*String str = "hjk";
        System.out.println(isNumeric(str));*/
       /* Map<String, String> map = new HashMap<>();
        map.put("82-897-N", "82-897/贝太厨房");
        map.put("2-156-N", "2-156/儿童文学（上）");
        map.put("2-916-N", "2-916/中国与非洲");
        map.put("80-455-N", "80-455/亚太安全与海洋研究");
        map.put("82-574-N", "82-574/军事世界画刊");
        String str = "82-897";
        String s   = map.get(str);
        System.out.println(s);*/
        System.out.println("MFA" + Long.toHexString(System.currentTimeMillis()).toUpperCase());
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum   = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}