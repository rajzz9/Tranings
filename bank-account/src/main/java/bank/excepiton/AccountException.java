package bank.excepiton;

public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }
}