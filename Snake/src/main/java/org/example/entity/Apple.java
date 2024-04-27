package org.example.entity;

import com.raylib.Raylib.Vector2;
import org.example.state.State;

import static com.raylib.Jaylib.RED;
import static com.raylib.Raylib.*;

public class Apple extends Entity {
    boolean isEaten;

    public Apple() {
        State state = new State();
        int randValue1 = state.getrandValue1();
        int randValue2 = state.getrandValue2();

        isEaten = false;
        color = RED;
        height = 16;
        width = 16;
        position = new Vector2();
        position.x(randValue1);
        position.y(randValue2);
    }

    public void update() {
        State state = new State();
        int randValue1 = state.getrandValue1();
        int randValue2 = state.getrandValue2();

        if (isEaten) {
            isEaten = false;
            position.x(randValue1);
            position.y(randValue2);
        }
    }
    public void draw() {
        DrawRectangle((int) position.x(), (int) position.y(), width, height, color);

    }
}




