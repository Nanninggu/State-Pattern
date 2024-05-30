package com.example.State_Pattern.state;

public class StateA implements State {
    @Override
    public void handle(Context context) {
        context.setState(new StateA());
    }

    public String getDescription() {
        return "active";
    }
}