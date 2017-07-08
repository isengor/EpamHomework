package homework170624;

/**
 * Created by Ilya on 26.06.2017.
 */
public class SimpleUnit {

    //    Написать с помощью TDD, при необходимости расширив SimpleUnit:
//
//            - sign(int a) - высисление знака числа:  -1 если отрицательно, 1 если положительное, 0 если 0
//            - mod(int a, int b)  - вычисление отстатка от деления нацело, не используя оператор %
//            - isPrime(int a)  - если число простое, вернуть true, иначе false
//            - isFibonacci(int a)  - если это число из ряда Фибоначчи - вернуть true, иначе false

    public static int sing(int a) {
        if (a == 0)
            return 0;
        else
            return a > 0 ? 1 : -1;
    }

    public static int mod(int a, int b) {
        try {
            return a - (a / b) * b;
        } catch (ArithmeticException ae) {
            System.err.println("Error, Zero divide");
            return 0;
        }
    }

    public static boolean isPrime(int a) {
        if (a == 1)
            return false;

        for (int i = 2; i * i <= a; i++) {

            if (a % i == 0)
                return false;
        }

        return true;
    }

    public static boolean isFibonacci(int a) {
        int fib = 0;
        int x1 = 1, x2 = 0;
        while (fib <= a) {
            if (fib == a)
                return true;
            fib = x1 + x2;
            x2 = x1;
            x1 = fib;
        }
        return false;
    }


}
