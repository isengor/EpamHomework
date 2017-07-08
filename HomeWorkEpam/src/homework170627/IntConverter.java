package homework170627;

/**
 * Created by Ilya on 28.06.2017.
 */
public class IntConverter {
    //    Написать методы, преобразующие десятичное число в строковое представление в разных системах счисления
//
//		System.out.println(x);
//		System.out.println(Integer.toBinaryString(x));  // required
//		System.out.println(Integer.toHexString(x)); // required
//		System.out.println(Integer.toOctalString(x)); // required
//		System.out.println(Integer.toString(x,3));  // с указанием основания системы счисления  optional
    public static String toBinaryString(int x) {
        int mod;
        String s = "";

        do {
            mod = x - (x / 2) * 2;
            s += mod;
            x /= 2;
        } while (x != 0);

        return "0b" + new StringBuffer(s).reverse();

    }

    public static String toHexString(int x) {
        int mod;
        String s = "";

        do {
            mod = x - (x / 16) * 16;
            if (mod >= 10 & mod <= 15) {
                switch (mod) {
                    case 10:
                        s += "A";
                        break;
                    case 11:
                        s += "B";
                        break;
                    case 12:
                        s += "C";
                        break;
                    case 13:
                        s += "D";
                        break;
                    case 14:
                        s += "E";
                        break;
                    case 15:
                        s += "F";
                        break;

                }
            } else s += mod;
            x /= 16;
        } while (x != 0);

        return "0x" + new StringBuffer(s).reverse();
    }

    public static String toOctalString(int x) {
        int mod;
        String s = "";

        do {
            mod = x - (x / 8) * 8;
            s += mod;
            x /= 8;
        } while (x != 0);

        return new StringBuffer(s).reverse().toString();
    }

    public static String toString(int x, int radix) {
        switch (radix) {
            case 2: {
                return toBinaryString(x);
            }
            case 8: {
                return toOctalString(x);
            }
            case 16: {
                return toHexString(x);
            }

            default:
                return "Non-existent radix";
        }
    }
}
