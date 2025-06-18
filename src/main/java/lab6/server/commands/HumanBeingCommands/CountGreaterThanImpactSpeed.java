package lab6.server.commands.HumanBeingCommands;

import lab6.common.collection.HumanBeing.HumanBeing;
import lab6.common.service.CommandRequest;
import lab6.common.service.CommandResponse;
import lab6.server.collection.CollectionManager;
import lab6.server.commands.ServerCommand;

import java.util.Map;

public class CountGreaterThanImpactSpeed implements ServerCommand {

    private final CollectionManager<? extends Map<String, HumanBeing>, HumanBeing> manager;

    public CountGreaterThanImpactSpeed(CollectionManager<? extends Map<String, HumanBeing>, HumanBeing> manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "count_greater_than_impact_speed";
    }

    @Override
    public String getDescr() {
        return "[Long impact_speed] Выводит количество элементов, значение поля impactSpeed которых больше заданного";
    }

    @Override
    public CommandResponse execute(CommandRequest<?, ?> commandRequest) {
        Long impactSpeed = (Long) commandRequest.getArgument();
        int countObject = 0;
        for (String key: manager.getCollection().keySet()) {
            if (manager.getCollection().get(key).getImpactSpeed() > impactSpeed) {
                countObject += 1;
            }
        }
        return new CommandResponse(true, getName(), "Количество элементов: ", countObject);
    }
}
