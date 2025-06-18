package lab6.server.commands.HumanBeingCommands;

import lab6.common.service.CommandRequest;
import lab6.common.service.CommandResponse;
import lab6.server.collection.CollectionManager;
import lab6.server.commands.ServerCommand;

import java.util.HashMap;
import java.util.Map;

public class Show implements ServerCommand {

    private final CollectionManager<? extends Map<?, ?>, ?> manager;

    public Show(CollectionManager<? extends Map<?, ?>, ?> manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescr() {
        return "Выводит в стандартный поток вывода все элементы коллекции в строковом представлении";
    }

    @Override
    public CommandResponse execute(CommandRequest<?, ?> commandRequest) {
        if(manager.getCollection().isEmpty()){
            return new CommandResponse(false, getName(), "Коллекция пуста.");
        }
        HashMap<String, String> map = new HashMap<>();
        manager.sortCollection();
        for (var key: manager.getCollection().keySet()){
            map.put(key, manager.getCollection().get(key).toString());
        }
        return new CommandResponse(true, getName(), "Все элементы коллекции:", map);
    }
}
