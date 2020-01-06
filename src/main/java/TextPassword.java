import java.util.Objects;

public final class TextPassword implements Password {
  private final String text;
  private final PasswordCriterion criterion;

  private TextPassword(String text, PasswordCriterion criterion) {
    this.text = text;
    this.criterion = criterion;
  }

  @Override
  public boolean verify() {
    return criterion.test(this);
  }

  @Override
  public String toString() {
    return text;
  }

  public static Builder newBuilder() {
    return new Builder(DefaultPasswordCriterion.create());
  }

  public static final class Builder {
    private String text;
    private PasswordCriterion criterion;

    public Builder(PasswordCriterion criterion) {
      this.criterion = criterion;
    }

    public Builder withText(String text) {
      Objects.requireNonNull(text);
      this.text = text;
      return this;
    }

    public Builder withVerificationCriterion(PasswordCriterion criterion) {
      Objects.requireNonNull(criterion);
      this.criterion = criterion;
      return this;
    }

    public TextPassword create() {
      Objects.requireNonNull(text);
      Objects.requireNonNull(criterion);
      return new TextPassword(text, criterion);
    }
  }
}
