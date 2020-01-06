public final class NumberPasswordCriterion implements PasswordCriterion {
  private final int minimumNumberAmount;

  private NumberPasswordCriterion(int minimumNumberAmount) {
    this.minimumNumberAmount = minimumNumberAmount;
  }

  @Override
  public boolean test(Password password) {
    var numberAmount = countNumbers(password.toString());
    return numberAmount >= minimumNumberAmount;
  }

  private long countNumbers(String password) {
    return password.chars()
      .filter(Character::isDigit)
      .count();
  }

  public static NumberPasswordCriterion withMinimumNumberAmount(
    int minimumNumberAmount
  ) {
    return new NumberPasswordCriterion(minimumNumberAmount);
  }
}
