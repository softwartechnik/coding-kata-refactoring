public final class DefaultPasswordCriterion implements PasswordCriterion {
  private DefaultPasswordCriterion() {
  }

  @Override
  public boolean test(Password password) {
    return true;
  }

  public static DefaultPasswordCriterion create() {
    return new DefaultPasswordCriterion();
  }
}
