package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gesse_000 on 18.03.2016.
 */
public class LevelLoader {
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {
        int fss = GameObject.FIELD_SELL_SIZE;
        Set<Wall> walls = new HashSet<>();
        walls.add(new Wall(fss/2 + fss,fss/2 + fss));
        walls.add(new Wall(fss/2 + fss*5,fss/2 + fss*5));
        walls.add(new Wall(fss/2 + fss*7,fss/2 + fss*7));
        Set<Home> homes = new HashSet<>();
        homes.add(new Home(fss/2 + fss*2,fss/2 + fss*2));
        Set<Box> boxes = new HashSet<>();
        boxes.add(new Box(fss/2 + fss*3, fss/2 + fss*3));
        return new GameObjects(walls, boxes,homes, new Player(fss/2 + fss*4,fss/2 + fss*4));

    }
}
