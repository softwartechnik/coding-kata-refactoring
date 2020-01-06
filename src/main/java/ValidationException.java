import java.util.Objects;

public class ValidationException extends Exception {
  private ValidationException(String message) {
    super(message);
  }

  public static ValidationException withMessage(String message) {
    Objects.requireNonNull(message);
    return new ValidationException(message);
  }
}
