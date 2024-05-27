package org.example.entity;

import java.util.List;
import java.util.function.BiFunction;

public class EntityManager implements Manager {
    Snake snake;
    Apple apple;
    Score score;

    public EntityManager() {
        snake = new Snake();
        apple = new Apple();
        score = new Score();
    }


    @Override
    public void update() {
        if (checkCollision()) {
            apple.setEaten(true);
            snake.grow();
            score.update();
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
        score.draw();
    }

    @Override
    public boolean checkCollision() {
        var appleRect = apple.getAppleRect();
        var snakeRect = snake.getHeadRect();

        return checkRectCollision(snakeRect, appleRect);
    }

    private boolean checkRectCollision(Rect r1, Rect r2) {
        return (r1.x() + r1.width() > r2.x() &&
                r1.x() <= r2.x() + r2.width() &&
                r1.y() + r1.height() >= r2.y() &&
                r1.y() <= r2.y() + r2.height());
    }
}
