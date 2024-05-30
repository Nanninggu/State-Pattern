package com.example.State_Pattern.state;

public class StateB implements State {
    @Override
    public void handle(Context context) {
        context.setState(new StateB());
    }

    public String getDescription() {
        return "inactive";
    }
}