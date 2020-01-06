public final class CapitalPasswordCriterion implements PasswordCriterion {
  private final int minimumCapitalLettersAmount;

  private CapitalPasswordCriterion(int minimumCapitalLettersAmount) {
    this.minimumCapitalLettersAmount = minimumCapitalLettersAmount;
  }

  @Override
  public boolean test(Password password) {
    var capitalLettersAmount = countCapitalLetters(password.toString());
    return capitalLettersAmount >= minimumCapitalLettersAmount;
  }

  private long countCapitalLetters(String password) {
    return password.chars()
      .filter(Character::isUpperCase)
      .count();
  }

  public static CapitalPasswordCriterion withMinimumCapitalLettersAmount(
    int minimumCapitalLettersAmount
  ) {
    return new CapitalPasswordCriterion(minimumCapitalLettersAmount);
  }
}
