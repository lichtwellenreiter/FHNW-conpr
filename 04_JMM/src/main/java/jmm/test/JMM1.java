package jmm.test;

public class JMM1 {
    private static int value = 0;
    private volatile static boolean ready = false;

    public static void main(String[] args) {
        new Thread("T1") {
            public void run() {
                value = 77;
                ready = true;
            }
        }.start();

        new Thread("T2") {
            public void run() {
                if (ready) {
                    System.out.println(value);
                }
            }
        }.start();
    }
}
