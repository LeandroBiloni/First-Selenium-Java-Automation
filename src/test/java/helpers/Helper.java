package helpers;

/**
 * Class for helper/utilities methods
 */
public class Helper {

    /**
     * Pause execution by the given time
     * @param seconds the time to stop the program execution
     */
    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }    
}
