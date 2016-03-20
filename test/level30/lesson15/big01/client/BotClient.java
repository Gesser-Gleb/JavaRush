package com.javarush.test.level30.lesson15.big01.client;


/**
 * Created by gesse_000 on 11.01.2016.
 */
public class BotClient extends Client {

    private static int botNumber = 0;

    protected BotSocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String botName = "date_bot_" + botNumber;
        botNumber++;
        if (botNumber > 99) botNumber = 0;
        return botName;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {

    }
}
