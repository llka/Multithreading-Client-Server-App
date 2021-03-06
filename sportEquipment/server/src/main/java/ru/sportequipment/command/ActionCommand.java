package ru.sportequipment.command;

import ru.sportequipment.entity.CommandRequest;
import ru.sportequipment.entity.CommandResponse;
import ru.sportequipment.entity.Session;
import ru.sportequipment.exception.ApplicationException;

public interface ActionCommand {
    CommandResponse execute(CommandRequest request, CommandResponse response, Session session) throws ApplicationException;
}