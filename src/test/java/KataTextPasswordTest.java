import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

final class KataTextPasswordTest {
  @Test
  void testKataVerifyValid() {
    var password = "Vorlesungens1ndL4ngweilig";
    var textPassword = TextPassword.newBuilder()
      .withText(password)
      .withVerificationCriterion(KataPasswordCriterion.create())
      .create();
    var verificationResult = textPassword.verify();
    assertTrue(verificationResult);
  }

  @Test
  void testKataVerifyInvalidNumberAmount() {
    var password = "VorlesungensndLngweilig";
    var textPassword = TextPassword.newBuilder()
      .withText(password)
      .withVerificationCriterion(KataPasswordCriterion.create())
      .create();
    var verificationResult = textPassword.verify();
    assertFalse(verificationResult);
  }

  @Test
  void testKataVerifyInvalidLength() {
    var password = "L4ngwei";
    var textPassword = TextPassword.newBuilder()
      .withText(password)
      .withVerificationCriterion(KataPasswordCriterion.create())
      .create();
    var verificationResult = textPassword.verify();
    assertFalse(verificationResult);
  }

  @Test
  void testKataVerifyInvalidCapitalLettersAmount() {
    var password = "l4ngweilig";
    var textPassword = TextPassword.newBuilder()
      .withText(password)
      .withVerificationCriterion(KataPasswordCriterion.create())
      .create();
    var verificationResult = textPassword.verify();
    assertFalse(verificationResult);
  }

  @Test
  void testKataVerifyInvalidLowercaseLettersAmount() {
    var password = "L4NGWEILIG";
    var textPassword = TextPassword.newBuilder()
      .withText(password)
      .withVerificationCriterion(KataPasswordCriterion.create())
      .create();
    var verificationResult = textPassword.verify();
    assertFalse(verificationResult);
  }

  @Test
  void testKataVerifyInvalidEmptyPassword() {
    var password = "";
    var textPassword = TextPassword.newBuilder()
      .withText(password)
      .withVerificationCriterion(KataPasswordCriterion.create())
      .create();
    var verificationResult = textPassword.verify();
    assertFalse(verificationResult);
  }

  @Test
  void testKataVerifyInvalidBlankPassword() {
    var password = "    ";
    var textPassword = TextPassword.newBuilder()
      .withText(password)
      .withVerificationCriterion(KataPasswordCriterion.create())
      .create();
    var verificationResult = textPassword.verify();
    assertFalse(verificationResult);
  }
}
