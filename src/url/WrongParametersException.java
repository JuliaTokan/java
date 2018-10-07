package url;

public class WrongParametersException extends Exception {
    public WrongParametersException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "WrongParametersException: " + super.getMessage();
    }
}
