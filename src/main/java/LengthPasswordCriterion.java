public final class LengthPasswordCriterion implements PasswordCriterion {
  private final int minLength;

  private LengthPasswordCriterion(int minLength) {
    this.minLength = minLength;
  }

  @Override
  public boolean test(Password password) {
    return password.toString().length() >= minLength;
  }

  public static LengthPasswordCriterion withMinLength(int minLength) {
    return new LengthPasswordCriterion(minLength);
  }
}
