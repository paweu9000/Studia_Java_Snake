package org.example;


import org.example.state.State;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        State state = new State();
        state.initializeGame();
    }
}