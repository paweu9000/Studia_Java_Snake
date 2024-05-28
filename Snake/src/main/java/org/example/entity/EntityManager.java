package org.example.entity;

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
    public void processInput(int key) {
        snake.processInput(key);
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

    public boolean checkSnakeCollision() {
        return snake.checkCollision();
    }

    public static boolean checkRectCollision(Rect r1, Rect r2) {
        return (r1.x() + r1.width() > r2.x() &&
                r1.x() <= r2.x() + r2.width() &&
                r1.y() + r1.height() >= r2.y() &&
                r1.y() <= r2.y() + r2.height());
    }
}
