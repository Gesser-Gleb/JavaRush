package com.javarush.test.level34.lesson15.big01.model;

/**
 * Created by gesse_000 on 17.03.2016.
 */
public abstract class CollisionObject extends GameObject {
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction) {
        int x = getX();
        int y = getY();

        switch (direction) {
            case LEFT: x -= FIELD_SELL_SIZE;
                break;
            case RIGHT: x += FIELD_SELL_SIZE;
                break;
            case UP: y -= FIELD_SELL_SIZE;
                break;
            case DOWN: y += FIELD_SELL_SIZE;
                break;
        }
        return (x == gameObject.getX()) && (y == gameObject.getY());
    }
}
