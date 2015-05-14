package ru.peak.ml.apdk.service.apdk;

import ru.peak.ml.apdk.service.formatter.CancelFormatter;
import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.loyalty.message.Message;
import ru.peak.ml.loyalty.message.ResponseMessage;

/**
 *
 */
public class Cancel extends CommonApdkMessage {

    public Cancel(String serverAddress, int serverPort) {
        super(serverAddress, serverPort);
    }

    MessageFormatter formatter = new CancelFormatter();

    @Override
    public byte[] getData() {
        return new byte[0];
    }

    @Override
    public Message getNewApdkMessage() {
        ResponseMessage message = new ResponseMessage();

        message.setErrorDescription("EMULATION");
        return message;
    }

    @Override
    public MessageFormatter getFormatter() {
        return formatter;
    }
}
