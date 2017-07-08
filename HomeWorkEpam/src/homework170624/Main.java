package homework170624;

import static homework170624.SimpleUnit.*;

/**
 * Created by Ilya on 26.06.2017.
 */
public class Main {

    public static void main(String[] args) {

        //sing(int a) test
        //
        System.out.println(sing(-24));
        System.out.println(sing(0));
        System.out.println(sing(13));


        //mod(int a,int b) test
        //
        System.out.println(mod(20, 2));
        System.out.println(mod(55, 0));
        System.out.println(mod(-12, 5));


        //isPrime(int a) test
        //
        System.out.println(isPrime(123));
        System.out.println(isPrime(2));
        System.out.println(isPrime(13));


        //isFibonacci(int a) test
        //
        System.out.println(isFibonacci(14));
        System.out.println(isFibonacci(1));
        System.out.println(isFibonacci(55));

    }
}
