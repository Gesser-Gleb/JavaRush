package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by gesse_000 on 13.09.2015.
 */
class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currentCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currentCode);
        boolean isOver = true;
        while (isOver) {
            try {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                int amount = Integer.parseInt(ConsoleHelper.readString());
                if (amount < 0) throw new IOException();
                if (!manipulator.hasMoney()) throw new NotEnoughMoneyException();
                isOver = false;
                if (!manipulator.isAmountAvailable(amount)) throw new NumberFormatException();
                manipulator.withdrawAmount(amount);
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currentCode));
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                isOver = true;
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                isOver = true;
            } catch (IOException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            }
        }
    }
}
