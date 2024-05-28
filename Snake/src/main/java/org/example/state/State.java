package org.example.state;
import lombok.NoArgsConstructor;
import org.example.entity.EntityManager;
import org.example.scene.DeathScene;
import org.example.scene.PauseScene;
import org.example.scene.Scene;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Raylib.*;

@NoArgsConstructor
public class State {
    public static final int SCREEN_WIDTH = 900;
    public static final int SCREEN_HEIGHT = 600;
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
        manager.draw();
        scene.displayScene();
        EndDrawing();
    }

    public static void resetGame() {
        scene = new PauseScene();
        manager = new EntityManager();
    }
}
