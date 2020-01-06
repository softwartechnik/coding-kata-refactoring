import java.util.List;

public final class KataPasswordCriterion implements PasswordCriterion {
  private static final int MIN_PASSWORD_LENGTH = 8;
  private static final int MIN_LOWERCASE_LETTERS = 1;
  private static final int MIN_CAPITAL_LETTERS = 1;
  private static final int MIN_NUMBER_AMOUNT = 1;
  private static final PasswordCriterion KATA_CRITERION = PasswordCriteria
    .withCriteria(List.of(
      LengthPasswordCriterion.withMinLength(MIN_PASSWORD_LENGTH),
      EmptyPasswordCriterion.create(),
      LowerCasePasswordCriterion
        .withMinimumLowerCaseLetters(MIN_LOWERCASE_LETTERS),
      CapitalPasswordCriterion
        .withMinimumCapitalLettersAmount(MIN_CAPITAL_LETTERS),
      NumberPasswordCriterion.withMinimumNumberAmount(MIN_NUMBER_AMOUNT)
    ));

  private KataPasswordCriterion() {
  }

  @Override
  public boolean test(Password password) {
    return KATA_CRITERION.test(password);
  }

  public static KataPasswordCriterion create() {
    return new KataPasswordCriterion();
  }
}
