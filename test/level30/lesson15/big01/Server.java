package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by gesse_000 on 09.01.2016.
 */
public class Server {

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry :connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("It's impossible to send a message to " + entry.getKey());
            }
        }

    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Connection with " + socket.getRemoteSocketAddress());
            String newUserName = "";
            try (Connection connection = new Connection(socket)){
                newUserName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newUserName));
                sendListOfUsers(connection, newUserName);
                serverMainLoop(connection, newUserName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error!");
            }
            if (!newUserName.equals(""))
            connectionMap.remove(newUserName);
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newUserName));
            ConsoleHelper.writeMessage("Connection closed");

        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType().equals(MessageType.USER_NAME)) {
                    String data = message.getData();
                    if (!data.isEmpty() && !connectionMap.containsKey(data)) {
                        String userName = data;
                        connectionMap.put(userName, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return userName;
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
                if (!entry.getKey().equals(userName))
                connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType().equals(MessageType.TEXT)) {
                    Message formatMessage = new Message(MessageType.TEXT, String.format("%s: ", userName) + message.getData());
                    sendBroadcastMessage(formatMessage);
                } else
                    ConsoleHelper.writeMessage("This data is not TEXT");
            }
        }
    }

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Enter server port, please");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("Server is running");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
