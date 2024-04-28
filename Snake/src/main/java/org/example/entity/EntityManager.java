package org.example.entity;

import com.raylib.Raylib;

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

        return (snakeRect.x() + snakeRect.width() > appleRect.x() &&
                snakeRect.x() <= appleRect.x() + appleRect.width() &&
                snakeRect.y() + snakeRect.height() >= appleRect.y() &&
                snakeRect.y() <= appleRect.y() + appleRect.height());
    }
}
