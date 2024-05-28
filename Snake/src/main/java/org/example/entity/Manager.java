package org.example.entity;

interface Manager {
    void update();
    void processInput(int key);
    void draw();
    boolean checkCollision();
}
