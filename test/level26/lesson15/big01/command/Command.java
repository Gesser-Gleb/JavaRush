package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by gesse_000 on 13.09.2015.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
