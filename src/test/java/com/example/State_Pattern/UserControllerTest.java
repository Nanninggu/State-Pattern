package com.example.State_Pattern;

import com.example.State_Pattern.controller.UserController;
import com.example.State_Pattern.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Test
    void changeUserState() {
        String id = "test8";

        // Mock the behavior of userService
        Mockito.doNothing().when(userService).changeUserState(id);

        UserController userController = new UserController(userService);
        ResponseEntity<Void> response = userController.changeUserState(id);

        Mockito.verify(userService, Mockito.times(1)).changeUserState(id);
        assertThat(response.getStatusCodeValue()).isEqualTo(204);
    }
}