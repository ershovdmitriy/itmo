package lab6.server;

import lab6.common.collection.HumanBeing.HumanBeing;
import lab6.server.collection.HumanBeingManagers;
import lab6.server.collection.IdManager;
import lab6.server.collection.JsonManager;
import lab6.server.commands.CommandMapForHumanBeing;
import lab6.server.commands.ServerCommand;
import lab6.server.logging.ServerLogger;
import lab6.server.network.UdpServer;

import java.util.LinkedHashMap;

public class Main {
    private static final int PORT = 12345;
    private static final int BUFFER_SIZE = 65536;

    public static void main(String[] args) {
        try {
            JsonManager<LinkedHashMap<String, HumanBeing>> jsonManager = new JsonManager<>();
            HumanBeingManagers humanBeingManagers = new HumanBeingManagers(jsonManager, "FILE_NAME");
            IdManager<HumanBeing> idManager = new IdManager<>(humanBeingManagers);
            CommandMapForHumanBeing commandMapForHumanBeing = new CommandMapForHumanBeing(humanBeingManagers, idManager);
            UdpServer<LinkedHashMap<String, ServerCommand>> udpServer = new UdpServer<>(PORT, BUFFER_SIZE, commandMapForHumanBeing);

            udpServer.start();
        } catch (Exception e) {
            ServerLogger.error("Критическая ошибка при запуске сервера: " + e.getMessage());
        }
    }
}
