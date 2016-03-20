package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by gesse_000 on 24.10.2015.
 */
public class VideoSelectedEventDataRow implements EventDataRow {
    List<Advertisement> optimalVideoSet;
    long amount;
    int totalDuration;
    Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }
}
