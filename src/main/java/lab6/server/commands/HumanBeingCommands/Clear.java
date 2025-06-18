package lab6.server.commands.HumanBeingCommands;

import lab6.common.service.CommandRequest;
import lab6.common.service.CommandResponse;
import lab6.server.collection.CollectionManager;
import lab6.server.commands.ServerCommand;

import java.util.Map;

public class Clear implements ServerCommand {
    private final CollectionManager<? extends Map<String, ?>, ?> manager;

    public Clear(CollectionManager<? extends Map<String, ?>, ?> manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescr() {
        return "Очищает коллекцию";
    }

    @Override
    public CommandResponse execute(CommandRequest<?, ?> commandRequest) {
        manager.clearCollection();
        return new CommandResponse(true, getName(), "Коллекция очищена.");
    }
}
