package org.example.highscores;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.NoArgsConstructor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.raylib.Jaylib.DrawText;
import static com.raylib.Jaylib.LIME;
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
        JsonArray array = jsonObject.getAsJsonArray("highscores");
        for (var element: array) {
            highscores.add(element.getAsInt());
        }
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

    public void updateScores(int score) throws IOException {
        for (int i = 0; i < 10; i++) {
            if (highscores.get(i) < score) {
                highscores.set(i, score);
                Gson gson = new Gson();
                JsonObject jsonObject = new JsonObject();
                JsonArray jsonArray = gson.toJsonTree(highscores).getAsJsonArray();
                jsonObject.add("highscores", jsonArray);
                File file = new File("src/main/resources/highscores.json");
                try (Writer writer = new FileWriter(file)) {
                    gson.toJson(jsonObject, writer);
                }
                break;
            }
        }
    }
}
