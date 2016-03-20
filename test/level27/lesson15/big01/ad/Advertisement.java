package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by gesse_000 on 03.10.2015.
 */
public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;


    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount/hits;
    }

    public int getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits > 0) {
            hits--;
            if (hits == 1){amountPerOneDisplaying = amountPerOneDisplaying + initialAmount % hits;}
        } else
            throw new UnsupportedOperationException();
    }
}
