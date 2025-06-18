package lab6.client;

import lab6.client.builders.humanBeingBuilder.HumanBeingBuilder;
import lab6.client.commands.ClientCommand;
import lab6.client.commands.CommandMap;
import lab6.client.commands.CommandMapForHumanBeing;
import lab6.client.commands.CommandReader;
import lab6.client.network.UdpClient;
import lab6.common.collection.HumanBeing.HumanBeing;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main{
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;
    private static final int TIMEOUT_MS = 5000;
    private static final int MAX_RETRIES = 3;

    public static void main(String[] args) {
        UdpClient udpManager = new UdpClient();
        try {
            udpManager.connect(SERVER_HOST, SERVER_PORT, TIMEOUT_MS);
        } catch (IOException e) {
            System.err.println("Не удалось подключиться к серверу.");
        }

        HumanBeingBuilder builder = new HumanBeingBuilder();
        CommandReader<LinkedHashMap<String, ClientCommand>, HumanBeing> commandReader = new CommandReader<>(builder, udpManager, MAX_RETRIES);
        CommandMap<LinkedHashMap<String, ClientCommand>> commandMap = new CommandMapForHumanBeing(builder);
        commandReader.setCommandMap(commandMap.getCommandMap());
        commandReader.startExecuting(new Scanner(System.in));
    }
}