package commandManagers;

import collection.HumanBeing.HumanBeing;
import collection.HumanBeing.comparators.HumanBeingComparator;
import collection.HumanBeing.comparators.HumanBeingComparatorByImpactSpeed;
import collectionManagers.HumanBeingManagers;
import collectionManagers.IdManager;
import collectionManagers.buildersManagers.humanBeingBuilder.HumanBeingBuilder;
import commandManagers.Commands.*;

import java.util.LinkedHashMap;

public class CommandMapForHumanBeing implements CommandMap<LinkedHashMap<String, Command>>{

    private final LinkedHashMap<String, Command> commandMap;

    public CommandMapForHumanBeing(HumanBeingManagers humanBeingManagers, HumanBeingBuilder humanBeingBuilder, IdManager<HumanBeing> idManager, CommandExecutor<LinkedHashMap<String, Command>, HumanBeing> commandExecutor){
        this.commandMap = new LinkedHashMap<>();
        commandMap.put("info", new Info(humanBeingManagers));
        commandMap.put("help", new Help(commandMap));
        commandMap.put("show", new Show(humanBeingManagers));
        commandMap.put("insert", new Insert<>(humanBeingManagers, humanBeingBuilder));
        commandMap.put("update", new Update<>(humanBeingManagers, humanBeingBuilder, idManager));
        commandMap.put("remove_key", new RemoveKey(humanBeingManagers));
        commandMap.put("clear", new Clear(humanBeingManagers));
        commandMap.put("save", new Save(humanBeingManagers));
        commandMap.put("execute_script", new ExecuteScript<>(commandExecutor));
        commandMap.put("exit", new Exit());
        commandMap.put("replace_if_lowe", new ReplaceIfLowe<>(humanBeingManagers, humanBeingBuilder, new HumanBeingComparator()));
        commandMap.put("remove_greater_key", new RemoveGreaterKey(humanBeingManagers));
        commandMap.put("remove_lower_key", new RemoveLowerKey(humanBeingManagers));
        commandMap.put("remove_all_by_impact_speed", new RemoveAllByImpactSpeed(humanBeingManagers));
        commandMap.put("min_by_impact_speed", new MinByImpactSpeed(humanBeingManagers, new HumanBeingComparatorByImpactSpeed()));
        commandMap.put("count_greater_than_impact_speed", new CountGreaterThanImpactSpeed(humanBeingManagers));
    }

    public LinkedHashMap<String, Command> getCommandMap() {
        return commandMap;
    }
}
