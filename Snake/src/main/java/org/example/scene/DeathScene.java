package org.example.scene;

import com.raylib.Jaylib;
import org.example.state.State;

import java.util.HashMap;

import static com.raylib.Raylib.KEY_R;

public class DeathScene extends AbstractScene {

    public DeathScene() {
        int height = State.SCREEN_HEIGHT, width = State.SCREEN_WIDTH;
        var pauseVector = new Jaylib.Vector2((float) width /3 + 100, (float) height /2 - 100);
        var resumeVector = new Jaylib.Vector2((float) width /3, (float) height /2);
        textMap = new HashMap<>();
        isActive = true;
        textMap.put(pauseVector, "YOU DIED");
        textMap.put(resumeVector, "Press R to restart");
    }

    @Override
    public void processInput(int key) {
        if (key == KEY_R) {
            State.resetGame();
        }
    }

    @Override
    public boolean isSceneActive() {
        return isActive;
    }
}
