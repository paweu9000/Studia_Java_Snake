package org.example.state;
import lombok.NoArgsConstructor;
import org.example.entity.Apple;
import org.example.entity.Snake;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Raylib.*;

@NoArgsConstructor
public class State {
    public static final int SCREEN_WIDTH = 900;
    public static final int SCREEN_HEIGHT = 600;
    final String TITLE = "SNAKE";
    final int FPS = 60;

    private int randValue1 = GetRandomValue(0,900);
    public int getrandValue1() {
        return randValue1;
    }
    public int randValue2 = GetRandomValue(0,600);
    public int getrandValue2() {
        return randValue2;
    }

    int framesCounter = 0;

    Snake snake;
    Apple apple;

    public void initializeGame() {
        snake = new Snake();
        apple = new Apple();
        InitWindow(SCREEN_WIDTH, SCREEN_HEIGHT, TITLE);
        SetTargetFPS(FPS);
        runLoop();
    }

    private void runLoop() {
        while (!WindowShouldClose()) {
            processInput();
            update();
            draw();
            framesCounter++;

            if (((framesCounter/120)%2) == 1)
            {
                randValue1 = GetRandomValue(0,884);
                randValue2 = GetRandomValue(0,584);
                framesCounter = 0;
            }
        }
        CloseWindow();
    }

    private void processInput() {
        snake.processInput();
    }

    private void update() {
        snake.update();
        apple.update();
    }

    private void draw() {
        BeginDrawing();
        ClearBackground(BLACK);
        snake.draw();
        apple.draw();
        EndDrawing();
    }
}
