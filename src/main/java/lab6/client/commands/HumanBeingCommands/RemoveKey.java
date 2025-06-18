package lab6.client.commands.HumanBeingCommands;

import lab6.client.commands.ClientCommand;
import lab6.common.exception.CommandException;
import lab6.common.service.CommandRequest;

public class RemoveKey extends ClientCommand {

    @Override
    public String getName() {
        return "remove_key [key]";
    }

    @Override
    public boolean checkArgument() {
        if (getArgument() == null) {
            System.out.println("remove_key имеет аргумент типа String");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public CommandRequest<String, ?> buildRequest() throws CommandException {
        return new CommandRequest<>(getName(), getArgument());
    }
}
