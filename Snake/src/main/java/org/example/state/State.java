package org.example.state;

import com.raylib.Jaylib;
import lombok.NoArgsConstructor;
import org.example.entity.EntityManager;
import org.example.scene.DeathScene;
import org.example.scene.PauseScene;
import org.example.scene.Scene;

import static com.raylib.Jaylib.*;

@NoArgsConstructor
public class State {
    public static final int SCREEN_WIDTH = 1200;
    public static final int SCREEN_HEIGHT = 900;
    public static final int SCREEN_OFFSET = 150;
    private final String TUTORIAL_TEXT = "ESC - QUIT GAME\n\n\nP - PAUSE\n\n\nW S A D - MOVE";
    private final String HIGHSCORE_TEXT = "HIGHSCORES";
    final String TITLE = "SNAKE";
    final int FPS = 60;
    static Scene scene = new PauseScene();

    static EntityManager manager;

    public void initializeGame() {
        manager = new EntityManager();
        InitWindow(SCREEN_WIDTH, SCREEN_HEIGHT, TITLE);
        SetTargetFPS(FPS);
        runLoop();
    }

    private void runLoop() {
        while (!WindowShouldClose()) {
            processInput();
            if (!scene.isSceneActive()) {
                update();
            }
            draw();
        }
        CloseWindow();
    }

    private void processInput() {
        var key = GetKeyPressed();
        scene.processInput(key);
        if (!scene.isSceneActive()) manager.processInput(key);
    }

    private void update() {
        if (manager.checkSnakeCollision()) this.scene = new DeathScene();
        manager.update();
    }

    private void draw() {
        BeginDrawing();
        ClearBackground(BLACK);
        drawMenu();
        manager.draw();
        scene.displayScene();
        EndDrawing();
    }

    public static void resetGame() {
        scene = new PauseScene();
        manager = new EntityManager();
    }

    private void drawMenu() {
        DrawRectangle(148, 148, 904, 604, Jaylib.WHITE);
        DrawRectangle(150, 150, 900, 600, BLACK);
        DrawText(TUTORIAL_TEXT, SCREEN_WIDTH/4 + 160, SCREEN_HEIGHT - SCREEN_OFFSET + 20, 40, GOLD);
        DrawText(HIGHSCORE_TEXT, SCREEN_WIDTH - SCREEN_OFFSET + 10, SCREEN_OFFSET - 20, 20, LIME);
    }
}
