package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by gesse_000 on 13.09.2015.
 */
class InfoCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() throws InterruptOperationException {
        boolean isMoney = false;
        ConsoleHelper.writeMessage(res.getString("before"));
        for (CurrencyManipulator cM :CurrencyManipulatorFactory.getAllCurrencyManipulators()) {

            if (cM.hasMoney()) {
                if (cM.getTotalAmount() > 0) {
                    ConsoleHelper.writeMessage(cM.getCurrencyCode() + " - " + cM.getTotalAmount());
                    isMoney = true;
                }
            }
        }
        if (!isMoney) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
