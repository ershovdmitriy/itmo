package commandManagers.Commands;

import collectionManagers.CollectionManager;
import commandManagers.Command;

import java.util.Map;

public class RemoveGreaterKey extends Command {

    private final CollectionManager<? extends Map<String, ?>, ?> manager;

    public RemoveGreaterKey(CollectionManager<? extends Map<String, ?>, ?> manager) {
        super(false);
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "remove_greater_key [key]";
    }

    @Override
    public String getDescr() {
        return "Удаляет из коллекции все элементы, ключ которых превышает заданный";
    }

    @Override
    public boolean checkArgument(Object inputArgument) {
        if (inputArgument == null) {
            System.out.println("remove_greater_key имеет аргумент типа String");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void execute() {
        if (checkArgument(getArgument())){
            for (String key: manager.getCollection().keySet()) {
                if (key.compareTo(getArgument()) > 0) {
                    manager.removeElementToCollection(key);
                }
            }
            System.out.println("Все элементы ключом больше чем " + getArgument() + " удалены.");
        }
    }
}
