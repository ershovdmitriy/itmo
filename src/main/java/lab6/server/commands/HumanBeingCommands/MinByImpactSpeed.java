package lab6.server.commands.HumanBeingCommands;

import lab6.common.collection.HumanBeing.HumanBeing;
import lab6.common.collection.HumanBeing.comparators.HumanBeingComparatorByImpactSpeed;
import lab6.common.service.CommandRequest;
import lab6.common.service.CommandResponse;
import lab6.server.collection.CollectionManager;
import lab6.server.commands.ServerCommand;

import java.util.Map;

public class MinByImpactSpeed implements ServerCommand {

    CollectionManager<? extends Map<String, HumanBeing>, HumanBeing> manager;
    HumanBeingComparatorByImpactSpeed comparator;

    public MinByImpactSpeed(CollectionManager<? extends Map<String, HumanBeing>, HumanBeing> manager, HumanBeingComparatorByImpactSpeed comparator) {
        this.manager = manager;
        this.comparator = comparator;
    }

    @Override
    public String getName() {
        return "min_by_impact_speed";
    }

    @Override
    public String getDescr() {
        return "Выводит любой объект из коллекции, значение поля impactSpeed которого является минимальным";
    }

    @Override
    public CommandResponse execute(CommandRequest<?, ?> commandRequest) {
        HumanBeing minImpactSpeed = new HumanBeing();
        minImpactSpeed.setImpactSpeed(Long.MAX_VALUE);
        for (String key: manager.getCollection().keySet()) {
            if (comparator.compare(minImpactSpeed, manager.getCollection().get(key)) < 0) {
                minImpactSpeed = manager.getCollection().get(key);
            }
        }
        return new CommandResponse(true, getName(), "Элемент с минимальным Impact Speed:", minImpactSpeed);
    }
}
