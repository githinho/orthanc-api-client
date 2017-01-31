package hr.fer.zari;

/**
 * Created by eugen on 18/12/2016.
 */
public class OrthancException extends Exception {

    public OrthancException() {
    }

    public OrthancException(String message) {
        super(message);
    }

    public OrthancException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrthancException(Throwable cause) {
        super(cause);
    }
}
