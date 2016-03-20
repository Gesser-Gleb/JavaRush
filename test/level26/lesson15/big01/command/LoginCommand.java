package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by gesse_000 on 17.09.2015.
 */
public class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    @Override
    public void execute() throws InterruptOperationException {
        res.getString("before");
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String userCN = ConsoleHelper.readString();
            String userPin = ConsoleHelper.readString();

            if (!(userCN.length() == 12 && userPin.length() == 4)) {

                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));

            }
            else if (validCreditCards.containsKey(userCN) && validCreditCards.getString(userCN).equals(userPin)) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), userCN));
                break;
            } else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), userCN));
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            }

        }
    }
}
