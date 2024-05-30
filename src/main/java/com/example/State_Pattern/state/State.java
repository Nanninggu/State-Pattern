package com.example.State_Pattern.state;

public interface State {
    void handle(Context context);

    String getDescription();
}