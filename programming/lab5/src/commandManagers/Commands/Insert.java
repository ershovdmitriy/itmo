package commandManagers.Commands;

import collectionManagers.CollectionManager;
import collectionManagers.buildersManagers.ObjectBuilder;
import commandManagers.Command;

import java.util.Map;

public class Insert<T> extends Command {

    private final CollectionManager<? extends Map<String, T>, T> manager;
    private final ObjectBuilder<T> builder;

    public Insert(CollectionManager<? extends Map<String, T>, T> manager, ObjectBuilder<T> builder) {
        super(false);
        this.manager = manager;
        this.builder = builder;

    }

    @Override
    public String getName() {
        return "insert [key]";
    }

    @Override
    public String getDescr() {
        return "Добавляет новый элемент с заданным ключом";
    }

    @Override
    public boolean checkArgument(Object inputArgument) {
        if (inputArgument == null) {
            System.out.println("insert имеет аргумент типа String");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void execute() {
        if (checkArgument(getArgument())){
            manager.addElementToCollection(getArgument(), builder.build());
            System.out.println("Элемент добавлен в коллекцию.");
        }
    }
}
