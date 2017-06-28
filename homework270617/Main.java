package homework270617;

/**
 * Created by Ilya on 28.06.2017.
 */


public class Main {
    public static void main(String[] args) {
        //BINARY
        System.out.println(IntConverter.toBinaryString(11));
        System.out.println(IntConverter.toBinaryString(16));
        //HEX
        System.out.println(IntConverter.toHexString(11));
        System.out.println(IntConverter.toHexString(124));
        //OCTAL
        System.out.println(IntConverter.toOctalString(15));
        System.out.println(IntConverter.toOctalString(8));
        //OPTIONAL RADIX
        System.out.println(IntConverter.toString(123, 2));
        System.out.println(IntConverter.toString(1256, 16));
    }
}
