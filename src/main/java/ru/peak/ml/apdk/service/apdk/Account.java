package ru.peak.ml.apdk.service.apdk;

import lombok.Getter;
import lombok.Setter;
import ru.peak.ml.apdk.service.formatter.AccountFormatter;
import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.loyalty.message.Message;
import ru.peak.ml.loyalty.message.ResponseMessage;

/**
 *
 */
public class Account extends CommonApdkMessage {

    @Getter @Setter
    private String cardHash;

    MessageFormatter formatter = new AccountFormatter();

    public Account(String serverAddress, int serverPort) {
        super(serverAddress, serverPort);
    }

    @Override
    public byte[] getData() {
        return getNewApdkMessage().toArray();
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
