package ru.sportequipment.command;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.sportequipment.entity.CommandRequest;

public class ActionFactory {
    private static final Logger logger = LogManager.getLogger(ActionFactory.class);

    public ActionCommand defineCommand(CommandRequest request) {

        ActionCommand command = new EmptyCommand();

        CommandType commandType = CommandType.valueOf(request.getCommand());
        if (commandType == null) {
            return command;
        }
        command = commandType.getCommand();
        logger.debug("ActionFactory command = " + command.getClass().toString());
        return command;
    }
}
