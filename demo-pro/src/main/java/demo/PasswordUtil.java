package demo;

import java.util.*;

/**
 * Created by zhoupanchn on 2019/8/7.
 */
public class PasswordUtil {
    private static final char[] CHARS = new char[]{
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '~', '!', '@', '#', '$', '%', '^', '-', '+', '&', '_'
    };

    private PasswordUtil() {
    }

    private static String randomGenerate(int length) {
        List<String> list = new ArrayList<String>(CHARS.length);
        for (int i = 0; i < CHARS.length; i++) {
            list.add(String.valueOf(CHARS[i]));
        }
        Collections.shuffle(list);

        int          count  = 0;
        StringBuffer sb     = new StringBuffer();
        Random       random = new Random(System.nanoTime());
        while (count < length) {
            int i = random.nextInt(list.size());
            sb.append(list.get(i));
            count++;
        }
        return sb.toString();
    }

    public static void getPsd(int length) {
        double random = Math.random() * 10;
        System.out.println(random);
    }

    public static void main(String[] args) {
        /*String s = randomGenerate(8);
        System.out.println(s);*/
        getPsd(8);
    }
}