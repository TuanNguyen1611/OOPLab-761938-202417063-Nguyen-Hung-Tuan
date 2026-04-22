package hust.soict.hedspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start, end;

        start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        end = System.currentTimeMillis();
        System.out.println("String +: " + (end - start) + " ms");

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sbf.append(r.nextInt(2));
        }
        s = sbf.toString();
        end = System.currentTimeMillis();
        System.out.println("StringBuffer: " + (end - start) + " ms");

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sbd = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sbd.append(r.nextInt(2));
        }
        s = sbd.toString();
        end = System.currentTimeMillis();
        System.out.println("StringBuilder: " + (end - start) + " ms");
    }
}