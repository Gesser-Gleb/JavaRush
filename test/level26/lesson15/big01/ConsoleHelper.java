package com.javarush.test.level26.lesson15.big01;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.*;
import java.util.ResourceBundle;

/**
 * Created by gesse_000 on 11.09.2015.
 */
public class ConsoleHelper {

    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException{
        String message = "";
        try {
            message = reader.readLine();
            if (message.equalsIgnoreCase("EXIT")) {
                throw new InterruptOperationException();
            }
        }catch (IOException e){

        }
        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        boolean isOver = true;
        String code ="";
        writeMessage(res.getString("choose.currency.code"));

            while (isOver) {
                code = readString();
                if (code.length() == 3) {
                    code = code.toUpperCase();
                    isOver = false;
                } else {
                    writeMessage(res.getString("invalid.data"));
                }
            }

        return code;
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException{
        String[] array = new String[2];
        boolean isOver = true;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        while (isOver) {
            try{
                String line = readString();
                array = line.split(" ");
                int a = Integer.parseInt(array[0]);
                int b = Integer.parseInt(array[1]);
                if (a <= 0 || b <= 0 || array.length > 2) throw new IOException();
                isOver = false;
            } catch (IOException e) {
                writeMessage(res.getString("invalid.data"));
                array = new String[2];
            }
        }
        return array;
    }

    public static Operation askOperation() throws InterruptOperationException{


        writeMessage(res.getString("choose.operation"));
        Operation result;
        try {
            result = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
        } catch (NumberFormatException e) {
            writeMessage(res.getString("invalid.data"));
            result = askOperation();
        }
        return result;
    }
}
