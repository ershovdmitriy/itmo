package lab6.server.commands.HumanBeingCommands;

import lab6.common.service.CommandRequest;
import lab6.common.service.CommandResponse;
import lab6.server.collection.CollectionManager;
import lab6.server.commands.ServerCommand;

import java.util.HashMap;
import java.util.Map;

public class Show<T> implements ServerCommand {

    private final CollectionManager<? extends Map<?, T>, T> manager;

    public Show(CollectionManager<? extends Map<?, T>, T> manager) {
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
    public CommandResponse<HashMap<String, T>> execute(CommandRequest<?, ?> commandRequest) {
        if(manager.getCollection().isEmpty()){
            return new CommandResponse<>(getName(), "Коллекция пуста.");
        }
        HashMap<String, T> map = new HashMap<>();
        manager.sortCollection();
        for (var key: manager.getCollection().keySet()){
            map.put(key, manager.getCollection().get(key));
        }
        return new CommandResponse<>(getName(), "Все элементы коллекции:", map);
    }
}
