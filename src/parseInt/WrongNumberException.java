package parseInt;

public class WrongNumberException extends Exception {
    public WrongNumberException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "WrongNumberException: " + super.getMessage();
    }
}
