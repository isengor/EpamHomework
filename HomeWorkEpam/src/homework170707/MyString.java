package homework170707;

/**
 * Created by Ilya on 07.07.2017.
 */
public class MyString {
    //написать String.replace() с использованием ттд
    // + String.trim свою реализацию

    public static String trim(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        if (s.indexOf(' ') != 0 && s.lastIndexOf(' ') != s.length() - 1) {
            return s;
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) > 32) {
                start = i;
                break;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) > 32) {
                end = i;
            }
        }

        return s.substring(start, end + 1);
    }

    public static String replace(String s1, String s2) {
        return null;
    }
}
