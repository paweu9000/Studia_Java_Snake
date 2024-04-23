package org.example.state;
import lombok.NoArgsConstructor;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Raylib.*;

@NoArgsConstructor
public class State {
    final int SCREEN_WIDTH = 900;
    final int SCREEN_HEIGHT = 600;
    final String TITLE = "SNAKE";
    final int FPS = 60;

    public void initializeGame() {
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

    }

    private void update() {

    }

    private void draw() {
        BeginDrawing();
        ClearBackground(BLACK);
        EndDrawing();
    }
}
