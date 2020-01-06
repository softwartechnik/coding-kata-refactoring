public final class LowerCasePasswordCriterion implements PasswordCriterion {
  private final int minimumLowerCaseLettersAmount;

  private LowerCasePasswordCriterion(int minimumLowerCaseLettersAmount) {
    this.minimumLowerCaseLettersAmount = minimumLowerCaseLettersAmount;
  }

  @Override
  public boolean test(Password password) {
    var lowerCaseLettersAmount = countLowerCaseLetters(password.toString());
    return lowerCaseLettersAmount >= minimumLowerCaseLettersAmount;
  }

  private long countLowerCaseLetters(String password) {
    return password.chars()
      .filter(Character::isLowerCase)
      .count();
  }

  public static LowerCasePasswordCriterion withMinimumLowerCaseLetters(
    int minimumLowerCaseLettersAmount
  ) {
    return new LowerCasePasswordCriterion(minimumLowerCaseLettersAmount);
  }
}
