package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by gesse_000 on 24.10.2015.
 */
public interface EventDataRow {
    EventType getType();
    Date getDate();
    int getTime();
}
