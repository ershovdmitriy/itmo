package lab6.server.commands.HumanBeingCommands;

import lab6.common.service.CommandRequest;
import lab6.common.service.CommandResponse;
import lab6.server.collection.CollectionManager;
import lab6.server.commands.ServerCommand;

import java.util.Map;

public class RemoveLowerKey implements ServerCommand {

    private final CollectionManager<? extends Map<String, ?>, ?> manager;

    public RemoveLowerKey(CollectionManager<? extends Map<String, ?>, ?> manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "remove_lower_key";
    }

    @Override
    public String getDescr() {
        return "[String key] Удаляет из коллекции все элементы, ключ которых меньше, чем заданный";
    }

    @Override
    public CommandResponse<?> execute(CommandRequest<?, ?> commandRequest) {
        String key = (String) commandRequest.getArgument();
        for (String k: manager.getCollection().keySet()) {
            if (k.compareTo(key) < 0) {
                manager.removeElementToCollection(key);
            }
        }
        return new CommandResponse<>(getName(), "Все элементы с ключом меньше чем " + key + " удалены.");
    }
}
