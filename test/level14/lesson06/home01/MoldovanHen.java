package com.javarush.test.level14.lesson06.home01;

/**
 * Created by gesse_000 on 01.07.2015.
 */
public class MoldovanHen extends Hen {
    @Override
    public int getCountOfEggsPerMonth() {
        return 10;
    }
    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth()
                + " яиц в месяц.";
    }
}
