package util;

public class TestUtils {

    private static final int TIMEOUT = 2000;

    public static void pauseTest(){
        pauseTest(TIMEOUT);
    }

    public static void pauseTest(int timout){
        try {
            Thread.sleep(timout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
