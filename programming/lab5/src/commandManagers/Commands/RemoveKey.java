package commandManagers.Commands;

import collectionManagers.CollectionManager;
import commandManagers.Command;

import java.util.Map;

public class RemoveKey extends Command {

    private final CollectionManager<? extends Map<String, ?>, ?> manager;

    public RemoveKey(CollectionManager<? extends Map<String, ?>, ?> manager) {
        super(false);
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "remove_key [key]";
    }

    @Override
    public String getDescr() {
        return "Удаляет элемент из коллекции по его ключу";
    }

    @Override
    public boolean checkArgument(Object inputArgument) {
        if (inputArgument == null) {
            System.out.println("remove_key имеет аргумент типа String");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void execute() {
        if (checkArgument(getArgument())){
            if(manager.checkObjectByKey(getArgument())){
                manager.removeElementToCollection(getArgument());
                System.out.println("Элемент с данным ключом удален.");
            }
            else{
                System.out.println("Элемент с данным ключом отсутствует.");
            }
        }
    }
}
