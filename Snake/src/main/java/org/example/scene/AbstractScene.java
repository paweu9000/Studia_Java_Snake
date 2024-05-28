package org.example.scene;

import com.raylib.Jaylib;
import com.raylib.Raylib;

import java.util.Map;

public class AbstractScene implements Scene {
    public Map<Jaylib.Vector2, String> textMap;
    public boolean isActive;

    @Override
    public void displayScene() {
        if (!isActive) return;
        for (Map.Entry<Jaylib.Vector2, String> entry : textMap.entrySet())
        {
            var key = entry.getKey();
            Raylib.DrawText(entry.getValue(), (int) key.x(), (int) key.y(), 35, Jaylib.PURPLE);
        }
    }

    @Override
    public void processInput(int key) {

    }

    @Override
    public boolean isSceneActive() {
        return false;
    }
}
