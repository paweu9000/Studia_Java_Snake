package org.example.highscores;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.raylib.Jaylib.*;
import static org.example.state.State.SCREEN_OFFSET;
import static org.example.state.State.SCREEN_WIDTH;

@NoArgsConstructor
public class HighscoreManager {

    List<Integer> highscores = new ArrayList<>();

    public void initialize() {
        ClassLoader classLoader = HighscoreManager.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("highscores.json");
        assert inputStream != null;
        Reader reader = new InputStreamReader(inputStream);
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
        highscores = gson.fromJson(jsonObject.getAsJsonArray("scores"), List.class);
    }

    public void drawScores() {
        for (int i = 0; i < 10; i++) {
            int place = i+1;
            String score = String.valueOf(highscores.get(i));
            score = score.replace(".0", "");
            DrawText(place+". " + score, SCREEN_WIDTH - SCREEN_OFFSET + 10,
                    SCREEN_OFFSET + 40 + (i*20), 20, LIME);
        }
    }
}
