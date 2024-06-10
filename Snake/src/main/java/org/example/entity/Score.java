package org.example.entity;


import com.raylib.Raylib;
import lombok.Getter;

import static com.raylib.Jaylib.GRAY;
import static com.raylib.Jaylib.GREEN;

@Getter
public class Score extends Entity{
    Integer score = 0;

    public void addScore() {
        this.score += 1;
    };

    @Override
    public void update() {
        addScore();
    }

    @Override
    public void draw() {

        if(score>10){
            Raylib.DrawText("Score: "+score,0,0,35, GREEN);
        }else{
            Raylib.DrawText("Score: "+score,0,0,30, GRAY);
        }
    }
}
