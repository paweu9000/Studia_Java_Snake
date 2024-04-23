package org.example.state;
import lombok.NoArgsConstructor;
import org.example.entity.Snake;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Raylib.*;

@NoArgsConstructor
public class State {
    public static final int SCREEN_WIDTH = 900;
    public static final int SCREEN_HEIGHT = 600;
    final String TITLE = "SNAKE";
    final int FPS = 60;
    Snake snake;

    public void initializeGame() {
        snake = new Snake();
        InitWindow(SCREEN_WIDTH, SCREEN_HEIGHT, TITLE);
        SetTargetFPS(FPS);
        runLoop();
    }

    private void runLoop() {
        while (!WindowShouldClose()) {
            processInput();
            update();
            draw();
        }
        CloseWindow();
    }

    private void processInput() {
        snake.processInput();
    }

    private void update() {
        snake.update();
    }

    private void draw() {
        BeginDrawing();
        ClearBackground(BLACK);
        snake.draw();
        EndDrawing();
    }
}
