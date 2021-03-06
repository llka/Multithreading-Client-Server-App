package ru.sportequipment.command.user;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.sportequipment.command.ActionCommand;
import ru.sportequipment.dto.SkatesListDTO;
import ru.sportequipment.entity.CommandRequest;
import ru.sportequipment.entity.CommandResponse;
import ru.sportequipment.entity.Session;
import ru.sportequipment.entity.Skates;
import ru.sportequipment.entity.enums.ResponseStatus;
import ru.sportequipment.exception.ApplicationException;
import ru.sportequipment.logic.SkatesLogic;
import ru.sportequipment.util.JsonUtil;

import java.util.List;

public class RefreshSkatesCommand implements ActionCommand {
    private static final Logger logger = LogManager.getLogger(RefreshSkatesCommand.class);

    @Override
    public CommandResponse execute(CommandRequest request, CommandResponse response, Session session) throws ApplicationException {
        SkatesLogic skatesLogic = new SkatesLogic();

        List<Skates> skatesList = skatesLogic.refreshBookingInfo();

        if (skatesList != null) {
            logger.debug(skatesList);
            SkatesListDTO skatesListDTO = new SkatesListDTO();
            skatesListDTO.setSkatesList(skatesList);
            return new CommandResponse(JsonUtil.serialize(skatesListDTO), ResponseStatus.OK);
        } else {
            return new CommandResponse("Skates not found", ResponseStatus.NOT_FOUND);
        }
    }
}
