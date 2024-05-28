package org.example.entity;

import com.raylib.Raylib.*;
import org.example.state.State;

import java.util.ArrayList;
import java.util.List;

import static com.raylib.Jaylib.WHITE;
import static com.raylib.Raylib.*;

public class Snake extends Entity{
    List<Vector2> snakeParts;
    float speed;
    Direction direction;

    public Snake() {
        color = WHITE;
        position = new Vector2();
        position.x(420);
        position.y(270);
        width = 16;
        height = 16;
        speed = 5f;
        snakeParts = new ArrayList<>();
        direction = Direction.NORTH;
        for (int i = 0; i < 10; i++) {
            addSnakePart();
        }
    }

    private void addSnakePart() {
        if (snakeParts.isEmpty()) {
            var vec = new Vector2();
            vec.x(position.x());
            vec.y(position.y());
            snakeParts.add(vec);
        }
        else {
            var lastPart = snakeParts.get(snakeParts.size()-1);
            var newPart = new Vector2();
            newPart.x(lastPart.x());
            newPart.y(lastPart.y());
            snakeParts.add(newPart);
        }
    }

    public void processInput(int key) {
        switch (key) {
            case KEY_A -> {
                if (direction != Direction.EAST) direction = Direction.WEST;
            }
            case KEY_S -> {
                if (direction != Direction.NORTH) direction = Direction.SOUTH;
            }
            case KEY_D -> {
                if (direction != Direction.WEST) direction = Direction.EAST;
            }
            case KEY_W -> {
                if (direction != Direction.SOUTH)  direction = Direction.NORTH;
            }
        }
    }

    @Override
    public void update() {
        for (int i = snakeParts.size()-1; i >= 1; i--) {
            snakeParts.get(i).x(snakeParts.get(i-1).x());
            snakeParts.get(i).y(snakeParts.get(i-1).y());
        }
        switch (direction) {
            case NORTH -> snakeParts.get(0).y(snakeParts.get(0).y() - speed);
            case EAST -> snakeParts.get(0).x(snakeParts.get(0).x() + speed);
            case WEST -> snakeParts.get(0).x(snakeParts.get(0).x() - speed);
            case SOUTH -> snakeParts.get(0).y(snakeParts.get(0).y() + speed);
        }
        if (snakeParts.get(0).x() < 0) snakeParts.get(0).x(State.SCREEN_WIDTH);
        else if (snakeParts.get(0).x() > State.SCREEN_WIDTH) snakeParts.get(0).x(0);
        else if (snakeParts.get(0).y() > State.SCREEN_HEIGHT) snakeParts.get(0).y(0);
        else if (snakeParts.get(0).y() < 0) snakeParts.get(0).y(State.SCREEN_HEIGHT);
    }

    @Override
    public void draw() {
        for (Vector2 part : snakeParts) {
            DrawRectangle((int) part.x(), (int) part.y(), width, height, color);
        }
    }

    protected Rect getHeadRect() {
        var head = snakeParts.get(0);
        return new Rect(head.x(), head.y(), width, height);
    }

    protected void grow() {
        for (int i = 0; i < 3; i++) addSnakePart();
    }

    protected boolean checkCollision() {
        if (snakeParts.size() < 12) return false;
        var headRect = new Rect(snakeParts.get(0).x(), snakeParts.get(0).y(), width, height);
        var rects = this.snakeParts.stream().skip(9).map(vec -> new Rect(vec.x(), vec.y(), width, height)).toList();
        return rects.stream().anyMatch(tailPart -> EntityManager.checkRectCollision(headRect, tailPart));
    }
}
