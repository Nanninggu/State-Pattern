package com.example.State_Pattern;

import com.example.State_Pattern.dto.User;
import com.example.State_Pattern.mapper.UserMapper;
import com.example.State_Pattern.service.UserService;
import com.example.State_Pattern.state.Context;
import com.example.State_Pattern.state.StateB;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private Context context;

    @Test
    void changeUserState() {
        String id = "test8";
        User user = new User();
        user.setId(id);
        user.setState("StateA");

        // Mock the behavior of userMapper
        Mockito.when(userMapper.getUser(id)).thenReturn(user);

        // Mock the behavior of context
        Mockito.when(context.getState()).thenReturn(new StateB());

        UserService userService = new UserService(userMapper);
        userService.changeUserState(id);

        Mockito.verify(userMapper, Mockito.times(1)).getUser(id);
        Mockito.verify(userMapper, Mockito.times(1)).updateUser(user);
        assertThat(user.getState()).isEqualTo("StateB");
    }
}