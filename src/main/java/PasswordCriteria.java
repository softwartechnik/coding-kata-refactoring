import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class PasswordCriteria implements PasswordCriterion {
  private final List<Predicate<Password>> criteria;

  private PasswordCriteria(List<Predicate<Password>> criteria) {
    this.criteria = criteria;
  }

  @Override
  public boolean test(Password password) {
    for (Predicate<Password> criterion : criteria) {
      if (!criterion.test(password)) {
        return false;
      }
    }
    return true;
  }

  public static PasswordCriteria withCriteria(List<Predicate<Password>> criteria) {
    Objects.requireNonNull(criteria);
    return new PasswordCriteria(List.copyOf(criteria));
  }
}
