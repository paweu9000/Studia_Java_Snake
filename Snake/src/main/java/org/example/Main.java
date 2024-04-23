package org.example;

import static com.raylib.Jaylib.BLACK;
import static com.raylib.Raylib.*;

public class Main {
    public static void main(String[] args) {
        InitWindow(800, 450, "Snake");
        SetTargetFPS(60);

        while(!WindowShouldClose()) {
            BeginDrawing();
            ClearBackground(BLACK);
            DrawFPS(20, 20);
            EndDrawing();
        }
        CloseWindow();
    }
}