package com.example.State_Pattern.service;

import com.example.State_Pattern.dto.User;
import com.example.State_Pattern.mapper.UserMapper;
import com.example.State_Pattern.state.Context;
import com.example.State_Pattern.state.StateA;
import com.example.State_Pattern.state.StateB;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void changeUserState(String id) {
        User user = userMapper.getUser(id);

        // print user.getState(), 상태 출력
        System.out.println("CheckUserState::" + user.getState());

        // getState() 값이 "StateB"이면 StateB (inactive)로, 아니면 StateA(active)로 Context 생성
        // 현재 상태를 가져와서 상태값을 변경하고, 변경된 상태값을 출력
        Context context;
        if (user.getState().equals("StateB")) {
            context = new Context(new StateB());
        } else {
            context = new Context(new StateA());
        }

        context.request();
        user.setState(context.getState().getDescription());
        System.out.println("CheckUserState::" + user.getState());
        userMapper.updateUser(user);
    }
}