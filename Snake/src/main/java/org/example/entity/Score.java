package org.example.entity;


import com.raylib.Raylib;

import static com.raylib.Jaylib.GRAY;
import static com.raylib.Jaylib.GREEN;
import static com.raylib.Raylib.*;

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
//        Raylib.DrawText("Time: "+ GetTime(),0,40,0, GRAY);


    }
}
