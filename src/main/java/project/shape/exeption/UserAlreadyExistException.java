package project.shape.exeption;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String message) {
        super("User \"" + message + "\" already exist");
    }
}
