package ru.peak.ml.apdk.service.apdk;

import lombok.Getter;
import lombok.Setter;
import ru.peak.ml.apdk.service.formatter.AccountFormatter;
import ru.peak.ml.apdk.service.formatter.MessageFormatter;
import ru.peak.ml.loyalty.message.ResponseMessage;

import javax.xml.bind.DatatypeConverter;

/**
 *
 */
public class Account extends CommonApdkMessage {

    public static final String OPERATION_TYPE = new String(new byte[]{49, 51});

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
    public ResponseMessage getNewApdkMessage() {
        ResponseMessage message = super.getNewApdkMessage();
        message.setCardIdentifier(DatatypeConverter.parseHexBinary(getCardHash()));

        message.setOperationType(OPERATION_TYPE);
        return message;
    }

    @Override
    public MessageFormatter getFormatter() {
        return formatter;
    }
}
