package home.exception;

public class InvalidIncomingData extends  RuntimeException {

    public InvalidIncomingData(String message) {
        super(message);
    }
}
