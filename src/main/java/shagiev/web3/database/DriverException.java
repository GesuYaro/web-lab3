package shagiev.web3.database;

public class DriverException extends RuntimeException {
    public DriverException() {
        super("Driver not found");
    }

    public DriverException(String message) {
        super(message);
    }
}
