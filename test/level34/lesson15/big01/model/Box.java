package com.javarush.test.level34.lesson15.big01.model;

import java.awt.*;

/**
 * Created by gesse_000 on 18.03.2016.
 */
public class Box extends CollisionObject implements Movable {
    public Box(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.orange);
        graphics.fill3DRect(getX(), getY(), getWidth(), getHeight(), true);
    }

    @Override
    public void move(int x, int y) {
        this.setX(this.getX() + x);
        this.setY(this.getY() + y);
    }
}
