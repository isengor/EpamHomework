package homework170710;

import java.math.BigDecimal;

/**
 * Created by Ilya on 10.07.2017.
 */
public class Main {

    public static void main(String[] args) {
        BigDecimal start = new BigDecimal(System.nanoTime());


//        try {
//            sleep(1);
//        }
//        catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        System.out.println(new BigDecimal(System.nanoTime()).subtract(start));
    }
}
