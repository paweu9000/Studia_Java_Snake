package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import static com.raylib.Raylib.*;

@Getter
@Setter
public abstract class Entity {
    protected Vector2 position;
    protected int width;
    protected int height;
    protected Color color;

    public abstract void update();
    public abstract void draw();
}
