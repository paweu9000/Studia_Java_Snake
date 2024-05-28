package org.example.scene;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import lombok.Getter;
import org.example.state.State;

import java.util.HashMap;
import java.util.Map;

import static com.raylib.Raylib.*;

@Getter
public class PauseScene implements Scene {
    Map<Jaylib.Vector2, String> textMap;
    boolean isActive;

    public PauseScene() {
        int height = State.SCREEN_HEIGHT, width = State.SCREEN_WIDTH;
        var pauseVector = new Jaylib.Vector2((float) width /3, (float) height /3 - 100);
        var resumeVector = new Jaylib.Vector2((float) width /3 - 100, (float) height /3);
        textMap = new HashMap<>();
        isActive = false;
        textMap.put(pauseVector, "PAUSE");
        textMap.put(resumeVector, "Press P to resume");
    }

    @Override
    public void displayScene() {
        if (!isActive) return;
        for (Map.Entry<Jaylib.Vector2, String> entry : textMap.entrySet())
        {
            var key = entry.getKey();
            Raylib.DrawText(entry.getValue(), (int) key.x(), (int) key.y(), 35, Jaylib.WHITE);
        }
    }

    @Override
    public void processInput(int key) {
        if (key == KEY_P) {
            this.isActive = !this.isActive;
        }
    }

    @Override
    public boolean isSceneActive() {
        return this.isActive;
    }
}
