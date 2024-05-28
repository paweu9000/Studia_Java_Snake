package org.example.entity;

import com.raylib.Raylib.Vector2;
import lombok.Getter;
import lombok.Setter;
import org.example.state.State;

import static com.raylib.Jaylib.RED;
import static com.raylib.Raylib.*;

@Getter
@Setter
public class Apple extends Entity {
    boolean isEaten;

    public int getRandomValue(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    public Apple() {
        isEaten = false;
        color = RED;
        height = 16;
        width = 16;
        position = new Vector2();
        rollNewPosition();
    }

    public void update() {
        if (isEaten) {
            isEaten = false;
            rollNewPosition();
        }
    }
    public void draw() {
        DrawRectangle((int) position.x(), (int) position.y(), width, height, color);
    }

    protected Rect getAppleRect() {
        return new Rect(position.x(), position.y(), width, height);
    }

    void rollNewPosition() {
        position.x(getRandomValue(State.SCREEN_OFFSET+5, State.SCREEN_WIDTH-State.SCREEN_OFFSET-width-5));
        position.y(getRandomValue(State.SCREEN_OFFSET+5, State.SCREEN_HEIGHT-State.SCREEN_OFFSET-width-5));
    }
}




