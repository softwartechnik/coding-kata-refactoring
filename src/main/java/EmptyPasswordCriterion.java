public final class EmptyPasswordCriterion implements PasswordCriterion {
  private EmptyPasswordCriterion() {
  }

  @Override
  public boolean test(Password password) {
    var text = password.toString();
    return !text.isEmpty() && !text.isBlank();
  }

  public static EmptyPasswordCriterion create() {
    return new EmptyPasswordCriterion();
  }
}
