package VERIFY_INTERACTIONS;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class VerifyTest {
    public interface EmailService {
        void sendWelcomeEmail(String email);
    }

    @Test
    public void testSendWelcomeEmailCalled() {
        EmailService emailService = mock(EmailService.class);
        emailService.sendWelcomeEmail("bob@example.com");
        verify(emailService).sendWelcomeEmail("bob@example.com");
    }
}
