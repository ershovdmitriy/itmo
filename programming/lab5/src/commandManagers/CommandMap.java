package commandManagers;

import java.util.Map;

public interface CommandMap<C extends Map<String, Command>> {
    C getCommandMap();
}
