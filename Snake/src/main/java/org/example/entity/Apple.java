package org.example.entity;

import com.raylib.Raylib.Vector2;
import lombok.Getter;
import lombok.Setter;

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
        position.x(getRandomValue(0,884));
        position.y(getRandomValue(0,584));
    }

    public void update() {
        if (isEaten) {
            isEaten = false;
        }
    }
    public void draw() {
        DrawRectangle((int) position.x(), (int) position.y(), width, height, color);
    }

    protected Rect getAppleRect() {
        return new Rect(position.x(), position.y(), width, height);
    }

    void rollNewPosition() {
        position.x(getRandomValue(0,884));
        position.y(getRandomValue(0,584));
    }
}




