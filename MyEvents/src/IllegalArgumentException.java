/**
 * Diese Exception wird geworfen wenn der Benutzer unzul�ssige Argumente angibt.
 * @author Jakub
 *
 */

public class IllegalArgumentException
extends Exception {
    public IllegalArgumentException(String message) {
        super(message);
    }
}