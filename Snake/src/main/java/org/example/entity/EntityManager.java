package org.example.entity;

import java.util.List;
import java.util.function.BiFunction;

public class EntityManager implements Manager {
    Snake snake;
    Apple apple;

    public EntityManager() {
        snake = new Snake();
        apple = new Apple();
    }


    @Override
    public void update() {
        if (checkCollision()) {
            apple.setEaten(true);
            snake.grow();
            apple.rollNewPosition();
        }
        apple.update();
        snake.update();
    }

    @Override
    public void processInput() {
        snake.processInput();
    }

    @Override
    public void draw() {
        apple.draw();
        snake.draw();
    }

    @Override
    public boolean checkCollision() {
        var appleRect = apple.getAppleRect();
        var snakeRect = snake.getHeadRect();

        return checkRectCollision(snakeRect, appleRect);
    }

    protected void rollNewApplePos() {
        var snakeTotalPos = snake.getTotalPosition();
        apple.rollNewPosition();
        var applePos = apple.getAppleRect();

        BiFunction<List<Rect>, Rect, Boolean> inBounds = (List<Rect> snake, Rect apple) -> {
            for (var rect: snake) {
                if (checkRectCollision(rect, apple)) return true;
            }
            return false;
        };
        while (inBounds.apply(snakeTotalPos, applePos)) {
            apple.rollNewPosition();
        }
    }

    private boolean checkRectCollision(Rect r1, Rect r2) {
        return (r1.x() + r1.width() > r2.x() &&
                r1.x() <= r2.x() + r2.width() &&
                r1.y() + r1.height() >= r2.y() &&
                r1.y() <= r2.y() + r2.height());
    }
}
