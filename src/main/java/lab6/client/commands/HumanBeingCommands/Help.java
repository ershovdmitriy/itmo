package lab6.client.commands.HumanBeingCommands;

import lab6.client.commands.ClientCommand;
import lab6.common.exception.CommandException;
import lab6.common.service.CommandRequest;

public class Help extends ClientCommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public boolean checkArgument() {
        if (getArgument() == null) {
            return true;
        } else {
            System.out.println("help не имеет аргументов!");
            return false;
        }
    }

    @Override
    public CommandRequest<?, ?> buildRequest() throws CommandException {
        return new CommandRequest<>(getName());
    }
}
