package Mocking_Stubbing;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MockitoTest {
    public interface UserService {
        String getUserEmail(int userId);
    }

    @Test
    public void testMockUserService() {
        UserService userService = mock(UserService.class);
        when(userService.getUserEmail(1)).thenReturn("alice@example.com");
        System.out.println(userService.getUserEmail(1)); // Should print alice@example.com
    }
}
