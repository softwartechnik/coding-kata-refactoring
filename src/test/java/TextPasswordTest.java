import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

final class TextPasswordTest {
  @Test
  void testVerifyDefault() {
    var password = "";
    var textPassword = TextPassword.newBuilder()
      .withText(password)
      .create();
    var verificationResult = textPassword.verify();
    assertTrue(verificationResult);
  }

  @Test
  void testVerifyNull() {
    Executable creation = () -> {
      String password = null;
      TextPassword.newBuilder()
        .withText(password)
        .create();
    };
    assertThrows(NullPointerException.class, creation);
  }
}