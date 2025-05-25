import collection.HumanBeing.HumanBeing;
import collectionManagers.HumanBeingManagers;
import collectionManagers.IdManager;
import collectionManagers.JsonManager;
import collectionManagers.buildersManagers.humanBeingBuilder.HumanBeingBuilder;
import commandManagers.Command;
import commandManagers.CommandExecutor;
import commandManagers.CommandMapForHumanBeing;

import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args){
        JsonManager<LinkedHashMap<String, HumanBeing>> jsonManager = new JsonManager<>();
        HumanBeingManagers humanBeingManagers = new HumanBeingManagers(jsonManager, "FILE_NAME");
        IdManager<HumanBeing> idManager = new IdManager<>(humanBeingManagers);
        HumanBeingBuilder humanBeingBuilder = new HumanBeingBuilder(idManager);
        CommandExecutor<LinkedHashMap<String, Command>,HumanBeing> commandExecutor = new CommandExecutor<>(humanBeingBuilder);
        CommandMapForHumanBeing commandMap = new CommandMapForHumanBeing(humanBeingManagers, humanBeingBuilder, idManager, commandExecutor);
        commandExecutor.setCommandMap(commandMap.getCommandMap());

        System.out.println("Программа успешно запущена.");
        System.out.println("Коллекция успешно загружена из файла.");
        System.out.println("Для списка доступных команд можно вызвать команду help.");
        commandExecutor.startExecuting(System.in);
    }
}